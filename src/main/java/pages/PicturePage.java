package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PicturePage extends BasePage {
    @FindBy(css = "#main_container > div:nth-child(3) > div.infocontainer > div:nth-child(9) > a")
    WebElement genreName;

    public PicturePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Verify picture genre {0}")
    public PicturePage validateGenre(String genre) {
        Assert.assertEquals(genreName.getText(), genre);
        return this;
    }
}
