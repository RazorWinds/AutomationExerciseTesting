package testframework.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import testframework.lib.pages.BasePage;

import java.io.File;
import java.io.IOException;

public abstract class StepDefsSuper {
    protected static ChromeDriverService service;
    protected static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    protected WebDriver webDriver;

    protected static final String basketURL = "https://automationexercise.com/view_cart";
    protected static final String productsURL = "https://automationexercise.com/products";

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("headless");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        return chromeOptions;
    }

//    @BeforeAll
//    public static void beforeAll() throws IOException {
//        service = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File(DRIVER_LOCATION))
//                .usingAnyFreePort()
//                .build();
//        service.start();
//    }
//
//    @Before
//    public void setup() {
//        webDriver = new RemoteWebDriver(service.getUrl(), getChromeOptions());
//    }
//
//    @After
//    public void afterEach() {
//        webDriver.quit();
//    }
//
//    @AfterAll
//    public static void afterAll() {
//        service.stop();
//    }
}
