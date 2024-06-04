package testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public CartPage(WebDriver webDriver){
        super(webDriver);
    }

    @Override
    public boolean isCorrectPage() {
        return webDriver.getTitle().contains("Checkout");
    }

    public String emptyCart() {
        WebElement headingElement = webDriver.findElement(By.cssSelector("b"));
        return headingElement.getText();
    }
}
