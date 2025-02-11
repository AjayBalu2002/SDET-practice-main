package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    WebDriver driver;
    
    // Constructor
    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the dropdown element
    private By dropdown = By.id("dropdown");

    // Method to select an option from the dropdown
    public void selectDropdownOption(String optionText) {
        WebElement dropdownElement = driver.findElement(dropdown);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(optionText);
    }

    // Method to get the selected option from the dropdown
    public String getSelectedOption() {
        WebElement dropdownElement = driver.findElement(dropdown);
        Select select = new Select(dropdownElement);
        return select.getFirstSelectedOption().getText();
    }
}
