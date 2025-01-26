import pytest
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager

@pytest.fixture
def setup():
    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service)
    driver.maximize_window()
    yield driver
    driver.quit()

def test_w3schools_logo(setup):
    driver = setup
    driver.get("https://www.w3schools.com/")

    logo = driver.find_element(By.ID, "w3-logo")
    assert logo.is_displayed(), "Logo not found on the page"
