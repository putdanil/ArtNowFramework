package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FourthTest extends BaseTest {

    // test case:
    // pre condition: open browser, url,
    // test steps -- test case : check search work
    // post step: close the browser

    @Test(priority = 2, description = "verifying that search works")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify search work")
    @Story("Story Name: To check valid search work")
    public void checkFavorite() {
        String search = "Жираф";
        mainPage.fillSearchInput(search).validateName(search);
    }

    @AfterMethod
    public void aftermethod() {
        driver.quit();
    }
}
