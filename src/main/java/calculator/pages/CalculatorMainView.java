package calculator.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CalculatorMainView {

    AppiumDriver appiumDriver;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_2')]")
    public MobileElement digit2;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_3')]")
    public MobileElement digit3;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_add')]")
    public MobileElement plusButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'eq')]")
    public MobileElement equalButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'result')]")
    public MobileElement resultField;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'formula')]")
    public MobileElement clearedField;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_mul')]")
    public MobileElement multButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_0')]")
    public MobileElement digit0;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_sub')]")
    public MobileElement minusButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_5')]")
    public MobileElement digit5;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_pct')]")
    public MobileElement percentButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'clr')]")
    public MobileElement clearButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'point')]")
    public MobileElement point;

    public CalculatorMainView(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
    }

    public void clickDigit2() {
        digit2.click();
    }

    public void clickDigit3() {
        digit3.click();
    }

    public void clickPlusButton() {
        plusButton.click();
    }

    public void clickEqualButton() {
        equalButton.click();
    }

    public MobileElement getResultField() {

        return resultField;
    }

    public MobileElement getClearedField() {
        return clearedField;
    }

    public void clickMultiplyButton() {
        multButton.click();
    }

    public void clickDigit0() {
        digit0.click();
    }

    public void clickMinusButton() {
        minusButton.click();
    }

    public void clickDigit5() {
        digit5.click();
    }

    public void clickPercentButton() {
        percentButton.click();
    }

    public void clickClearButton() {
        clearButton.click();
    }

    public void clickPoint() {
        point.click();
    }

}
