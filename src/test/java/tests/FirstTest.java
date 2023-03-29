package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({utils.TestListener.class})
public class FirstTest extends BaseTest {

    @Test(priority = 1, description = "Сheck picture name")
    @Severity(SeverityLevel.NORMAL)
    public void checkTram() {
        String category = "Вышитые картины";
        String title = "Трамвайный путьdwdwdw";
        mainPage.gotoCategory(category).filterByGenre().validateTitle(title);
    }

    @AfterClass
    public void closePage() {
        driver.quit();
    }
}
