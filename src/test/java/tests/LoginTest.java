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

        // mở trang demo
        driver.get("https://the-internet.herokuapp.com/login");

        // lấy username/password từ ENV (GitHub Secrets)
        String username = ConfigReader.getUsername();
        String password = ConfigReader.getPassword();

        System.out.println("Username: " + username);
        System.out.println("Password: " + password); // sẽ bị *** trên CI

        // nhập username
        driver.findElement(By.id("username")).sendKeys(username);

        // nhập password
        driver.findElement(By.id("password")).sendKeys(password);

        // click login
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // verify login thành công
        String message = driver.findElement(By.id("flash")).getText();

        Assert.assertTrue(message.contains("You logged into a secure area!"));
    }
}