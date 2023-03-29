package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest {

    // test case:
    // pre condition: open browser, url,
    // test steps -- test case : check picture genre
    // post step: close the browser

    @Test(priority = 2, description = "verifying picture genre")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify picture genre")
    @Story("Story Name: To check that picture genre is valid")
    public void checkRealism() {
        String category = "Вышитые картины";
        String genre = "Реализм";
        mainPage.gotoCategory(category).filterByGenre().goToPictureTram().validateGenre(genre);
    }

    @AfterMethod
    public void aftermethod() {
        driver.quit();
    }
}
