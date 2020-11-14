package guru99.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TablePage {
    AppiumDriver appiumDriver;
    WebDriverWait wait;

    @FindBy(css = "table[cellspacing]")
    private WebElement table;
    private By tableFind = By.cssSelector("table[cellspacing]");

    public TablePage(AppiumDriver driver) {
        this.appiumDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
        this.wait = new WebDriverWait(driver, 1000);
    }

    public boolean isTablePresent() throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableFind));
        return table.isDisplayed();
    }

    public String getPageTitle() {
        return appiumDriver.getTitle();
    }
}
