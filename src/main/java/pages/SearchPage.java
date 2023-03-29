package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPage extends BasePage {
    @FindBy(css = "#sa_container > div:nth-child(3) > a:nth-child(1) > div")
    WebElement firstPicture;

    public WebDriver testdriver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.testdriver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchPage validateName(String name) {
        waitForElementVisible(firstPicture);
        Assert.assertTrue(firstPicture.getText().contains(name));
        return this;
    }
}
