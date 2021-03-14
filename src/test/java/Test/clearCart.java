package Test;

import general.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class clearCart extends Driver {
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
        ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".delete")));
        shoppingCart.deleteItemCart();
        Assert.assertEquals(shoppingCart.getAlertText(),"Your cart is empty");
    }


}
