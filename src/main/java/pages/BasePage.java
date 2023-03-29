package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    public WebDriver driver;
    public Properties prop;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

    public WebDriver initialize_driver(String browser) {
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
            System.out.println("Firefox is launched");
        }
        else if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            chromeOptions.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(chromeOptions);
            System.out.println("Chrome is launched");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        tdriver.set(driver);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    public Properties initialize_Properties() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("/Users/user/IdeaProjects/untitled1/"
                    + "src/main/java/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

    protected void waitForElementVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementEnable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void timeSleep() {
        try {
            Thread.sleep(100000);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
