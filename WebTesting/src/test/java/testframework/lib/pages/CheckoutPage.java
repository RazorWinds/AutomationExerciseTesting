package testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        WebElement element = webDriver.findElement(By.linkText("Place Order"));

        Actions builder = new Actions(webDriver);
        builder.scrollByAmount(0,1000).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Place Order")));
        element.click();
    }
}
