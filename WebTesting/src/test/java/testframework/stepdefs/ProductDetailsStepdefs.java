package testframework.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import testframework.lib.pages.DetailsPage;
import testframework.lib.pages.ProductsPage;

import static org.hamcrest.Matchers.is;

public class ProductDetailsStepdefs  extends StepDefsSuper{
    private ProductsPage productsPage;
    private DetailsPage detailsPage;

    @Given("I am browsing items")
    public void iAmBrowsingItems() {
        webDriver.get("https://automationexercise.com/products");
        productsPage = new ProductsPage(webDriver);
    }

    @When("I click on view product")
    public void iClickOn() {

        detailsPage = new DetailsPage(productsPage.clickProduct());
    }

    @Then("I am taken to the details page")
    public void iAmTakenToTheDetailsPage() {
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), is("https://automationexercise.com/product_details/1"));
    }

    @Then("I see the item image, name, availability, condition, brand, and price.")
    public void iSeeTheItemImageNameAvailabilityConditionBrandAndPrice() {
        MatcherAssert.assertThat(detailsPage.detailsExist(), is(true));
    }


    @And("I click the add to cart button")
    public void iClickTheAddToCartButton() throws InterruptedException {
        detailsPage.pressAddToCart();

    }

    @Then("the product is added to my cart, and I see a confirmation message")
    public void theProductIsAddedToMyCartAndISeeAConfirmationMessage() {
        MatcherAssert.assertThat(detailsPage.confirmAdded(), is(true));

    }


}
