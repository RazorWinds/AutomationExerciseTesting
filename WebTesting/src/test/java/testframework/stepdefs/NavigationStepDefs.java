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
import testframework.lib.pages.HomePage;
import testframework.lib.pages.ProductsPage;

import java.io.File;
import java.io.IOException;

public class NavigationStepDefs extends StepDefsSuper{
    HomePage homePage;
    private ProductsPage productPage;

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

    @When("^I click on a product category \"WOMEN\" link, and then the \"DRESS\" link in the navigation menu$")
    public void iClickOnAProductCategoryLinkAndThenTheLinkInTheNavigationMenu() {
        productPage = homePage.clickOnWomenCategory();
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
}
