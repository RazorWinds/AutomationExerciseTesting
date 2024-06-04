package testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage extends BasePage{
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String state;
    private String city;
    private String zipCode;
    private String mobileNumber;
    private By passwordField = By.id("password");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By addressField = By.id("address1");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipCodeField = By.id("zipcode");
    private By numberField = By.id("mobile_number");
    private By submitButton = By.cssSelector(".btn:nth-child(22)");


    public SignUpPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getCurrentUrl().contains("signup");
    }

    public void enterDetails(){
        webDriver.findElement(passwordField).sendKeys(password);
        webDriver.findElement(firstNameField).sendKeys(firstName);
        webDriver.findElement(lastNameField).sendKeys(lastName);
        webDriver.findElement(addressField).sendKeys(address);
        webDriver.findElement(stateField).sendKeys(state);
        webDriver.findElement(cityField).sendKeys(city);
        webDriver.findElement(zipCodeField).sendKeys(zipCode);
        webDriver.findElement(numberField).sendKeys(mobileNumber);
    }

    public void submitDetails(){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        webDriver.findElement(submitButton).click();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
