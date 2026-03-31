package tests;

import common.BaseTest;
import common.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FailTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testFail() {

        driver.get("https://example.com");

        // cố tình fail để test retry + screenshot
        Assert.assertTrue(false);
    }
}