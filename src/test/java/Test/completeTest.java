package Test;

import general.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
@Listeners(general.Listener.class)
public class completeTest extends Driver {
    @Test(priority = 1)
    public void login() throws InterruptedException, IOException {
        HomePage home = new HomePage(driver);
        home.clickLogInLink();
        LoginPage login = new LoginPage(driver);
        login.login("sample@yahoo.com", "pwd123");
        MyAccountPage myaccount = new MyAccountPage(driver);
        Assert.assertEquals(myaccount.getLoginMsg(), "Logged in successfully", "Login message not correct");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/logout']")));
        myaccount.clickLogOutButton();
        Assert.assertEquals(myaccount.getLogOutMsg(), "Signed out successfully.", "Logout message is incorrect");
    }

    @Test(priority = 2)
    public void searchRuby() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search("Ruby");
        searchPage.clickSearch();
        Assert.assertEquals(searchPage.getSearchResultText(), "Search results for 'Ruby'", "Incorrect search results message");
        Boolean result = searchPage.verifySearchResultProducts("Ruby");
        Assert.assertTrue(result, "Incorrect item displayed in search");
        searchPage.clearSearchField();
        searchPage.search("Apache");
        searchPage.clickSearch();
        Assert.assertEquals(searchPage.getSearchResultText(), "Search results for 'Apache'", "Incorrect search results message");
        result = searchPage.verifySearchResultProducts("Apache");
        Assert.assertTrue(result, "Incorrect item displayed in search");

    }

    @Test(priority = 3)
    public void Filter() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.selectCategory("Bags");
        BagsPage bags = new BagsPage(driver);
        bags.selectPriceRange("$15.00 - $18.00");
        bags.clickSearch();
        Boolean result = bags.verifyFilteredProducts(15.00, 18.00);
        Assert.assertTrue(result);
    }

    @Test(priority = 4)
    public void removeItemsFromCart() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickLogInLink();
        LoginPage login = new LoginPage(driver);
        login.login("sample@yahoo.com", "pwd123");
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
        Assert.assertEquals(shoppingCart.getAlertText(), "Your cart is empty");
    }

    @Test(priority = 5)
    public void addProductsToCart() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickLogInLink();
        LoginPage login = new LoginPage(driver);
        login.login("sample@yahoo.com", "pwd123");
        SearchPage search = new SearchPage(driver);
        search.search("Ruby on Rails Mug");
        search.clickSearch();
        double amount = search.selectItemFromSearchResults("Ruby on Rails Mug");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCartButton();
        ShoppingCartPage cart = new ShoppingCartPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#checkout-link")));
        cart.clickCheckOutBtn();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        double orderTotal = checkOutPage.getOrderAmount();
        Assert.assertEquals(amount, orderTotal);
    }

}

