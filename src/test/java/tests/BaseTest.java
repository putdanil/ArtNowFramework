package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import pages.BasePage;
import pages.MainPage;

import java.util.Properties;

abstract public class BaseTest {
    protected WebDriver driver;
    BasePage basePage;
    MainPage mainPage;
    Properties prop;

    @BeforeClass
    public void setUp() {
        basePage = new BasePage();
        prop = basePage.initialize_Properties();
        driver = basePage.initialize_driver(prop.getProperty("browser"));
        mainPage = new MainPage(driver);
    }
}
