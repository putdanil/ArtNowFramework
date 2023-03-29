package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FavoritePage extends BasePage {

    @FindBy(css = "#sa_container > div.post > a:nth-child(1) > div")
    WebElement firstFavoriteName;

    public FavoritePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Verify favorite picture name {0}")
    public FavoritePage validateName(String name) {
        Assert.assertEquals(firstFavoriteName.getText(), name);
        return this;
    }
}
