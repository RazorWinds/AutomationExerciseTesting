package testframework.stepdefs;

import io.cucumber.java.*;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testframework.lib.pages.ProductsPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchStepDefs extends StepDefsSuper{
    ProductsPage productsPage;
    WebDriverWait webDriverWait;

    @When("I enter a specific product name \\(e.g., {string}) into the search bar")
    public void iEnterASpecificProductNameEGIntoTheSearchBar(String searchTerm) {
        productsPage = new ProductsPage(webDriver);
        productsPage.search(searchTerm);
    }

    @Then("the user should be redirected to the search results page")
    public void theUserShouldBeRedirectedToTheSearchResultsPage() {
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("products?search="));
    }

    @And("the URL should be updated with the search query {string}")
    public void theURLShouldBeUpdatedWithTheSearchQuery(String searchTerm) {
        String[] searchTerms = searchTerm.split("%20");
        if (searchTerms.length == 2)
            Assertions.assertTrue(webDriver.getCurrentUrl().contains(searchTerms[0] + "%20" + searchTerms[1]));
    }

    @And("the products matching the search term {string} should be displayed")
    public void theProductsMatchingTheSearchTermShouldBeDisplayed(String searchTerm) {
        var products = webDriver.findElements(By.linkText("View Product"));
        for (int i = 0; i < products.size(); i++){
            products = webDriver.findElements(By.linkText("View Product"));
            String productUrl = products.get(i).getAttribute("href");
            webDriver.navigate().to(productUrl);
            var category = webDriver.findElement(By.className("product-information"));
            Assertions.assertTrue(category.getText().toLowerCase().contains(searchTerm.toLowerCase()));
            webDriver.navigate().back();
        }
    }

    @And("a message should be displayed indicating no products were found matching the search term {string}")
    public void aMessageShouldBeDisplayedIndicatingNoProductsWereFoundMatchingTheSearchTerm(String searchTerm) {
        Assertions.assertTrue(webDriver.findElement(By.tagName("body")).getText().contains("No products matching " + searchTerm + "found"));
    }

    @When("I search an empty search term")
    public void iSearchAnEmptySearchTerm() {
        productsPage = new ProductsPage(webDriver);
        productsPage.search("");
    }

    @Then("No change to the product page should take place")
    public void noChangeToTheProductPageShouldTakePlace() {
        var products = webDriver.findElements(By.className("single-products"));
        Assertions.assertTrue(!products.isEmpty());
    }
}
