package Test;

import general.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class clearCartTest extends Driver {
    @Test
    public void removeItemsFromCart() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickLogInLink();
        LoginPage login = new LoginPage(driver);
        login.login("sample@yahoo.com","pwd123");
        SearchPage search = new SearchPage(driver);
        search.search("Ruby on Rails Mug");
        search.clickSearch();
        double amount = search.selectItemFromSearchResults("Ruby on Rails Mug");
        ProductPage productPage = new ProductPage(driver);
        productPage.updateItemQuantity("3");
        productPage.clickAddToCartButton();
        Thread.sleep(5000);
        ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
        shoppingCart.deleteItemCart();
        Assert.assertEquals(shoppingCart.getAlertText(),"Your cart is empty");
    }


}
