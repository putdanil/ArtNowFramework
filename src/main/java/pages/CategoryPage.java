package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends BasePage {
    @FindBy(css = "#genre257")
    WebElement cityScape;

    @FindBy(css = "#applymsg")
    WebElement applyFilter;

    @FindBy(css = "#sa_container > div > a > div")
    List<WebElement> pictureNames;

    @FindBy(css = "div.post:nth-child(5) > a:nth-child(1) > img:nth-child(3)")
    WebElement tramPath;

    @FindBy(css = "#genrebox > span.dot.control.float-l.showextra > span.openclose")
    WebElement showAllButton;

    @FindBy(css = "#sa_container > div:nth-child(3) > div.heart")
    WebElement favoriteFirst;

    @FindBy(css = "#sa_container > div:nth-child(3) > a:nth-child(1) > div")
    WebElement favotiteFirstInfo;

    @FindBy(css = "body > div.topheader > span.fvtico > img")
    WebElement favoriteButton;

    @FindBy(css = "#sa_container > div > a > div.oclick")
    List<WebElement> basketButtons;

    @FindBy(css = "#close-button")
    WebElement closeButton;

    @FindBy(css = "#sa_container > div > div.price")
    List<WebElement> picturePrices;

    @FindBy(css = "body > div.topheader > span.basketico > img")
    WebElement basketPageButton;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Step("Filter pictures by genre")
    public CategoryPage filterByGenre() {
        waitForElementEnable(cityScape);
        cityScape.click();
        waitForElementEnable(applyFilter);
        applyFilter.click();
        return this;
    }

    @Step("Open picture 'Tram' page")
    public PicturePage goToPictureTram() {
        waitForElementEnable(tramPath);
        tramPath.click();
        return new PicturePage(driver);
    }

    @Step("Add first picture to favorite")
    public CategoryPage addFirstToFavorite() {
        waitForElementEnable(favoriteFirst);
        favoriteFirst.click();
        return this;
    }

    @Step("Open favorites page")
    public FavoritePage goToFavorite() {
        waitForElementEnable(favoriteButton);
        favoriteButton.click();
        return new FavoritePage(driver);
    }

    @Step("Get first picture name")
    public String getFirstPictureName() {
        waitForElementVisible(favotiteFirstInfo);
        return favotiteFirstInfo.getText();
    }

    @Step("Add picture {0} to the basket")
    public CategoryPage addPictureToBasket(int id) {
        waitForElementVisible(basketButtons.get(id-1));
        List<WebElement> picturesForBasket = basketButtons.subList(0, id);
        for (WebElement picture: picturesForBasket
             ) {
            picture.click();
            waitForElementEnable(closeButton);
            closeButton.click();
        }
        return this;
    }

    @Step("Get {0} picture price")
    public List<String> getPicturePrice(int id) {
        waitForElementVisible(picturePrices.get(id-1));
        List<String> pricesText = new ArrayList<>();
        for (WebElement price : picturePrices.subList(0, id)
        ) {
            pricesText.add(price.getText());
        }
        return pricesText;
    }

    @Step("Open basket page")
    public BasketPage goToBasket() {
        waitForElementEnable(basketPageButton);
        basketPageButton.click();
        return new BasketPage(driver);
    }

    @Step("Verify picture name {0}")
    public CategoryPage validateTitle(String title) {
        String allPictureNames = "";
        for (WebElement name : pictureNames
        ) {
            allPictureNames += name.getText();
        }
        Assert.assertTrue(allPictureNames.contains(title));
        return this;
    }
}
