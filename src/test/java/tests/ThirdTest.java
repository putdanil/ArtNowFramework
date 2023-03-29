package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ThirdTest extends BaseTest {

    @Test(priority = 1, description = "Сheck favorites work")
    @Severity(SeverityLevel.NORMAL)
    public void checkFavorite() {
        String category = "Батик";
        String name = mainPage.gotoCategory(category).getFirstPictureName();
        mainPage.homePage().gotoCategory(category).addFirstToFavorite().goToFavorite().validateName(name);
    }

    @AfterClass
    public void closePage() {
        driver.quit();
    }

}
