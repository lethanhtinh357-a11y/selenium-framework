package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        // đọc biến môi trường CI
        boolean isCI = System.getenv("CI") != null;

        // đọc browser từ command line (CI truyền vào)
        if (browser == null || browser.isEmpty()) {
            browser = System.getProperty("browser", "chrome");
        }

        System.out.println("Running browser: " + browser);
        System.out.println("Running in CI: " + isCI);

        // setup Chrome
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        if (isCI) {
            // chạy trên GitHub Actions
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        } else {
            // chạy local
            options.addArguments("--start-maximized");
        }

        return new ChromeDriver(options);
    }
}