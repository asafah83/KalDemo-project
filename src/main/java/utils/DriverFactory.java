package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Map;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--start-maximized", "--disable-notifications",
                "--disable-popup-blocking", "--disable-infobars", "--disable-autofill");
        options.setExperimentalOption("prefs", Map.of("autofill.profile_enabled", false));

        if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver(options);
        } else {
            throw new IllegalArgumentException("🔍 The browser isn't supported " + browser);
        }
    }
}

