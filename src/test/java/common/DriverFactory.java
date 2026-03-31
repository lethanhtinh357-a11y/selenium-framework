package common;

import org.openqa.selenium.WebDriver;

// Chrome
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// Firefox
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        boolean isCI = System.getenv("CI") != null;

        if (browser == null || browser.isEmpty()) {
            browser = System.getProperty("browser", "chrome");
        }

        System.out.println("Running browser: " + browser);
        System.out.println("Running in CI: " + isCI);

        switch (browser.toLowerCase()) {

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffOptions = new FirefoxOptions();

                if (isCI) {
                    ffOptions.addArguments("--headless");
                    ffOptions.addArguments("--width=1920");
                    ffOptions.addArguments("--height=1080");
                }

                return new FirefoxDriver(ffOptions);

            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

                if (isCI) {
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--window-size=1920,1080");
                } else {
                    options.addArguments("--start-maximized");
                }

                return new ChromeDriver(options);
        }
    }
}