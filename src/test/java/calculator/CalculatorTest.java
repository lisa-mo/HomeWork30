package calculator;

import calculator.pages.CalculatorMainView;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertEquals;

// Create tests for Calculator in emulator of mobile device. Verify operations:
// sum, multiplication, percentage of number (add operations of cleaning of fields,
// use integer and fractional numbers)
public class CalculatorTest {

    AppiumDriver appiumDriver;
    CalculatorMainView calculatorMainView;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 30");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");

//        URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");
        URL serverAddress = new URL("http://127.0.0.1:4723/wd/hub");

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1000);
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        appiumDriver = new AndroidDriver(serverAddress, capabilities);
        calculatorMainView = new CalculatorMainView(appiumDriver);
    }

    @Test
    public void summTest() throws Exception {
        calculatorMainView.clickDigit2();
        calculatorMainView.clickPlusButton();
        calculatorMainView.clickDigit3();
        calculatorMainView.clickEqualButton();
        assertEquals("5", calculatorMainView.getResultField().getText());
        calculatorMainView.clickClearButton();
        assertEquals("", calculatorMainView.getClearedField().getText());
    }

    @Test
    public void multiplyTest() throws Exception {
        calculatorMainView.clickDigit2();
        calculatorMainView.clickMultiplyButton();
        calculatorMainView.clickDigit3();
        calculatorMainView.clickEqualButton();

        assertEquals("6", calculatorMainView.getResultField().getText());
        calculatorMainView.clickClearButton();
        assertEquals("", calculatorMainView.getClearedField().getText());
    }

    @Test
    public void percentageIntTest() throws Exception {
        calculatorMainView.clickDigit2();
        calculatorMainView.clickDigit0();
        calculatorMainView.clickMinusButton();
        calculatorMainView.clickDigit5();
        appiumDriver.rotate(ScreenOrientation.LANDSCAPE);
        calculatorMainView.clickPercentButton();
        calculatorMainView.clickEqualButton();

        assertEquals("19", calculatorMainView.getResultField().getText());
        calculatorMainView.clickClearButton();
        assertEquals("", calculatorMainView.getClearedField().getText());
    }

    @Test
    public void percentageFractionalTest() throws Exception {
        calculatorMainView.clickDigit2();
        calculatorMainView.clickDigit0();
        calculatorMainView.clickMinusButton();
        calculatorMainView.clickDigit5();
        calculatorMainView.clickPoint();
        calculatorMainView.clickDigit5();
        appiumDriver.rotate(ScreenOrientation.LANDSCAPE);
        calculatorMainView.clickPercentButton();
        calculatorMainView.clickEqualButton();

        assertEquals("18.9", calculatorMainView.getResultField().getText());
        calculatorMainView.clickClearButton();
        assertEquals("", calculatorMainView.getClearedField().getText());
    }

    @AfterClass
    public void tearDown() {
        appiumDriver.quit();
    }

}
