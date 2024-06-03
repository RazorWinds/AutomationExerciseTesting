package testframework.lib.pages;

import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getTitle().equals("Automation Exercise");
    }

    public ProductsPage clickOnWomenCategory() {
        webDriver.findElement(By.cssSelector(".panel:nth-child(1)")).click();
        WebElement itemCategoryLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#Women li:nth-child(1)")));
        itemCategoryLink.click();
        return new ProductsPage(webDriver);
    }

//    public ProductsPage clickOnCategory(String catName) {
//        webDriver.findElement(By.xpath("//a[text()='" + catName + "']")).click();
//        return new ProductsPage(webDriver);
//    }
//
//    public ProductsPage clickOnCategoryItem(String itemCat) {
//        webDriver.findElement(By.xpath("//a[text()='" + itemCat + "']")).click();
//        return new ProductsPage(webDriver);
//    }
}