package testframework.lib.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

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

    private void handleConfirmAlert() {
        try {
            Alert alert = webDriver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getEmailFieldValidationMessage() {
        WebElement emailInput = webDriver.findElement(By.name("email"));
        return emailInput.getAttribute("validationMessage");
    }

    public String getNameFieldValidationMessage() {
        WebElement emailInput = webDriver.findElement(By.name("name"));
        return emailInput.getAttribute("validationMessage");
    }

    public String getMessageFieldValidationMessage() {
        WebElement emailInput = webDriver.findElement(By.name("message"));
        return emailInput.getAttribute("validationMessage");
    }

    public boolean emailValidation(String email) {
        String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        return email.matches(regex);
    }
}
