package Test;

import general.Driver;
import org.testng.annotations.Test;
import pages.MyAccountPage;

public class verifySearch extends Driver {
    @Test
    public void searchRuby() {
        MyAccountPage myaccount = new MyAccountPage(driver);
        myaccount.search("Ruby");
        myaccount.clickSearch();
    }


}
