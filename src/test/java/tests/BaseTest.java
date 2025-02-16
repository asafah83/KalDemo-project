package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BasePage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        String browser = Utils.readProperty("browser");
        driver = DriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.get(Utils.readProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        handlePopup();
       LoginPage lp = new LoginPage(driver);
       lp.loginWithCredentialsFromConfig();
    }
    public void sleep(int miliSecond) throws InterruptedException {
        Thread.sleep(miliSecond);
    }

    public WebElement waitHelper(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @BeforeMethod
    public static void killChromeDriver() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
            System.out.println("ChromeDriver processes terminated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        killChromeDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            driver.quit();
            Thread.sleep(500);
        }
    }

    public void handlePopup() throws InterruptedException {
        BasePage bs = new BasePage(driver);
        bs.handlingWelcomeHomPopUp();
        bs.clickThePrimaryConnect();
    }

    /*
     * This method will run after each test,
     * it will take screenshot only for tests that failed
     */
    @AfterMethod
    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".jpg"));
                System.out.println("Screenshot saved for test case: " + result.getName());
            } catch (IOException e) {
                System.err.println("Failed to save screenshot: " + e.getMessage());
            }
        }
    }
}
