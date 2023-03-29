package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class FourthTest extends BaseTest {

    @Test(priority = 2, description = "Сheck search work")
    @Severity(SeverityLevel.NORMAL)
    public void checkFavorite() {
        String search = "Жирафwfwqfw";
        mainPage.fillSearchInput(search).validateName(search);
    }

    @AfterClass
    public void closePage() {
        driver.quit();
    }
}
