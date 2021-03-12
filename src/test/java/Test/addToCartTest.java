package Test;

import general.Driver;
import general.Screenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class addToCartTest extends Driver {
    @Test
    public void addProductsToCart() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickLogInLink();
        LoginPage login = new LoginPage(driver);
        login.login("sample@yahoo.com","pwd123");
        SearchPage search = new SearchPage(driver);
        search.search("Ruby on Rails Mug");
        search.clickSearch();
        double amount = search.selectItemFromSearchResults("Ruby on Rails Mug");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCartButton();
        Thread.sleep(5000);
        ShoppingCartPage cart = new ShoppingCartPage(driver);
        cart.clickCheckOutBtn();
        CheckOutPage checkOutPage=new CheckOutPage(driver);
        double orderTotal = checkOutPage.getOrderAmount();
        Assert.assertEquals(amount,orderTotal);
    }
}
