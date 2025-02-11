package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.ABTestingPage;
import pages.DropdownPage;

public class StepDefinitions extends BaseTest {
    HomePage homePage;
    ABTestingPage abTestingPage;
    DropdownPage dropdownPage;

    @Given("I launch the application {string}")
    public void iLaunchTheApplication(String url) {
        launchApplication(url);
        homePage = new HomePage(driver);
    }

    @Then("I verify the page title as {string}")
    public void iVerifyThePageTitleAs(String expectedTitle) {
        Assert.assertEquals(homePage.getPageTitle(), expectedTitle);
    }

    @When("I click on {string} link")
    public void iClickOnLink(String linkText) {
        homePage.clickLink(linkText);
    }

    @Then("I verify the text on the page as {string}")
    public void iVerifyTheTextOnThePageAs(String expectedText) {
        abTestingPage = new ABTestingPage(driver);
        Assert.assertEquals(abTestingPage.getHeadingText(), expectedText, "Text verification failed!");
    }

    @When("I navigate back to the home page")
    public void iNavigateBackToTheHomePage() {
        driver.navigate().back();
    }

    @When("I select {string} from the dropdown")
    public void iSelectFromTheDropdown(String option) {
        dropdownPage = new DropdownPage(driver);
        dropdownPage.selectDropdownOption(option);
    }

    @Then("I verify the selected option is {string}")
    public void iVerifyTheSelectedOptionIs(String expectedOption) {
        dropdownPage = new DropdownPage(driver);
        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertEquals(selectedOption, expectedOption, "Dropdown selection mismatch!");
    }

    @Then("I verify {string} nested link is displayed")
    public void iVerifyNestedIsDisplayed(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        Assert.assertTrue(link.isDisplayed(), linkText + " link is not displayed!");
    }
    
    @And("I verify {string} iframe link is displayed")
    public void iVerifyIFrameIsDisplayed(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        Assert.assertTrue(link.isDisplayed(), linkText + " link is not as displayed!");
    }

    @Then("I close the browser")
    public void iCloseTheBrowser() {
        closeBrowser();
    }
}
