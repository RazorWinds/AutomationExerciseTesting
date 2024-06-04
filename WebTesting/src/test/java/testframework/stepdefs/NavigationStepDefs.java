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
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import testframework.lib.pages.*;

import java.io.File;
import java.io.IOException;

public class NavigationStepDefs extends StepDefsSuper{
    private HomePage homePage;
    private ProductsPage productPage;
    private CartPage cartPage;
    private ContactPage contactPage;


    @Given("I'm on the home page")
    public void iMOnTheHomePage() {
        webDriver.get("https://automationexercise.com/");
        homePage = new HomePage(webDriver);
//        homePage.handleConsentPopup();
    }

    @When("I click on a product category {string} link, and then the {string} link in the navigation menu")
    public void iClickOnAProductCategoryLinkAndThenTheLinkInTheNavigationMenu(String catName, String itemCat) {
        productPage = homePage.clickOnCategory(catName, itemCat);
    }

    @Then("^I should be directed to the \"Women's Dresses\" category page$")
    public void iShouldBeDirectedToTheCategoryPage() {
        MatcherAssert.assertThat(productPage.getUrl(), Is.is("https://automationexercise.com/category_products/1"));
    }

    @And("^The heading above the products should say \"WOMEN - DRESS PRODUCTS\"$")
    public void theHeadingAboveTheProductsShouldSay() {
        MatcherAssert.assertThat(productPage.getHeading(), Is.is("WOMEN - DRESS PRODUCTS"));
    }

    @And("the products related to the {string} category should be displayed")
    public void theProductsRelatedToTheWomenCategoryShouldBeDisplayed() {
    }

    @When("I click on the Cart link in the nav menu")
    public void iClickOnTheCartLinkInTheNavMenu() {
        cartPage = homePage.viewCart();
    }

    @Then("I should be redirected to the cart page")
    public void iShouldBeRedirectedToTheCartPage() {
        MatcherAssert.assertThat(cartPage.getUrl(), Is.is("https://automationexercise.com/view_cart"));
    }

    @And("the cart page should be displayed showing any items in the cart")
    public void theCartPageShouldBeDisplayedShowingAnyItemsInTheCart() {
        MatcherAssert.assertThat(cartPage.emptyCart(), Is.is("Cart is empty!"));
    }

    @When("^I click on the \"Contact us\" link in the navigation menu$")
    public void iClickOnTheLinkInTheNavigationMenu() {
        contactPage = homePage.viewContactPage();
    }

    @Then("I should be redirected to the contact page")
    public void iShouldBeRedirectedToTheContactPage() {
        MatcherAssert.assertThat(contactPage.getUrl(), Is.is("https://automationexercise.com/contact_us"));
    }

    @And("the contact form should be displayed")
    public void theContactFormShouldBeDisplayed() {
        MatcherAssert.assertThat(contactPage.getTitle(), Is.is("GET IN TOUCH"));
    }

    @Given("I am on any page of the website")
    public void iAmOnAnyPageOfTheWebsite() {
        webDriver.get("https://automationexercise.com/products");
        productPage = new ProductsPage(webDriver);
//        productPage.handleConsentPopup();
    }

    @When("^I click on the \"Home\" link in the navigation menu")
    public void iClickOnTheHomeLinkInTheNavigationMenu() {
        webDriver.findElement(By.linkText("Home")).click();
        homePage = new HomePage(webDriver);
    }

    @Then("I should be redirected to the home page")
    public void iShouldBeRedirectedToTheHomePage() {
        MatcherAssert.assertThat(homePage.getUrl(), Is.is("https://automationexercise.com/"));
    }

    @When("the user manually enters a non-existent category URL in the browser")
    public void theUserManuallyEntersANonExistentCategoryURLInTheBrowser() {
        webDriver.get("https://automationexercise.com/diamonds");
        homePage = new HomePage(webDriver);
    }
}
