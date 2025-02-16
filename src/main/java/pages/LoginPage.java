package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(css = "[type='submit']")
    WebElement connectPrimaryButton;
    @FindBy(css = "#user-d21758b")
    WebElement userNameField;
    @FindBy(css = "#password-d21758b")
    WebElement passwordField;
    @FindBy(css = "[data-elementor-type='popup'] [type='submit']")
    WebElement connectionButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void loginToWebsite(String userNameValue, String passwordValue) throws InterruptedException {
        fillText(userNameField, userNameValue);
        fillText(passwordField, passwordValue);
        waitHelper(By.xpath("//span[contains(text(),'התחברות')]"));
        click(connectionButton);
    }

    @Step("Login using the test user credentials")
    public void loginWithCredentialsFromConfig() throws InterruptedException {
        String username = Utils.readProperty("username");
        String password = Utils.readProperty("password");
        loginToWebsite(username, password);
    }

}




