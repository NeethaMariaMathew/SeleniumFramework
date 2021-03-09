package pages;

import general.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BagsPage extends BasePage {
    @FindBy(css="label[for='Price_Range_$15.00_-_$18.00']")
    private WebElement price15_18;
    @FindBy(css="#sidebar_products_search>input[type='submit']")
    private WebElement searchFilter;
    @FindBy(css="//h1[text()='Bags']")
    private WebElement bagsHeader;
    @FindBys(@FindBy (css="d#products>div"))
    private List<WebElement> bagsProducts;
    @FindBys(@FindBy(css=".navigation>ul>li"))
    private List<WebElement> priceRange;
    @FindBys(@FindBy(css = "#products>div"))
    private List<WebElement> filteredProducts;

    public BagsPage(WebDriver driver) {
        super(driver);
    }

    public void selectPriceRange(String PriceRange) throws InterruptedException {
        for (int i = 0; i < priceRange.size(); i++) {
            String s1 = priceRange.get(i).getText();
            if(s1.contains(PriceRange))
                priceRange.get(i).click();
        }
    }

    public void clickSearch()
    {
        searchFilter.click();
    }
    public Boolean verifyFilteredProducts(double lp,double up) throws InterruptedException {
       for (int i = 0; i < filteredProducts.size(); i++) {
            String s1 = filteredProducts.get(i).getText();
        String[] lines = s1.split("\\n");
        String line2 = lines[1];
        String price=line2.substring(1);
        double d = Double.parseDouble(price);
        if(!(d>=lp && d<=up))
            return false;
        }
       return true;
    }

}
