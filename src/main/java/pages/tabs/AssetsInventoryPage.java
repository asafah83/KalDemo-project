package pages.tabs;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;
import java.util.List;

public class AssetsInventoryPage extends BasePage {
    private int initialAdCount;

    public AssetsInventoryPage(WebDriver driver) throws InterruptedException {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Count the number of the Ads")
    public void countAdsBefore() {
        WebElement countElementBefore = driver.findElement(By.cssSelector("[class='jet-engine-query-count query-2 count-type-total']"));
        String text = countElementBefore.getText();
        initialAdCount = Integer.parseInt(text.trim());
        System.out.println("📊 The Ads number after the new created Ad: " + initialAdCount);
      //  List<WebElement> adsNumber = driver.findElements(By.xpath("//div[contains(@class,'jet-listing-grid_item')]"));
        System.out.println("Number of Ads is: " + initialAdCount);
      //  return adsNumber.size();
    }
    @Step("Testing if the new created Ad was added successfully to Ads list, in the main page")
    public void verifyAdAdded() {
        driver.navigate().refresh(); // Page refresh to verify the reloading data
        WebElement countElementAfter = driver.findElement(By.cssSelector("[class='jet-engine-query-count query-2 count-type-total']"));
        String text = countElementAfter.getText();
        int finalCount = Integer.parseInt(text.trim());
        System.out.println("📊 The Ads number after the new created Ad: " + finalCount);

        if (finalCount == initialAdCount + 1) {
            System.out.println("✅ The test is success. The Ad is added successfully!");
        } else {
            throw new AssertionError("❌ Failure. The Ads number wasn't increased as expected!");
        }
    }
}
