package Test;
import general.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

import static org.testng.Assert.assertEquals;

public class verifyLoginTest extends Driver {



@Test
    public void login() throws InterruptedException {
    HomePage home = new HomePage(driver);
    home.clickLogInLink();
    LoginPage login = new LoginPage(driver);
    login.setUserName();
    login.setLoginPassword();
    login.clickLogInButton();
    MyAccountPage myaccount = new MyAccountPage(driver);
    assertEquals(myaccount.getLoginMsg(),"Logged in successfully");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/logout']")));
    myaccount.clickLogOutButton();
    assertEquals(myaccount.getLogOutMsg(),"Signed out successfully.");
}
}
