package testframework.lib.pages;

import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver webDriver){
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getTitle().equals("Automation Exercise - All Products");
    }


}
