package pages.publishAdWizard;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class Step6_page extends BasePage {
    @FindBy(css = "[name='name_full']")
    WebElement fullNameField;
    @FindBy(css = "[name='phone_number']")
    WebElement phoneNumberField;
    @FindBy(css = "[type='submit']")
    WebElement publishAssetButton;

    public Step6_page(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Step("Set the full name")
    public void setFullName(String fullNameValue) {
        fillText(fullNameField, fullNameValue);
    }

    @Step("Ste the phone number")
    public void setPhoneNumber(String phoneNumberValue) {
        fillText(phoneNumberField, phoneNumberValue);
    }
    @Step("Click on the 'Publish asset' button")
    public void clickThePublishButton() {
        click(publishAssetButton);
    }
}
