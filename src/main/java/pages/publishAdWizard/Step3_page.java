package pages.publishAdWizard;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;
import java.util.List;

public class Step3_page extends BasePage {
    @FindBy(css = "[name='asset_description']")
    WebElement assetDescriptionTextBox;
    @FindBy(xpath = "(//button[contains(text(),'הבא')])[3]")
    WebElement next3button;

    public Step3_page(WebDriver driver) throws InterruptedException {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Select the Asset attribute by Giving the attribute name")
    public void selectAssetAttributeByName(String attributeValue) {
        try {
            selectSpecificValueFromListByXpath("//div[contains(@class, 'ff-el-form-check')]", attributeValue);
            System.out.println("attribute '" + attributeValue + "' Selected successfully");
        } catch (Exception e) {
            System.out.println("Error in the attribute selection '" + attributeValue + "': " + e.getMessage());
        }
    }

    @Step("Describe the asset")
    public void setAssetDescription(String assetDescriptionText) {
        fillText(assetDescriptionTextBox, assetDescriptionText);
    }

    @Step("Click on theNext button")
    public void clickNext3() {
        click(next3button);
    }
}
