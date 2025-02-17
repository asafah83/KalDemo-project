package pages.publishAdWizard;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class Step5_page extends BasePage {
    @FindBy(css = "input[type='file']")
    WebElement input;
    @FindBy(xpath = "(//button[contains(text(),'הבא')])[5]")
    WebElement next5Button;

    public Step5_page(WebDriver driver) throws InterruptedException {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Uploading an image file for the asset")
    public void uploadImage(String filePath) {
        input.sendKeys(filePath);
    }

    @Step("Click on the Next button")
    public void clickNext5Button() {
        click(next5Button);
    }
}