import pytest
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By

# Define pytest fixture for WebDriver setup and cleanup
@pytest.fixture(scope="module")
def driver():
    # Specify the path to chromedriver.exe
    service = Service(r"D:\Softwares\chrome driver\chromedriver-133\chromedriver.exe")  # Remove the extra ')'
 # Use raw string (r"") to avoid escaping backslashes
    driver = webdriver.Chrome(service=service)
    driver.get("http://the-internet.herokuapp.com/")  # Open the home page
    yield driver  # Yield the driver to the test cases
    driver.quit()  # Cleanup: Close the browser after the tests

# 1. Test: Verify the title of the home page
def test_verify_title(driver):
    assert driver.title == "The Internet"

# 2. Test: Click on "Checkboxes" link and verify checkbox states
def test_checkbox_link(driver):
    # Click on Checkboxes link
    checkboxes_link = driver.find_element(By.LINK_TEXT, "Checkboxes")
    checkboxes_link.click()

    # Verify the text on the page
    page_text = driver.find_element(By.TAG_NAME, "h3").text
    assert page_text == "Checkboxes"

    # Verify checkbox states: Checkbox 1 should be unchecked, Checkbox 2 should be checked
    checkbox1 = driver.find_element(By.XPATH, "//input[@type='checkbox'][1]")
    checkbox2 = driver.find_element(By.XPATH, "//input[@type='checkbox'][2]")

    # Assertion: Checkbox 1 is unchecked
    assert not checkbox1.is_selected()

    # Assertion: Checkbox 2 is checked
    assert checkbox2.is_selected()

    # Uncheck checkbox 2 and check checkbox 1 (just an example to interact)
    checkbox2.click()  # Uncheck checkbox 2
    checkbox1.click()  # Check checkbox 1

    # Re-assert the states
    assert not checkbox2.is_selected()  # Checkbox 2 should be unchecked
    assert checkbox1.is_selected()  # Checkbox 1 should be checked

# 3. Test: Navigate back to the home page and click on "File Upload"
def test_file_upload(driver):
    # Navigate back to home page
    driver.back()

    # Click on File Upload link
    file_upload_link = driver.find_element(By.LINK_TEXT, "File Upload")
    file_upload_link.click()

    # Verify the text on the File Upload page
    page_text = driver.find_element(By.TAG_NAME, "h3").text
    assert page_text == "File Uploader"

    # Select the file to upload (change the file path as needed)
    choose_file_button = driver.find_element(By.ID, "file-upload")
    upload_button = driver.find_element(By.ID, "file-submit")

    # Specify the path to the file you want to upload
    file_path = r"E:\SDET Assignment\Project\CapStone\Selenium_With_Python\test.txt"
  # Make sure the file path is correct

    # Upload the file
    choose_file_button.send_keys(file_path)

    # Click the Upload button
    upload_button.click()

    # Optionally, verify the file upload success message
    success_message = driver.find_element(By.TAG_NAME, "h3").text
    assert success_message == "File Uploaded!"
