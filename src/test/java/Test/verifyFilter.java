package Test;

import general.Driver;
import org.testng.annotations.Test;
import pages.BagsPage;
import pages.HomePage;

public class verifyFilter extends Driver {
    @Test
            public void Filter() {
        HomePage homepage = new HomePage(driver);
        homepage.clickCategoryBags();
        BagsPage bags=new BagsPage(driver);
        bags.priceSelect();
        bags.clickSearch();
    }
}
