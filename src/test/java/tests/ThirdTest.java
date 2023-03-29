package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ThirdTest extends BaseTest {

    // test case:
    // pre condition: open browser, url,
    // test steps -- test case : check favorite page
    // post step: close the browser

    @Test(priority = 1, description = "verifying favorites")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify favorite page")
    @Story("Story Name: To check that valid picture is in favorites")
    public void checkFavorite() {
        String category = "Батик";
        String name = mainPage.gotoCategory(category).getFirstPictureName();
        mainPage.homePage().gotoCategory(category).addFirstToFavorite().goToFavorite().validateName(name);
    }

    @AfterMethod
    public void aftermethod() {
        driver.quit();
    }
}
