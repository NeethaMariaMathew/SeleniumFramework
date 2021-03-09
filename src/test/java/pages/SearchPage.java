package pages;

import general.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {
    @FindBy (css="#keywords")
    private WebElement searchfield;
    @FindBy (xpath="//input[@type='submit']")
    private WebElement searchbtn;
    @FindBy(css=".search-results-title")
    private WebElement searchResultTxt;
    @FindBys(@FindBy (css="#products>div"))
    private List<WebElement> searchResultProducts;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultText()
    {
        return searchResultTxt.getText();
    }
    public Boolean verifySearchResultProducts(String SearchText)
    {
        int ntrue =0;
        int nfalse=0;
        for (int i=0;i<searchResultProducts.size();i++)
        {
            if (searchResultProducts.get(i).getText().contains(SearchText))
                ntrue = ntrue+1;
            else
                nfalse = nfalse+1;
        }
        if(nfalse==0 && ntrue==searchResultProducts.size())
            return true;
        else
            return false;
    }
    public void search(String item)
    {
        searchfield.sendKeys(item);
    }
    public void clickSearch()
    {
        searchbtn.click();
    }
    public void clearSearchField()
    {
        searchfield.clear();
    }

    public double selectItemFromSearchResults(String item)
    {
        String link = null;
        String value = null;
        for (int i=0;i<searchResultProducts.size();i++) {
            if (searchResultProducts.get(i).getText().contains(item)) {
                link = searchResultProducts.get(i).getText();
                String[] lines = link.split("\\n");
                String line1 = lines[0];
                driver.findElement(By.partialLinkText(line1)).click();
                 value = lines[1].substring(1);
            }
        }
        double amount = Double.parseDouble(value);
        return amount;
    }
}
