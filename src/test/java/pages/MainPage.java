package pages;

import org.checkerframework.checker.interning.qual.FindDistinct;
import org.example.Main;
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

    public MainPage() {
        driver.get("https://artnow.ru/");
        PageFactory.initElements(driver, this);
    }

    public CategoryPage gotoCategory(String category) {
        showmoreButton.click();
        if (category.equalsIgnoreCase("Вышитые картины")) {
            embroidPictures.click();
        } else if (category.equalsIgnoreCase("Батик")) {
            batik.click();

        } else if (category.equalsIgnoreCase("Ювелирное искусство")) {
            embroidPictures.click();
        }

        return new CategoryPage();
    }

    public SearchPage fillSearchInput(String input) {
        searchInput.sendKeys(input);
        searchButton.click();
        return new SearchPage();
    }
}
