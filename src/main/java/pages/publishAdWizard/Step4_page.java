package pages.publishAdWizard;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class Step4_page extends BasePage {
    @FindBy(css = "[name='credits']")
    WebElement numberOfPaymentsField;
    @FindBy(css = "[name='house_committee']")
    WebElement houseCommitmentField;
    @FindBy(css = "[name='tax_asset']")
    WebElement taxAssetField;
    @FindBy(css = "[name='price']")
    WebElement priceField;
    @FindBy(css = "[name='date_start']")
    WebElement datePickerField;
    @FindBy(xpath = "(//button[contains(text(),'הבא')])[4]")
    WebElement next4Button;

    public Step4_page(WebDriver driver) throws InterruptedException {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Set the number of payments")
    public void setNumberOfPayments(String numberOfPaymentsValue) {
        fillText(numberOfPaymentsField, numberOfPaymentsValue);
    }
    @Step("Set the house commitment ['ועד בית']")
    public void setHouseCommitment(String houseCommitmentValue) {
        fillText(houseCommitmentField, houseCommitmentValue);
    }
    @Step("Set the asset tax ['ארנונה'] ")
    public void setTaxAsset(String taxAssetValue) {
        fillText(taxAssetField, taxAssetValue);
    }
    @Step("Set the asset price")
    public void setPrice(String priceValue) {
        fillText(priceField, priceValue);
    }
    @Step("Select an asset release date")
    public void selectDate(String year, String month, String day) {
        waitForElement(datePickerField);
        click(datePickerField); //[class="flatpickr-innerContainer"]
        WebElement yearField = driver.findElement(By.cssSelector("input[class='numInput cur-year']"));
        fillText(yearField, year);
        WebElement monthField = driver.findElement(By.cssSelector("[aria-label='Month']"));
        selectFromListByVisibleText(month, monthField);
        selectSpecificValueFromListByXpath("//span[@class='flatpickr-day']", day);
    }
    @Step("Click on the Next button")
    public void clickNext4button() {
        click(next4Button);
    }

}


