package pages;

import com.google.common.collect.Lists;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasketPage extends BasePage {
    @FindBy(css = "#main_container > div.c_row > div.c_cell > div.shop > div.price")
    List<WebElement> picturePrices;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Verify picture {0} prices {1}")
    public BasketPage validatePriceOfPicture(int id, List<String> prices) {
        waitForElementVisible(picturePrices.get(id-1));
        List<String> pricesText = new ArrayList<>();
        for (WebElement price : Lists.reverse(picturePrices.subList(0, id))
        ) {
            pricesText.add(price.getText());
        }
        Assert.assertEquals(pricesText, prices);
        return this;
    }
}
