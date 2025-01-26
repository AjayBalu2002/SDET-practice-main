package com.virtusa.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectOneWayTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testOneWayFlightSelection() {
        try {
            try {
                WebElement body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
                body.click();
            } catch (Exception e) {
                System.out.println("No overlay found.");
            }

            // Close login modal pop-up if present
            try {
                WebElement loginPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='loginModal displayBlock']")));
                WebElement closeButton = loginPopup.findElement(By.xpath("//span[@class='langCardClose']"));
                closeButton.click();
            } catch (Exception e) {
                System.out.println("No login pop-up found.");
            }

            // Click on the Flights section
            WebElement flightsTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Flights')]")));
            flightsTab.click();

            // Select One Way trip
            WebElement oneWayRadio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-cy='oneWayTrip']")));
            oneWayRadio.click();

            // Enter the FROM location
            WebElement fromCityInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='fromCity']")));
            fromCityInput.click();
            WebElement fromSearchInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
            fromSearchInput.sendKeys("Mumbai");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'Mumbai, India')]"))).click();

            // Enter the TO location
            WebElement toCityInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='toCity']")));
            toCityInput.click();
            WebElement toSearchInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='To']")));
            toSearchInput.sendKeys("Delhi");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'Delhi, India')]"))).click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        // Quit the browser
        if (driver != null) {
            driver.quit();
        }
    }
}