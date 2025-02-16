package pages.publishAdWizard;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class Step1_page extends BasePage {
    @FindBy(css = "[name='asset_type']")
    WebElement propertyTypeField;
    @FindBy(css = "[name='asset_status']")
    WebElement assetStatusField;
    @FindBy(css = "[name='city']")
    WebElement cityField;
    @FindBy(css = "[name='street_1']")
    WebElement streetNameField;
    @FindBy(css = "[name='street_number']")
    WebElement houseNumberField;
    @FindBy(css = "[class='progressBar fluentform-step active'] [data-action='next']")
    WebElement nextButton1;

    public Step1_page(WebDriver driver) throws InterruptedException {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Step("Select the type of the asset")
    public void selectAssetType(String typeValue) {
        getSleep(1000);
        selectFromListByValue(typeValue, propertyTypeField);
    }

    @Step("Select the status of the asset")
    public void selectAssetStatus(String statusValue) {
        selectFromListByValue(statusValue, assetStatusField);
    }

    @Step("Select a city and set streetName if required or select other city without street")
    public void selectCityAndHandleStreet(String cityNameValue, String streetNameValue, String houseNumberValue) {
        // finding the city field
        Select citySelect = new Select(cityField);
        citySelect.selectByVisibleText(cityNameValue);

        // short waiting to give the UI be updated
        try { Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("This" + streetNameValue + "Doesn't exist on the list");
        }

        // Checking if the street name appears
        boolean isStreetDisplayed = driver.findElements(By.xpath("//select[@name='street_1']")).size() > 0;

        if (isStreetDisplayed) {
            // if the street name field appears - select a street
            Select streetSelect = new Select(streetNameField);
            streetSelect.selectByVisibleText(streetNameValue);
        }
        fillText(houseNumberField, houseNumberValue);
    }

    @Step("Click on the Next button")
    public void clickNext1() {
        click(nextButton1);
    }
}
