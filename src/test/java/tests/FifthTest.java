package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class FifthTest extends BaseTest {
    @Test(priority = 1, description = "Check if the chosen picture is in the basket")
    @Severity(SeverityLevel.NORMAL)
    public void checkBasket() {
        String category = "Ювелирное искусство";
        int pictureNumber = 0;

        String picturePrice = mainPage.gotoCategory(category).getPicturePrice(pictureNumber);
        mainPage.homePage().gotoCategory(category).addPictureToBasket(pictureNumber).goToBasket().validatePriceOfPicture(pictureNumber, picturePrice);
    }

    @AfterClass
    public void closePage() {
        driver.quit();
    }
}
