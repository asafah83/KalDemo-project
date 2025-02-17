package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) throws InterruptedException {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Select a tab By giving his name")
    public void selectTabByName(String tabName) {
        WebElement navMenu = driver.findElement(By.cssSelector("[class='elementor-nav-menu']"));
        List<WebElement> tabs = navMenu.findElements(By.tagName("li"));
        String targetTab = tabName;
        for (WebElement tab : tabs) {
            if (tab.getText().contains(targetTab)) {
                tab.click();
                break;
            }
        }
    }
}