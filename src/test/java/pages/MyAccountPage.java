package pages;

import general.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class MyAccountPage extends Driver {


    @FindBy (xpath="//a[@href='/logout']")
    private WebElement logoutbtn;
    @FindBy (css="#keywords")
    private WebElement searchfield;
    @FindBy (xpath="//input[@type='submit']")
    private WebElement searchbtn;
    @FindBy (css =".alert.alert-success")
    private WebElement loginMsg;
    @FindBy (css =".alert.alert-notice")
    private WebElement logOutMsg;
    public MyAccountPage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    public void clickLogOutButton()
    {
        logoutbtn.click();
    }
    public String getLoginMsg()
    {
        return loginMsg.getText();
    }
    public String getLogOutMsg()
    {
        return logOutMsg.getText();
    }
    public void search(String item)
    {
        searchfield.sendKeys(item);
    }
    public void clickSearch()
    {
        searchbtn.click();
    }

}
