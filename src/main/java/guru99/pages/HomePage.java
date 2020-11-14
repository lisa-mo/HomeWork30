package guru99.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    AppiumDriver appiumDriver;

    @FindBy(css = "form[name='frmLogin']")
    private WebElement loginForm;
    @FindBy(css = "a[href*='newtours']")
    private WebElement newTourButton;
    @FindBy(css = "a[href*='Agile']")
    private WebElement agileProjectButton;
    @FindBy(css = "a.dropdown-toggle")
    private WebElement seleniumDropDown;
    @FindBy(css = "a[href*='table']")
    private WebElement tableDemoLink;

    public HomePage(AppiumDriver driver) {
        this.appiumDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
    }

    public void navigate() throws Exception {
        appiumDriver.get("http://demo.guru99.com");
    }

    public boolean isElementPresent() {
        return loginForm.isDisplayed();
    }

    public void clickOnNewToursButton() {
        newTourButton.click();
    }

    public void clickOnTableDemoLink() {
        seleniumDropDown.click();
        tableDemoLink.click();
    }

    public void clickOnAgileProjectButton() throws InterruptedException {
        agileProjectButton.click();
    }

    public String getPageTitle() {
        return appiumDriver.getTitle();
    }

}
