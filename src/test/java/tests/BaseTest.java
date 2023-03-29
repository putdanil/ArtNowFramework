package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import pages.MainPage;

import java.time.Duration;

abstract public class BaseTest {
    protected WebDriver driver;
    MainPage mainPage;

    @BeforeClass
    public void startBrowser(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage = new MainPage(driver);
        this.setDriverToContext(context, driver);
    }

    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver){
        iTestContext.setAttribute("WebDriver", driver);
    }

    public static WebDriver getDriverFromContext(ITestContext iTestContext){
        return (WebDriver) iTestContext.getAttribute("WebDriver") ;
    }
}
