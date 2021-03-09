package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="#summary-order-total")
    private WebElement orderAmount;


    public double getOrderAmount()
    {
        String s = orderAmount.getText();
        String amount = s.substring(1);
        double d=Double.parseDouble(amount);
        return d;
    }

}
