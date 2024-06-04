package testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver webDriver){
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getTitle().equals("Automation Exercise - Checkout");
    }

    public void clearBasket(){
        List<WebElement> buttons = webDriver.findElements(By.className("cart_quantity_delete"));
        buttons.forEach(WebElement::click);
    }

    public  void placeOrder(){
        webDriver.findElement(By.linkText("Place Order")).click();
    }
}
