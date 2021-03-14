package Test;

import general.Driver;
import general.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class addToCart extends Driver {
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
        ShoppingCartPage cart = new ShoppingCartPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#checkout-link")));
        cart.clickCheckOutBtn();
        CheckOutPage checkOutPage=new CheckOutPage(driver);
        double orderTotal = checkOutPage.getOrderAmount();
        Assert.assertEquals(amount,orderTotal);
    }
}
