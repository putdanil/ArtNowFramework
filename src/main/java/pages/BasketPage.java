package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BasketPage extends BasePage {
    @FindBy(css = "#main_container > div.c_row > div.c_cell > div.shop > div.price")
    List<WebElement> picturePrices;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Verify picture price {0}")
    public BasketPage validatePriceOfPicture(int id, String price) {
        waitForElementVisible(picturePrices.get(id));
        Assert.assertEquals(picturePrices.get(id).getText(), price);
        return this;
    }
}
