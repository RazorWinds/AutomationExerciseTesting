package testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver webDriver){
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

    public  void checkOut(){
        By locator = By.linkText("Proceed To Checkout");
        wait.until(ExpectedConditions.visibilityOfElementLocated (locator));
        WebElement element = webDriver.findElement(locator);
        Actions builder = new Actions(webDriver);
        builder.scrollToElement(element).moveToElement(element);

        webDriver.findElement(locator).click();
    }

}
