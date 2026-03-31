package tests;

import common.BaseTest;
import common.RetryAnalyzer;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLoginSuccess() {

        // mở trang demo
        driver.get("https://the-internet.herokuapp.com/login");

        // nhập username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        // nhập password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        // click login
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // verify login thành công
        String message = driver.findElement(By.id("flash")).getText();

        Assert.assertTrue(message.contains("You logged into a secure area!"));
    }
}