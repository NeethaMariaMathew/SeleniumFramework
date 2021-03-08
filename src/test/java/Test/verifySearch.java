package Test;

import general.Driver;
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
        assertEquals(searchPage.getSearchResultText(),"Search results for 'Ruby'");
        Boolean result = searchPage.verifySearchResultProducts("Ruby");
        assertTrue(result);
        searchPage.clearSearchField();
        searchPage.search("Apache");
        searchPage.clickSearch();
        assertEquals(searchPage.getSearchResultText(),"Search results for 'Apache'");
        result = searchPage.verifySearchResultProducts("Apache");
        assertTrue(result);
    }


}
