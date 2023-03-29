package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;
@Listeners({TestListener.class})
public class SecondTest extends BaseTest {

    @Test(priority = 2, description = "Сheck picture genre")
    @Severity(SeverityLevel.NORMAL)
    public void checkRealism() {
        String category = "Вышитые картины";
        String genre = "Реализfwfwfм";
        mainPage.gotoCategory(category).filterByGenre().goToPictureTram().validateGenre(genre);
    }

    @AfterClass
    public void closePage() {
        driver.quit();
    }
}
