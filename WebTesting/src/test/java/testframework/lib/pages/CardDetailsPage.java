package testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CardDetailsPage extends BasePage{
    public CardDetailsPage(WebDriver webDriver){
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getTitle().equals("Automation Exercise - Payment");
    }

    public void clearBasket(){
        List<WebElement> buttons = webDriver.findElements(By.className("cart_quantity_delete"));
        buttons.forEach(WebElement::click);
    }

    public  void enterCardDetailsInvalid(){
        webDriver.findElement(By.name("name_on_card")).sendKeys("fdd");
        webDriver.findElement(By.name("card_number")).sendKeys("hhh");
        webDriver.findElement(By.name("cvc")).sendKeys("hhh");
        webDriver.findElement(By.name("expiry_month")).sendKeys("hh");
        webDriver.findElement(By.name("expiry_year")).sendKeys("hhhh");
    }

    public  void enterCardDetailsValid(){
        webDriver.findElement(By.name("name_on_card")).sendKeys("String Valid Here");
        webDriver.findElement(By.name("card_number")).sendKeys("1234567891234567");
        webDriver.findElement(By.name("cvc")).sendKeys("311");
        webDriver.findElement(By.name("expiry_month")).sendKeys("23");
        webDriver.findElement(By.name("expiry_month")).sendKeys("12");
        webDriver.findElement(By.name("expiry_year")).sendKeys("2027");

    }   

    public void confirm(){
        webDriver.findElement(By.id("submit")).click();
    }
}
