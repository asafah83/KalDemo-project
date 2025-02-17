package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--start-maximized", "--disable-notifications",
                "--disable-popup-blocking", "--disable-infobars", "--disable-autofill");
        options.setExperimentalOption("prefs", Map.of("autofill.profile_enabled", false));
        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriver(options);
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

//        if (browser.equalsIgnoreCase("chrome")) {
//            return new ChromeDriver(options);
//        } else {
//            throw new IllegalArgumentException("🔍 The browser isn't supported " + browser);
//        }
    }
}

