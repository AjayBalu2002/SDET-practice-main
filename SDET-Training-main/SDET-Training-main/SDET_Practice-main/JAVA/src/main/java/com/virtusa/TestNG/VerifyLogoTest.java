package com.virtusa.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyLogoTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "src/main/driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.makemytrip.com/");
    }

    @Test
    public void verifyLogoPresence() {
        try {
            boolean isLogoDisplayed = driver.findElement(By.xpath("//a[@class='mmtLogo makeFlex']")).isDisplayed();
            Assert.assertTrue(isLogoDisplayed, "Logo is not displayed on the MakeMyTrip homepage.");
        } catch (Exception e) {
            Assert.fail("An exception occurred while verifying the logo: " + e.getMessage());
        }
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}