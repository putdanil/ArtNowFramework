package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class FifthTest extends BaseTest {

    // test case:
    // pre condition: open browser, url,
    // test steps -- test case : check pictures in the basket
    // post step: close the browser

    @Test(priority = 1, description = "verifying that the chosen picture is in the basket")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify that the chosen picture is in the basket")
    @Story("Story Name: To check pictures in the basket")
    @Parameters("number")
    public void checkBasket(int number) {
        String category = "Ювелирное искусство";

        List<String> picturePrice = mainPage.gotoCategory(category).getPicturePrice(number);
        mainPage.homePage().gotoCategory(category).addPictureToBasket(number).goToBasket().validatePriceOfPicture(number, picturePrice);
    }

    @AfterMethod
    public void aftermethod() {
        driver.quit();
    }
}
