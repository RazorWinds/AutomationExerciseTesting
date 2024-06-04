package testframework.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import testframework.lib.pages.BasketPage;
import testframework.lib.pages.CardDetailsPage;
import testframework.lib.pages.CheckoutPage;
import testframework.lib.pages.ProductsPage;


import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;


public class PurchaseStepdefs extends StepDefsSuper {

    private ProductsPage productsPage;

    @And("I have 1 item in my basket")
    public void iHaveItemInMyBasket()  {
        webDriver.get(basketURL);
        BasketPage basketPage = new BasketPage(webDriver);
        basketPage.clearBasket();
        webDriver.get(productsURL);
        ProductsPage productsPage = new ProductsPage(webDriver);
        productsPage.addOneItemToCart();
    }

    @And("I am on the basket page")
    public void iAmOnTheBasketPage() {
        webDriver.get(basketURL);
    }

    @When("I click the Proceed to Checkout button")
    public void iClickTheProceedToCheckoutButton() {
        BasketPage basketPage = new BasketPage(webDriver);
        basketPage.checkOut();
    }

    @Then("I should be redirected to the checkout page where I can see product details.")
    public void iShouldBeRedirectedToTheCheckoutPageWhereICanSeeProductDetails() {
//        assertThat(webDriver.findElement(By.cssSelector(".step-one:nth-child(4) > .heading")).getText(), is("Review Your Order"));
    }


    @Given("I have no items in my basket")
    public void iHaveNoItemsInMyBasket() {
        webDriver.get(basketURL);
        BasketPage basketPage = new BasketPage(webDriver);
        basketPage.clearBasket();
    }

    @Then("The checkout button should not be displayed.")
    public void theCheckoutButtonShouldNotBeDisplayed() {
        assertThat(webDriver.findElement(By.linkText("Proceed To Checkout")), is(null));
    }

    @And("Some text should appear stating There is nothing in your basket")
    public void someTextShouldAppearStatingThereIsNothingInYourBasket() {
        assertThat(webDriver.findElement(By.cssSelector("b:nth-child(1)")).getText(), is("Cart is empty!"));
    }

    @And("There should be a link to direct back to the products page")
    public void thereShouldBeALinkToDirectBackToTheProductsPage() {
        assertThat(webDriver.findElement(By.cssSelector("u")).getText(), is("here"));
    }

    @Given("I have clicked place order on the checkout page")
    public void iHaveClickedPlaceOrderOnTheCheckoutPage() {
        webDriver.get(productsURL);
        ProductsPage productsPage = new ProductsPage(webDriver);
        productsPage.addOneItemToCart();
        webDriver.get(basketURL);
        BasketPage basketPage = new BasketPage(webDriver);
        basketPage.checkOut();
        CheckoutPage checkoutPage = new CheckoutPage(webDriver);
        checkoutPage.placeOrder();
    }

    @When("I enter valid card details")
    public void iEnterValidCardDetails() {
        CardDetailsPage cardDetailsPage = new CardDetailsPage(webDriver);
        cardDetailsPage.enterCardDetailsValid();
    }

    @And("click the Pay and confirm button")
    public void clickThePayAndConfirmButton() {
        new CardDetailsPage(webDriver).confirm();
    }

    @Then("Text should appear saying ORDER PLACED!")
    public void textShouldAppearSayingORDERPLACED() {
        assertThat(webDriver.findElement(By.cssSelector("b:nth-child(1)")).getText(), is("ORDER PLACED!"));
    }


    @When("I enter invalid card details")
    public void iEnterInvalidCardDetails() {
        CardDetailsPage cardDetailsPage = new CardDetailsPage(webDriver);
        cardDetailsPage.enterCardDetailsInvalid();
    }

    @Then("An order should not be placed")
    public void anOrderShouldNotBePlaced() {
        assertThat(webDriver.findElement(By.cssSelector("b:nth-child(1)")).getText(), is(not("ORDER PLACED!")));
    }

    @And("An error prompting to try again should be shown.")
    public void anErrorPromptingToTryAgainShouldBeShown() {
        assertThat(webDriver.findElement(By.cssSelector("b:nth-child(1)")).getText(), is("Invalid details try again"));
    }
}
