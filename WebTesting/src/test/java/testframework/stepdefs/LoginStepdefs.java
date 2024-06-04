package testframework.stepdefs;

import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import testframework.lib.pages.HomePage;
import testframework.lib.pages.LoginPage;
import testframework.lib.pages.SignUpPage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class LoginStepdefs extends StepDefsSuper{

    LoginPage loginPage;
    HomePage homePage;
    SignUpPage signUpPage;




    @Given("I am on the login signup page of Automation Exercises")
    public void iAmOnTheLoginSignupPageOfAutomationExercises() {
        webDriver.get("https://automationexercise.com/login");
        loginPage = new LoginPage(webDriver);

    }

    @And("I have previously made an account")
    public void iHavePreviouslyMadeAnAccount() {
        loginPage.setWorkingEmail("gtb51@microeconomicstextbook.com");
        loginPage.setWorkingPassword("test");
    }

    @When("I input my details into the fields")
    public void iInputMyDetailsIntoTheFields() {

        loginPage.enterLoginDetails();

    }

    @And("I press the login button")
    public void iPressTheLoginButton() {
        try{
            homePage = new HomePage(loginPage.clickLogin());
        }catch (Exception e){

        }
    }

    @Then("I will be logged in")
    public void iWillBeLoggedIn() {
        MatcherAssert.assertThat(homePage.getTitle(), is("Automation Exercise"));
    }

    @When("I input incorrect details into the fields")
    public void iInputIncorrectDetailsIntoTheFields()  {

        loginPage.setWorkingEmail("gtb51@microeconomicstextbook.com");
        loginPage.setWorkingPassword("Wrong test");
        loginPage.enterLoginDetails();
    }

    @Then("I will be shown an error message")
    public void iWillBeShownAnErrorMessage()  {
        MatcherAssert.assertThat(loginPage.checkErrorMsg(), is(true));
    }


    @Given("I am logged into Automation Exercises")
    public void iAmLoggedIntoAutomationExercises() {
        webDriver.get("https://automationexercise.com/login");
        loginPage = new LoginPage(webDriver);
        loginPage.setWorkingEmail("gtb51@microeconomicstextbook.com");
        loginPage.setWorkingPassword("test");
        loginPage.enterLoginDetails();
        homePage = new HomePage(loginPage.clickLogin());
    }

    @When("I press the log out button")
    public void iPressTheLogOutButton() {

        loginPage = homePage.clickLogout();
    }

    @Then("I will be logged out")
    public void iWillBeLoggedOut() {
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), containsString("login"));
    }

    @When("I Input my name and email and press signup")
    public void iInputMyNameAndEmailAndPressSignup() {
        loginPage.setWorkingName("Conner");
        loginPage.setWorkingEmail("qtb51@microeconomicstextbook.com");
        signUpPage = new SignUpPage(loginPage.enterSignUpDetails()) ;

    }

    @And("I input my address on the signup page")
    public void iInputMyAddressOnTheSignupPage() {
        signUpPage.setPassword("Test");
        signUpPage.setFirstName("Conner");
        signUpPage.setLastName("Sparta");
        signUpPage.setAddress("24 main street");
        signUpPage.setState("Northamptonshire");
        signUpPage.setCity("Northampton");
        signUpPage.setZipCode("NN5 3TR");
        signUpPage.setMobileNumber("01604208164");
        signUpPage.enterDetails();

    }

    @And("I press create account")
    public void iPressCreateAccount() {
        signUpPage.submitDetails();
    }

    @Then("My account will be created")
    public void myAccountWillBeCreated() {
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), containsString("account_created"));
    }


    @When("I Input my name and an invalid email and press signup")
    public void iInputMyNameAndAnInvalidEmailAndPressSignup() {
        loginPage.setWorkingName("Conner");
        loginPage.setWorkingEmail("qtb51.microeconomicstextbook.com");
        loginPage.enterSignUpDetails();

    }

    @Then("I will be given an error message stating invalid email")
    public void iWillBeGivenAnErrorMessageStatingInvalidEmail() {
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is(not("https://automationexercise.com/signup")));
    }

    @And("I input an invalid address on the signup page")
    public void iInputAnInvalidAddressOnTheSignupPage() {
        signUpPage.setPassword("Test");
        signUpPage.setFirstName("as");
        signUpPage.setLastName("sa");
        signUpPage.setAddress("as");
        signUpPage.setState("sa");
        signUpPage.setCity("as");
        signUpPage.setZipCode("sa");
        signUpPage.setMobileNumber("sa");
        signUpPage.enterDetails();
        signUpPage.submitDetails();
    }

    @Then("I will be given an error message stating invalid field")
    public void iWillBeGivenAnErrorMessageStatingInvalidField() {
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://automationexercise.com/signup"));
    }

    @When("I Input my name and email and press sign up")
    public void iInputMyNameAndEmailAndPressSignUp() {
        loginPage.setWorkingName("Conner");
        loginPage.setWorkingEmail("qtb52@microeconomicstextbook.com");
        signUpPage = new SignUpPage(loginPage.enterSignUpDetails()) ;
    }
}