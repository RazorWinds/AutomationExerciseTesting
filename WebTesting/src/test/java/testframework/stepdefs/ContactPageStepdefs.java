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
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import testframework.lib.pages.ContactPage;
import testframework.lib.pages.HomePage;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.Matchers.*;

public class ContactPageStepdefs extends StepDefsSuper{
    private HomePage homePage;
    private ContactPage contactPage;

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
    public void closePopups(){
        if (webDriver.getCurrentUrl().contains("google"))
            webDriver.findElement(By.id("dismiss-button")).click();
    }

    @After
    public void afterEach() {
        webDriver.quit();
    }

    @AfterAll
    public static void afterAll() {
        service.stop();
    }

    @Given("I am on the Contact us page")
    public void iAmOnTheContactUsPage() {
        webDriver.get("https://automationexercise.com/contact_us");
        contactPage = new ContactPage(webDriver);
//        contactPage.handleConsentPopup();
    }

    @When("I fill out the contact form with valid information \\(name, email, subject, message)")
    public void iFillOutTheContactFormWithValidInformationNameEmailSubjectMessage() {
        String name = "John Doe";
        String email = "johndoe@hotmail.co.uk";
        String subject = "Hello world";
        String message = "Hello everyone";
        contactPage.enterName(name);
        contactPage.enterEmail(email);
        contactPage.enterSubject(subject);
        contactPage.enterMessage(message);
    }

    @And("I click the Submit button")
    public void clickTheButton() {
        contactPage.submit();
    }

    @Then("a confirmation message should be displayed indicating that the message has been sent")
    public void aConfirmationMessageShouldBeDisplayedIndicatingThatTheMessageHasBeenSent() {
        WebElement successMessage = webDriver.findElement(By.cssSelector(".status"));
        MatcherAssert.assertThat(contactPage.messageSuccess(), Is.is("Success! Your details have been submitted successfully."));
    }

    @When("I click the Submit button but the fields are empty")
    public void iClickTheSubmitButtonButTheFieldsAreEmpty() {
        contactPage.submit();
    }

    @Then("an error should appear telling the user to fill in the fields")
    public void anErrorShouldAppearTellingTheUserToFillInTheFields() {
        MatcherAssert.assertThat(contactPage.getEmailFieldValidationMessage(), containsString("Please fill out this field"));
        MatcherAssert.assertThat(contactPage.getNameFieldValidationMessage(), containsString("Please fill out this field"));
        MatcherAssert.assertThat(contactPage.getMessageFieldValidationMessage(), containsString("Please fill out this field"));
    }

    @And("the form should not be submitted.")
    public void theFormShouldNotBeSubmitted() {
        MatcherAssert.assertThat(contactPage.messageSuccess(), is(not("Success! Your details have been submitted successfully.")));
    }

    @When("the email they have entered is invalid \\(ie: FakeEmail.com)")
    public void theEmailTheyHaveEnteredIsInvalidIeFakeEmailCom() {
        String email = "FakeEmail.com";
        contactPage.enterEmail(email);
    }

    @Then("an error should appear telling the user what is missing from the email")
    public void anErrorShouldAppearTellingTheUserWhatIsMissingFromTheEmail() {
        boolean email = contactPage.emailValidation("FakeEmail.com");
        if (!email) {
            MatcherAssert.assertThat(contactPage.getEmailFieldValidationMessage(), containsString("Please include an '@' in the email address"));
        }
    }

}
