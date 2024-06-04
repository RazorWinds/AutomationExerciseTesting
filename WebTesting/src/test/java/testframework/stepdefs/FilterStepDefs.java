package testframework.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import testframework.lib.pages.HomePage;

import java.io.File;
import java.io.IOException;

public class FilterStepDefs extends StepDefsSuper{
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

    @Given("I am on the home page")
    public void iAmOnTheHomePage(){
        webDriver.get("https://automationexercise.com/");
        homePage = new HomePage(webDriver);
    }

    @When("I click the WOMEN option in the categories menu")
    public void iClickTheWOMENOptionInTheCategoriesMenu() {
        var categoryMenuWomen = webDriver.findElement(By.linkText(" Women "));
        categoryMenuWomen.click();
    }

    @And("I click the DRESS option in the dropdown menu that opens")
    public void iClickTheDRESSOptionInTheDropdownMenuThatOpens() {
        var categoryMenuWomenDress = webDriver.findElement(By.linkText("Dress"));
        categoryMenuWomenDress.click();
    }

    @Then("I should be taken to the page for Women's dresses")
    public void iShouldBeTakenToThePageForWomenSDresses() {
        Assertions.assertEquals(webDriver.getTitle(),"Automation Exercise - Dress Products");
    }
}
