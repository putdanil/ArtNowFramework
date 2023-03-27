package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.MainPage;

import java.io.UnsupportedEncodingException;

public class FirstTest extends BaseTest {
    @Test
    public void checkTram() throws UnsupportedEncodingException {
        String category = "Вышитые картины";
        String title = "Трамвайный путь";
        CategoryPage categoryPage = new MainPage().gotoCategory(category).filterByGenre();
        Assert.assertTrue(categoryPage.getPictureNames().toString().contains(title));
    }
}
