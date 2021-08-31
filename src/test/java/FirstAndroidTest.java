import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FirstAndroidTest {

    AppiumDriver driver;
    private static By addPlant = By.id("add_plant");
    private static By add = By.id("fab");

    @BeforeTest
    public void setUp() throws MalformedURLException {

        System.out.println("xxxxxxxx   "+System.getProperty("user.dir")+"\\src\\test\\resources\\app\\sampleBitrise.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "emulator-5554");
       // caps.setCapability("app", "C:\\Users\\user\\AndroidStudioProjects\\MyApplication\\app\\build\\outputs\\apk\\debug\\app-debug.apk");
        caps.setCapability("app", System.getProperty("user.dir")+"\\src\\test\\resources\\app\\sampleBitrise.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void test1() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        System.out.println("Session Id1 :+"+driver.getSessionId());
    }

    @Test
    public void test2() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        System.out.println("Session Id2 :+"+driver.getSessionId());
    }
    @Test
    public void test3() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        System.out.println("Session Id3 :+"+driver.getSessionId());
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
