package tests;

import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = common.RetryAnalyzer.class)
    public void testLogin() {

        driver.get("https://example.com");

        // cố tình fail để test retry
        Assert.assertTrue(false);
    }
}