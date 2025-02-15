package pages.publishAdWizard;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class Step3_page extends BasePage {
    @FindBy(css = "label[aria-label='גישה לנכים']")
    WebElement accessForCripplesOption;
    @FindBy(css = "label[aria-label='מיזוג']")
    WebElement airConditionOption;
    @FindBy(css = "label[aria-label='מטבח כשר']")
    WebElement kosherKitchenOption;
    @FindBy(css = "label[aria-label='חיות מחמד']")
    WebElement patsOption;
    @FindBy(css = "label[aria-label='מחסן']")
    WebElement storageOption;
    @FindBy(css = "label[aria-label='משופצת']")
    WebElement renovatedOption;
    @FindBy(css = "label[aria-label='ריהוט']")
    WebElement furnitureOption;
    @FindBy(css = "label[aria-label='סורגים']")
    WebElement securityBarsOption;
    @FindBy(css = "label[aria-label='דוד שמש']")
    WebElement solarHeaterOption;
    @FindBy(css = "label[aria-label='ממ&quot;ד']")
    WebElement safeRoomOption;
    @FindBy(css = "[name='asset_description']")
    WebElement assetDescriptionTextBox;
    @FindBy(xpath = "(//button[contains(text(),'הבא')])[3]")
    WebElement next3button;

    public Step3_page(WebDriver driver) throws InterruptedException {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Add the 'Access For Cripples' option")
    public void selectAccessForCripples() {
        click(accessForCripplesOption);
    }

    @Step("Add the 'Air Condition' option")
    public void selectAirConditionOption() {
        click(airConditionOption);
    }

    @Step("Add the 'Kosher Kitchen' option")
    public void selectKosherKitchenOption() {
        click(kosherKitchenOption);
    }

    public void selectPatsOption() {
        click(patsOption);
    }
    public void selectStorageOption() {
        click(storageOption);
    }
    public void selectRenovatedOption() {
        click(renovatedOption);
    }
    public void selectFurnitureOption() {
        click(furnitureOption);
    }
    public void selectSecurityBarsOption() {
        click(securityBarsOption);
    }
    public void selectSolarHeaterOption() {
        click(solarHeaterOption);
    }
    public void selectSafeRoomOption() {
        click(safeRoomOption);
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
