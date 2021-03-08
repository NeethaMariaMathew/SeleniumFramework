package pages;

import general.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Driver{
    @FindBy(css=".nav-link.text-white")
    private WebElement loginLink;
    @FindBy(xpath = "//a[@href='/t/bags']")
    private WebElement categoryBags;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickLogInLink()
    {
        loginLink.click();
    }
    public void clickCategoryBags()
    {
        categoryBags.click();
    }
}
