package testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By loginEmailAddressField = By.cssSelector(".login-form input:nth-child(2)");
    private By loginPasswordField = By.cssSelector(".login-form input:nth-child(3)");
    private By loginButton = By.cssSelector("btn:nth-child(4)");
    private By registerNameField = By.cssSelector(".signup-form input:nth-child(2)");
    private By registerEmailAddressField = By.cssSelector(".signup-form input:nth-child(3)");
    private By registerButton = By.cssSelector(".btn:nth-child(5)");
    private String workingEmail = "gtb51@microeconomicstextbook.com";
    private String workingPassword = "test";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getCurrentUrl().contains("login");
    }

    public void login(){
        webDriver.findElement(loginEmailAddressField).sendKeys(workingEmail);
        webDriver.findElement(loginPasswordField).sendKeys(workingPassword);
    }
}
