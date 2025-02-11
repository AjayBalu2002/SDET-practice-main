package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;

    public void launchApplication(String url) {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chrome driver\\chromedriver-133\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }


    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
