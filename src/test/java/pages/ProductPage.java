package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#add-to-cart-button")
    private WebElement addToCartBtn;
    @FindBy(css="#quantity")
    private WebElement itemQuantity;

    public void clickAddToCartButton()
    {
        addToCartBtn.click();
    }
    public void updateItemQuantity(String quantity) throws InterruptedException {
        Thread.sleep(2000);
        itemQuantity.clear();
        itemQuantity.sendKeys(quantity);
    }
}
