package Test;

import general.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BagsPage;
import pages.HomePage;

public class verifyFilterTest extends Driver {
    @Test
    public void Filter() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.selectCategory("Bags");
        BagsPage bags=new BagsPage(driver);
        bags.selectPriceRange("$15.00 - $18.00");
        bags.clickSearch();
        Boolean result = bags.verifyFilteredProducts(15.00,18.00);
        Assert.assertTrue(result);
    }
}
