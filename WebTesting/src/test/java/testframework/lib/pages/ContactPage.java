package testframework.lib.pages;

import org.openqa.selenium.Alert;
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

    public void enterName(String name) {
        webDriver.findElement(By.name("name")).sendKeys(name);
    }

    public void enterEmail(String email) {
        webDriver.findElement(By.name("email")).sendKeys(email);
    }

    public void enterSubject(String subject) {
        webDriver.findElement(By.name("subject")).sendKeys(subject);
    }

    public void enterMessage(String message) {
        webDriver.findElement(By.name("message")).sendKeys(message);
    }

    public void submit() {
        webDriver.findElement(By.name("submit")).click();
        handleConfirmAlert();
    }

    public String messageSuccess() {
        WebElement successMessage = webDriver.findElement(By.cssSelector(".status"));
        return successMessage.getText();
    }

    public void handleConfirmAlert() {
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
    }
}
