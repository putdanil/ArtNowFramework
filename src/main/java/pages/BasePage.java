package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BasePage {
    protected WebDriver driver;

    public void setDriver(WebDriver webDriver) {
        this.driver = webDriver;
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
