package tests;

import common.BaseTest;
import common.RetryAnalyzer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLoginSuccess() {

        // mở trang saucedemo (đúng với secret)
        driver.get("https://www.saucedemo.com/");

        // lấy từ GitHub Secrets
        String username = ConfigReader.getUsername();
        String password = ConfigReader.getPassword();

        System.out.println("Username: " + username);
        System.out.println("Password: " + password); // sẽ hiển thị *** trên CI

        // nhập username
        driver.findElement(By.id("user-name")).sendKeys(username);

        // nhập password
        driver.findElement(By.id("password")).sendKeys(password);

        // click login
        driver.findElement(By.id("login-button")).click();

        // verify login thành công
        boolean isInventoryDisplayed =
                driver.findElement(By.className("inventory_list")).isDisplayed();

        Assert.assertTrue(isInventoryDisplayed, "Login failed!");
    }
}