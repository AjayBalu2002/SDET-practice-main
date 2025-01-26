package com.virtusa.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MakeMyTripAutomation {

    
    public static WebDriver launchBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chrome driver\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }

    
    public static void interactWithElement(WebDriver driver, By locator, String action, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        
        if (action.equals("click")) {
            element.click();
        } else if (action.equals("sendKeys")) {
            element.sendKeys(text);
        }
    }

    
    public static void closeLoginPopup(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/div/section/span")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeButton);
            System.out.println("Login popup closed.");
        } catch (Exception e) {
            System.out.println("No login popup displayed or failed to close.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = launchBrowser("https://www.makemytrip.com/");

        // Close the login popup if it appears
        closeLoginPopup(driver);
        interactWithElement(driver, By.xpath("//span[text()='Flights']"), "click", null);
        interactWithElement(driver, By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[1]/ul/li[1]"), "click", null);
        interactWithElement(driver, By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/label/input"), "click", null);
        interactWithElement(driver, By.xpath("//input[@placeholder='From']"), "sendKeys", "Delhi");
        interactWithElement(driver, By.xpath("/html/body/div/div/div[2]/div/div/div/div/div[2]/div[1]/div[2]/label/input"), "click", null);
        interactWithElement(driver, By.xpath("//input[@placeholder='To']"), "sendKeys", "Mumbai");
        System.out.println("Test Passed Successfully");
        Thread.sleep(2000);

        driver.quit();
    }
}
