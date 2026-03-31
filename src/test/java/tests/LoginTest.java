package tests;

import common.BaseTest;
import common.RetryAnalyzer;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLoginSuccess() {

        // đúng site dùng credential từ Secrets
        driver.get("https://www.saucedemo.com/");

        String username = ConfigReader.getUsername();
        String password = ConfigReader.getPassword();

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        // verify login thành công
        boolean isDisplayed = driver.findElement(By.className("inventory_list")).isDisplayed();

        Assert.assertTrue(isDisplayed);
    }
}