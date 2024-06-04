package testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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

    public void clearBasket(){
        List<WebElement> buttons = webDriver.findElements(By.className("cart_quantity_delete"));
        buttons.forEach(WebElement::click);
    }

    public  void checkOut(){
        By locator = By.linkText("Proceed To Checkout");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = webDriver.findElement(locator);
        Actions builder = new Actions(webDriver);
        builder.scrollToElement(element).moveToElement(element).build().perform();

        webDriver.findElement(locator).click();
    }
}
