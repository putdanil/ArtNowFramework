package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    // test case:
    // pre condition: open browser, url,
    // test steps -- test case : check picture name
    // post step: close the browser

    @Test(priority = 1, description = "verifying picture name")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify picture name")
    @Story("Story Name: To check picture name")
    public void checkTram() {
        String category = "Вышитые картины";
        String title = "Трамвайный путь";
        mainPage.gotoCategory(category).filterByGenre().validateTitle(title);
    }

    @AfterMethod
    public void aftermethod() {
        driver.quit();
    }
}
