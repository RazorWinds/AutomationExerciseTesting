package testframework.lib.pages;

import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private By cartLink = new By.ByLinkText("Cart");
    private By contactLink = new By.ByLinkText("Contact us");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getTitle().equals("Automation Exercise");
    }

    public ProductsPage clickOnCategory(String catName, String itemCat) {
        webDriver.findElement(By.linkText(catName)).click();
        WebElement itemCategoryLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(itemCat)));
        itemCategoryLink.click();
        return new ProductsPage(webDriver);
    }

    public CartPage viewCart() {
        webDriver.findElement(cartLink).click();
        return new CartPage(webDriver);
    }

    public ContactPage viewContactPage() {
        webDriver.findElement(contactLink).click();
        return new ContactPage(webDriver);
    }
}