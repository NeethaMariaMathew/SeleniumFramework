package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class MyAccountPage extends BasePage {


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
    @FindBys(@FindBy (css="#products"))
    private List<WebElement> allProducts;

    public MyAccountPage(WebDriver driver) {
        super(driver);
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

}
