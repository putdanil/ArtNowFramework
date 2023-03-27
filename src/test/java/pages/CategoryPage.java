package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends BasePage {
    @FindBy(css = "#genre257")
    WebElement cityScape;

    @FindBy(css = "#applymsg")
    WebElement applyFilter;

    @FindBy(css = "#sa_container > div > a > div")
    List<WebElement> pictureNames;

    @FindBy(css = "#genrebox > span.dot.control.float-l.showextra > span.openclose")
    WebElement showAllButton;

    public CategoryPage() {
        PageFactory.initElements(driver, this);
    }

    public CategoryPage filterByGenre() {
        waitForElementEnable(cityScape);
        cityScape.click();
        waitForElementEnable(applyFilter);
        applyFilter.click();
        return this;
    }

    public List<String> getPictureNames() {
        List<String> names = new ArrayList<>();
        for (WebElement pictureName : pictureNames
        ) {
            names.add(pictureName.getText());
        }
        return names;
    }

}
