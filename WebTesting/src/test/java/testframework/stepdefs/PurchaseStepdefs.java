package testframework.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class PurchaseStepdefs extends StepDefsSuper{
    @Given("I have 1 item in my basket")
    public void iHaveItemInTheirBasket() {

    }

    @And("I am on the basket page")
    public void iAmOnTheBasketPage() {
    }

    @When("I click the Proceed to Checkout button")
    public void iClickTheProceedToCheckoutButton() {
    }

    @Then("I should be redirected to the checkout page where I can see product details.")
    public void iShouldBeRedirectedToTheCheckoutPageWhereICanSeeProductDetails() {
    }

    @Given("I have {int} items in my basket")
    public void iHaveItemsInMyBasket(int arg0) {
    }

    @Then("The checkout button should not be displayed.")
    public void theCheckoutButtonShouldNotBeDisplayed() {
    }

    @And("Some text should appear stating There is nothing in your basket")
    public void someTextShouldAppearStatingThereIsNothingInYourBasket() {
    }

    @And("There should be a link to direct back to the products page")
    public void thereShouldBeALinkToDirectBackToTheProductsPage() {
    }

    @Given("I have clicked place order on the checkout page")
    public void iHaveClickedPlaceOrderOnTheCheckoutPage() {
    }

    @When("I enter va lid card details")
    public void iEnterVaLidCardDetails() {
    }

    @And("click the Pay and confirm button")
    public void clickThePayAndConfirmButton() {
    }

    @Then("Text should appear saying ORDER PLACED!")
    public void textShouldAppearSayingORDERPLACED() {
    }

    @And("A button to continue shopping should appear")
    public void aButtonToContinueShoppingShouldAppear() {
    }

    @When("I enter invalid card details")
    public void iEnterInvalidCardDetails() {
    }

    @Then("An order should not be placed")
    public void anOrderShouldNotBePlaced() {
    }

    @And("An error prompting to try again should be shown.")
    public void anErrorPromptingToTryAgainShouldBeShown() {
    }

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
}
