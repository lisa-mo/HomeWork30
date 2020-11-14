package guru99.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewToursPage {
    AppiumDriver appiumDriver;
    WebDriverWait wait;

    @FindBy(css = "body>div>table")
    private WebElement mainFragment;
    private By mainFragmentFind = By.cssSelector("body>div>table");


    public NewToursPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
        this.wait = new WebDriverWait(driver, 1000);
    }

    public boolean isMainFragmentElementPresent() throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainFragmentFind));
        return mainFragment.isDisplayed();
    }

    public String getPageTitle() {
        return appiumDriver.getTitle();
    }
}
