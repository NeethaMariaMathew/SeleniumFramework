package pages;

import general.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(css = ".nav-link.text-white")
    private WebElement loginLink;
    @FindBys(@FindBy(css = "#taxonomies > div:nth-child(2) > *"))
    private List<WebElement> shopByCategory;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLogInLink() {
        loginLink.click();
    }

    public void selectCategory(String Category) {

        for (int i = 0; i < shopByCategory.size(); i++) {
            String s1 = shopByCategory.get(i).getText();
            if (s1.equals(Category))
                shopByCategory.get(i).click();
        }
    }

}



