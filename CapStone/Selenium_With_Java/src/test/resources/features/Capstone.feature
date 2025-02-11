Feature: Automate The Internet Heroku App

  Scenario: Validate UI functionalities
    Given I launch the application "http://the-internet.herokuapp.com/"
    Then I verify the page title as "The Internet"
    When I click on "A/B Testing" link
    Then I verify the text on the page as "A/B Test Variation 1"
    When I navigate back to the home page
    And I click on "Dropdown" link
    And I select "Option 1" from the dropdown
    Then I verify the selected option is "Option 1"
    When I navigate back to the home page
    And I click on "Frames" link
    Then I verify "Nested Frames" nested link is displayed
    And I verify "iFrame" iframe link is displayed
	Then I close the browser