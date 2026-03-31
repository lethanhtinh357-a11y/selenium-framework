package tests;

import common.BaseTest;
import common.RetryAnalyzer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLoginSuccess() {

        driver.get("https://www.saucedemo.com/");

        String username = ConfigReader.getUsername();
        String password = ConfigReader.getPassword();

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean isDisplayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list"))
        ).isDisplayed();

        Assert.assertTrue(isDisplayed, "Login failed!");
    }
}