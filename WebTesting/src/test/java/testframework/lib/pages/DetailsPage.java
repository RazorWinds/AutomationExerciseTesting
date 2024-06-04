package testframework.lib.pages;

import org.openqa.selenium.WebDriver;

public class DetailsPage extends BasePage{
    public DetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getCurrentUrl().contains("product_details");
    }
}
