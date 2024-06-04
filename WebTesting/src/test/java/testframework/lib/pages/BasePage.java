package testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected final WebDriver webDriver;
    protected final WebDriverWait wait;


    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        if (!isCorrectPage()) {
            throw new IllegalStateException("This is not " + this.getClass().getName() + ", " +
                    "current page is: " + webDriver.getCurrentUrl());
        }
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        List<WebElement> consentCookies = webDriver.findElements(By.className("fc-button-label"));
        if (!consentCookies.isEmpty()) {
            consentCookies.get(0).click();
        }
    }




public String getUrl() {
    return webDriver.getCurrentUrl();
}

public String getTitle() {
    return webDriver.getTitle();
}

    protected abstract boolean isCorrectPage();
}
