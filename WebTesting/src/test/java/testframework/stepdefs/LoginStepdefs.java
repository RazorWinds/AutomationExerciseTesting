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

    @Given("Given: I am on the login signup page of Automation Exercises")
    public void givenIAmOnTheLoginSignupPageOfAutomationExercises() {
        webDriver.get("https://automationexercise.com/login");
        loginPage = new LoginPage(webDriver);

    }

    @And("I have previously made an account")
    public void iHavePreviouslyMadeAnAccount() {
        loginPage.setWorkingEmail("gtb51@microeconomicstextbook.com");
        loginPage.setWorkingPassword("test");
    }

    @When("I input my details into the fields")
    public void iInputMyDetailsIntoTheFields() throws InterruptedException {
        webDriver.findElement(By.className("fc-button-label")).click();
        loginPage.enterLoginDetails();
        Thread.sleep(5000);
    }

    @And("I press the login button")
    public void iPressTheLoginButton() {
        homePage = loginPage.clickLogin();
    }

    @Then("I will be logged in")
    public void iWillBeLoggedIn() {
        MatcherAssert.assertThat(homePage.getTitle(), is("Automation Exercise"));
    }


}
