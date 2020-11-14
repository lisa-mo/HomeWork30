package guru99.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class AgileProjectPage {
    AppiumDriver appiumDriver;
    WebDriverWait wait;

    @FindBy(css = "marquee.heading3")
    private WebElement successMessage;
    private By userIdFind = By.cssSelector("input[name=uid]");
    private By passFind = By.cssSelector("input[name=password]");
    private By message = By.cssSelector("marquee.heading3");

    public AgileProjectPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
        this.wait = new WebDriverWait(driver, 1000);
    }

    public void inputUserID(String user) throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userIdFind)).sendKeys(user);
    }

    public void inputPassword(String pass) throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passFind)).sendKeys(pass + Keys.ENTER);
        sleep(1000);
    }

    public boolean isSuccessMessagePresent() throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        return successMessage.isDisplayed();
    }

    public String getAlertMessage() {
        return appiumDriver.switchTo().alert().getText();
    }
}
