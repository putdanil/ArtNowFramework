package pages;

import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {
    public SearchPage() {
        PageFactory.initElements(driver, this);
    }
}
