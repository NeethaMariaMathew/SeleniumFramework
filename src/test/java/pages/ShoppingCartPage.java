package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#checkout-link")
    private WebElement checkOutBtn;
    @FindBy(css=".delete")
    private WebElement deleteItem;
    @FindBy(css=".alert.alert-info")
    private WebElement alertMsg;

    public void clickCheckOutBtn()
    {
        checkOutBtn.click();
    }
    public void deleteItemCart()
    {
        deleteItem.click();
    }
    public String getAlertText()
    {
        return alertMsg.getText();
    }
}
