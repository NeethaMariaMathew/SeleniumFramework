package pages;

import general.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BagsPage extends Driver {
    @FindBy(css="label[for='Price_Range_$15.00_-_$18.00']")
    private WebElement price15_18;
    @FindBy(css="#sidebar_products_search>input[type='submit']")
    private WebElement searchFilter;
    @FindBy(css="//h1[text()='Bags']")
    private WebElement bagsHeader;
    @FindBys(@FindBy (css="div[data-hook='taxon_products']"))
    private List<WebElement> BagsProducts;

    public BagsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void priceSelect()
    {
        price15_18.click();
    }
    public void clickSearch()
    {
        searchFilter.click();
    }

}
