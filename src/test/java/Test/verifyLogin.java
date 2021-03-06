package Test;
import general.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class verifyLogin extends Driver {

@Test
    public void login() throws InterruptedException, IOException {
    HomePage home = new HomePage(driver);
    home.clickLogInLink();
    LoginPage login = new LoginPage(driver);
    login.login("sample@yahoo.com","pwd123");
    MyAccountPage myaccount = new MyAccountPage(driver);
    Assert.assertEquals(myaccount.getLoginMsg(),"Logged in successfully","Login message not correct");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/logout']")));
    myaccount.clickLogOutButton();
    Assert.assertEquals(myaccount.getLogOutMsg(),"Signed out successfully.","Logout message is incorrect");
}
}
