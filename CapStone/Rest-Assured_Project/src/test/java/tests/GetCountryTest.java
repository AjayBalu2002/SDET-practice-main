package tests;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;

import java.util.List;

public class GetCountryTest extends BaseTest {

    @DataProvider(name = "countryNames")
    public Object[][] getCountryNames() {
        List<String> countries = ExcelReader.readExcelData("src/resources/testData/CountryData.xlsx", "Countries");
        Object[][] data = new Object[countries.size()][1];
        for (int i = 0; i < countries.size(); i++) {
            data[i][0] = countries.get(i);
        }
        return data;
    }

    @Test(dataProvider = "countryNames")
    public void testGetCountryByTranslation(String translation) {
        Response response = RestAssured.get(translation);

        // Print response for debugging
        System.out.println("Response: " + response.asString());

        // Validate Response
        Assert.assertEquals(response.getStatusCode(), 200, "Invalid response code!");

        // Validate response contains country name
        Assert.assertTrue(response.asString().contains(translation), "Country translation mismatch!");
    }
}
