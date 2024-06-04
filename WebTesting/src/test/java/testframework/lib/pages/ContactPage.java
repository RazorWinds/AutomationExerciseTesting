package testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage extends BasePage{

    public ContactPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getTitle().equals("Automation Exercise - Contact Us");
    }

    public String getTitle() {
        WebElement headingElement = webDriver.findElement(By.cssSelector(".title:nth-child(2)"));
        return headingElement.getText();
    }
}
