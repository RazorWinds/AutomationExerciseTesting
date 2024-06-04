package testframework.stepdefs;

import io.cucumber.java.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StepDefHooks extends StepDefsSuper{


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


    @BeforeStep
    public void closePopups(){

        //close ads
        if (webDriver.getCurrentUrl().contains("google")) {
            List<WebElement> elements = webDriver.findElements(By.id("dismiss-button"));
            elements.forEach(WebElement::click);

        }


        //An attempt to close popup ads
//        if (webDriver.getCurrentUrl().contains("google")) {
//            try {
//                webDriver.switchTo().frame(2);
//                webDriverWait.until(driver -> !driver.findElements(By.id("dismiss-button")).isEmpty());
//                webDriver.findElement(By.id("dismiss-button")).click();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
    }

}

