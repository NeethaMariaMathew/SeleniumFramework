package Test;

import general.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.SearchPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class verifySearch extends Driver {
    @Test
    public void searchRuby() throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search("Ruby");
        searchPage.clickSearch();
        Assert.assertEquals(searchPage.getSearchResultText(),"Search results for 'Ruby'","Incorrect search results message");
        Boolean result = searchPage.verifySearchResultProducts("Ruby");
        Assert.assertTrue(result,"Incorrect item displayed in search");
        searchPage.clearSearchField();
        searchPage.search("Apache");
        searchPage.clickSearch();
        Assert.assertEquals(searchPage.getSearchResultText(),"Search results for 'Apache'","Incorrect search results message");
        result = searchPage.verifySearchResultProducts("Apache");
        Assert.assertTrue(result,"Incorrect item displayed in search");

    }


}
