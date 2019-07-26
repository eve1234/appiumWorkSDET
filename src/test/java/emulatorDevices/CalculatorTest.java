package emulatorDevices;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorTest {
	
	
	
	public  static void main(String [] args) throws MalformedURLException, InterruptedException {
		
		WebElement seven, five, manus,thesum;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		
		
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL url =new URL("http://127.0.0.1:4723/wd/hub");
		
		//interact with webElements
		//opens url then install app into device by using capabilities
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url,cap);
		
		Thread.sleep(5000);
		
		
		seven=driver.findElementById("com.android.calculator2:id/digit_7");
		seven.click();
		manus=driver.findElementById("com.android.calculator2:id/op_sub");
				manus.click();
		five=driver.findElementById("com.android.calculator2:id/digit_5");
		five.click();
		driver.findElementById("com.android.calculator2:id/eq").click();//click on manus sign
		 //thesum
		 String theResult=driver.findElementById("com.android.calculator2:id/formula").getText();
		//thesum.click();
		 if (theResult.equals("2")) {
			 System.out.println("Results is as expected");
		 }
		 else {
		 System.out.println("Results wrong");
		 }
		Assert.assertEquals("2",theResult);
		Thread.sleep(3000);
		driver.quit();
	
	}

}
