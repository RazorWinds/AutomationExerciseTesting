package testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver webDriver){
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getTitle().contains("Products");
    }

    public String getHeading() {
        WebElement headingElement = webDriver.findElement(By.cssSelector(".title"));
        return headingElement.getText();
    }
}
