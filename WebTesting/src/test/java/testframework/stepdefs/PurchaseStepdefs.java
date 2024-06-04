package testframework.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import testframework.lib.pages.CardDetailsPage;
import testframework.lib.pages.CartPage;
import testframework.lib.pages.CheckoutPage;
import testframework.lib.pages.ProductsPage;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;


public class PurchaseStepdefs extends StepDefsSuper {

    private ProductsPage productsPage;

    @And("I have 1 item in my basket")
    public void iHaveItemInMyBasket() throws InterruptedException {
        webDriver.get(cartURL);
        CartPage basketPage = new CartPage(webDriver);
        basketPage.clearBasket();
        webDriver.get(productsURL);
        ProductsPage productsPage = new ProductsPage(webDriver);
        productsPage.addOneItemToCart();
    }

    @And("I am on the basket page")
    public void iAmOnTheBasketPage() {
        webDriver.get(cartURL);
    }

    @When("I click the Proceed to Checkout button")
    public void iClickTheProceedToCheckoutButton() {
        CartPage basketPage = new CartPage(webDriver);
        basketPage.checkOut();
    }

    @Then("I should be redirected to the checkout page where I can see product details.")
    public void iShouldBeRedirectedToTheCheckoutPageWhereICanSeeProductDetails() {
        assertThat(webDriver.findElement(By.cssSelector(".step-one:nth-child(4) > .heading")).getText(), is("Review Your Order"));
    }


    @Given("I have no items in my basket")
    public void iHaveNoItemsInMyBasket() {
        webDriver.get(cartURL);
        CartPage basketPage = new CartPage(webDriver);
        basketPage.clearBasket();
    }

    @Then("The checkout button should not be displayed.")
    public void theCheckoutButtonShouldNotBeDisplayed() {
        assertThat(webDriver.findElements(By.linkText("Proceed To Checkout")).size(), is(0));
    }

    @And("Some text should appear stating There is nothing in your basket")
    public void someTextShouldAppearStatingThereIsNothingInYourBasket() {
        assertThat(webDriver.findElement(By.cssSelector("b:nth-child(1)")).getText(), is("Cart is empty!"));
    }

    @And("There should be a link to direct back to the products page")
    public void thereShouldBeALinkToDirectBackToTheProductsPage() {
        assertThat(webDriver.findElement(By.cssSelector("u")).getText(), is("here"));
    }

    @And("I have clicked place order on the checkout page")
    public void iHaveClickedPlaceOrderOnTheCheckoutPage() {
        webDriver.get(productsURL);
        ProductsPage productsPage = new ProductsPage(webDriver);
        productsPage.addOneItemToCart();
        webDriver.get(cartURL);
        CartPage basketPage = new CartPage(webDriver);
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
