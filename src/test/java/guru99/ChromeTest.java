package guru99;

import com.google.common.collect.ImmutableMap;
import guru99.pages.AgileProjectPage;
import guru99.pages.HomePage;
import guru99.pages.NewToursPage;
import guru99.pages.TablePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChromeTest {

    AppiumDriver appiumDriver;
    HomePage homePage;
    NewToursPage newToursPage;
    TablePage tablePage;
    AgileProjectPage agileProjectPage;

    String rightUser = "1303";
    String rightPass = "Guru99";
    String wrongUser = "111";
    String wrongPass = "xyz";
    String wrongCredAlert = "User or Password is not valid";
    String homePageTitle = "Guru99 Bank Home Page";
    String newToursPageTitle = "Welcome: Mercury Tours";
    String tablePageTitle = "Table Demo";

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 30");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1000);
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        capabilities.setCapability("chromedriverExecutableDir", "C:\\Users\\Brainstormer\\.m2\\repository\\webdriver\\chromedriver\\win32\\83.0.4103.14");

        URL serverAddress = new URL("http://127.0.0.1:4723/wd/hub");

        appiumDriver = new AndroidDriver(serverAddress, capabilities);
        homePage = new HomePage(appiumDriver);
        newToursPage = new NewToursPage(appiumDriver);
        tablePage = new TablePage(appiumDriver);
        agileProjectPage = new AgileProjectPage(appiumDriver);
    }

    @BeforeMethod
    public void goToMainURL() throws Exception {
        homePage.navigate();
    }

    @Test
    public void wagileProjectHappyLogin() throws Exception {
        homePage.clickOnAgileProjectButton();
        agileProjectPage.inputUserID(rightUser);
        agileProjectPage.inputPassword(rightPass);
        assertTrue(agileProjectPage.isSuccessMessagePresent());
    }

    @Test
    public void wagileProjectUnhappyLogin() throws Exception {
        homePage.clickOnAgileProjectButton();
        agileProjectPage.inputUserID(wrongUser);
        agileProjectPage.inputPassword(wrongPass);
        assertEquals(wrongCredAlert, agileProjectPage.getAlertMessage());
    }

    @Test
    public void homePageTitleTest() throws Exception {
        assertTrue(homePage.getPageTitle().contains(homePageTitle));
        assertTrue(homePage.isElementPresent());
    }

    @Test
    public void newToursPageTitleTest() throws Exception {
        homePage.clickOnNewToursButton();
        assertTrue(newToursPage.getPageTitle().contains(newToursPageTitle));
        assertTrue(newToursPage.isMainFragmentElementPresent());
    }

    @Test
    public void tablePageTitleTest() throws Exception {
        homePage.clickOnTableDemoLink();
        assertTrue(tablePage.getPageTitle().contains(tablePageTitle));
        assertTrue(tablePage.isTablePresent());
    }

    @AfterClass
    public void tearDown() {
        appiumDriver.quit();
    }
}
