package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(css = "i[class ='fa fa-angle-down']")
    WebElement showmoreButton;

    @FindBy(css = "#left_container > div > ul:nth-child(2) > li:nth-child(8)")
    WebElement embroidPictures;

    @FindBy(css = "#left_container > div > ul:nth-child(2) > li:nth-child(3)")
    WebElement batik;

    @FindBy(css = "#left_container > div > ul:nth-child(2) > li:nth-child(5)")
    WebElement jewelryArt;

    @FindBy(css = "#MainSearchForm > div > div:nth-child(1) > input.inp.scLarge")
    WebElement searchInput;

    @FindBy(css = "#MainSearchForm > div > div:nth-child(2) > button")
    WebElement searchButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://artnow.ru/");
        PageFactory.initElements(this.driver, this);
    }

    public CategoryPage gotoCategory(String category) {
        waitForElementVisible(showmoreButton);
        showmoreButton.click();
        if (category.equalsIgnoreCase("Вышитые картины")) {
            waitForElementVisible(embroidPictures);
            embroidPictures.click();
        } else if (category.equalsIgnoreCase("Батик")) {
            waitForElementVisible(batik);
            batik.click();
        } else if (category.equalsIgnoreCase("Ювелирное искусство")) {
            waitForElementVisible(jewelryArt);
            jewelryArt.click();
        }

        return new CategoryPage(driver);
    }

    public SearchPage fillSearchInput(String input) {
        waitForElementEnable(searchInput);
        searchInput.sendKeys(input);
        waitForElementEnable(searchButton);
        searchButton.click();
        return new SearchPage(driver);
    }

    public MainPage homePage() {
        this.driver.get("https://artnow.ru/");
        return this;
    }
}
