import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FirstAndroidTest {

    AppiumDriver driver;
    private static By addPlant = By.id("add_plant");
    private static By add = By.id("fab");

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("app", System.getProperty("user.dir")+"//src//test//resources//app//sampleBitrise.apk");
       // caps.setCapability("app", System.getenv("BITRISE_APK_PATH"));
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

    }

    public WebElement waitForVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.ignoring(ElementNotVisibleException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isWebElementVisible(By locator) {
        try {
            WebElement elm = waitForVisible(locator);
            return elm.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }
    SoftAssert softAssert=new SoftAssert();
    @Test(priority = 1,description = "validate Hello World! text")
    public void test1(Method method) {
        softAssert.assertTrue(isWebElementVisible(By.xpath("//*[@text='Hello World!']")), "Hello World! does not displayed");
        String methodName=method.getName();
        System.out.println(methodName+ " : Pass");
        softAssert.assertAll();
    }

    @Test(priority = 2,description = "validate Hello text")
    public void test2(Method method) {
        softAssert.assertTrue(isWebElementVisible(By.xpath("//*[@text='Hello']")), "Hello does not displayed");
        String methodName=method.getName();
        System.out.println(methodName+ " : Fail");
        softAssert.assertAll();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
