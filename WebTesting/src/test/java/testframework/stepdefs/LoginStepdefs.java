package testframework.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import testframework.lib.pages.HomePage;
import testframework.lib.pages.LoginPage;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class LoginStepdefs extends StepDefsSuper{

    LoginPage loginPage;
    HomePage homePage;


    @BeforeAll
    public static void beforeAll() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(DRIVER_LOCATION))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @Before
    public void setup() {
        webDriver = new RemoteWebDriver(service.getUrl(), getChromeOptions());
    }

    @After
    public void afterEach() {
        webDriver.quit();
    }

    @AfterAll
    public static void afterAll() {
        service.stop();
    }

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
        webDriver.findElement(By.className("fc-button-label")).click();
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
        webDriver.findElement(By.className("fc-button-label")).click();
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
        webDriver.findElement(By.className("fc-button-label")).click();
        loginPage.setWorkingEmail("gtb51@microeconomicstextbook.com");
        loginPage.setWorkingPassword("test");
        loginPage.enterLoginDetails();
        homePage = new HomePage(loginPage.clickLogin());
    }

    @When("I press the log out button")
    public void iPressTheLogOutButton() throws InterruptedException {
        Thread.sleep(5000);
        loginPage = homePage.clickLogout();
    }

    @Then("I will be logged out")
    public void iWillBeLoggedOut() {
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), containsString("login"));
    }
}
