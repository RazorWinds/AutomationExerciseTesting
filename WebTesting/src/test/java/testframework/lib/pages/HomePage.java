package testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private final By pastLink = new By.ByLinkText("past");
    private final By searchField = new By.ByName("q");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getTitle().equals("Automation Exercise");
    }


}