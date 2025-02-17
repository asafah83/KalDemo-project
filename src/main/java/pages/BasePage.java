package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // we will add, into the constructor, the page factory, once.
        PageFactory.initElements(driver, this);
    }

    public void clearCookiesAndCache() {
        try {
            // Clear all the cookies
            driver.manage().deleteAllCookies();
            System.out.println("✅ כל ה-Cookies נמחקו בהצלחה.");

            // Refresh the page to reset the fields, etc.
            driver.navigate().refresh();

            // Waiting for verifying of reload
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));
            System.out.println("🔄 הדף רוענן וה-cache נוקה בהצלחה.");

        } catch (Exception e) {
            System.err.println("⚠️ כשלון בניקוי ה-Cookies או ה-Cache.");
            e.printStackTrace();
        }
    }

    @Step("Click on the 'Publish Ad' button")
    public void clickOnPublishAdButton() throws InterruptedException {
        Thread.sleep(1000);
        String elementButton = ".elementor-button-text";
        String requiredButtonText = "פרסם מודעה";
        selectSpecificValueFromListByCssSelector(elementButton, requiredButtonText);
    }

    public void waitForElement(WebElement el) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    public void selectSpecificValueFromListByCssSelector(String element, String textValue) {
        List<WebElement> list = driver.findElements(By.cssSelector(element));
        for (WebElement el : list) {
            waitForElement(el);
            if (el.getText().equalsIgnoreCase(textValue)) {
                click(el);
                break;
            }
        }
    }

    public void selectSpecificValueFromListByXpath(String element, String textValue) {
        List<WebElement> list = driver.findElements(By.xpath(element));
        for (WebElement el : list) {
            waitForElement(el);
            if (el.getText().equals(textValue)) {
                click(el);
                break;
            }
        }
    }

    public void fillText(WebElement el, String text) {
        waitForElement(el);
        highlightElement(el, "yellow");
        el.clear();
        el.sendKeys(text);
    }

    public void click(WebElement el) {
        waitForElement(el);
        highlightElement(el, "yellow");
        el.click();
    }

    public String getText(WebElement el) {
        waitForElement(el);
        highlightElement(el, "yellow");
        return el.getText();
    }

    public void selectFromListByValue(String value, WebElement el) {
        Select select = new Select(el);
        select.selectByValue(value);
    }

    public void selectFromListByVisibleText(String value, WebElement el) {
        Select select = new Select(el);
        select.selectByVisibleText(value);
    }


    public void getSleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void highlightElement(WebElement element, String color) {
        //keep the old style to change it back
        String originalStyle = element.getAttribute("style");
        String newStyle = "background-color: yellow;border: 1px solid " + color + ";" + originalStyle;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Change the style
        js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
                element);

        // Change the style back after few miliseconds
        js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
                + originalStyle + "');},400);", element);

    }

    public WebElement waitHelper(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public void handlingWelcomeHomPopUp() {
        WebElement welcomePopup = waitHelper(By.cssSelector(".dialog-widget-content.dialog-lightbox-widget-content.animated"));
        WebElement termAgreedButton = driver.findElement(By.xpath("(//span[contains(text(),'אני מסכים לתנאי השימוש באתר')])"));
        click(termAgreedButton);
        getSleep(1500);
    }

    public void clickThePrimaryConnect() {
        waitHelper(By.xpath("//span[contains(text(),'התחבר')][1]"));
        WebElement topConnectButton = driver.findElement(By.xpath("//span[contains(text(),'התחבר')][1]"));
        click(topConnectButton);
    }
}

