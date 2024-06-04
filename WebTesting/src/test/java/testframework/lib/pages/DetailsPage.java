package testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailsPage extends BasePage{

    private WebElement availability = webDriver.findElement(By.cssSelector("p:nth-child(6) > b"));
    private WebElement condition = webDriver.findElement(By.cssSelector("p:nth-child(7) > b"));
    private WebElement brand = webDriver.findElement(By.cssSelector("p:nth-child(8) > b"));
    private WebElement name = webDriver.findElement(By.cssSelector("h2:nth-child(2)"));

    public DetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected boolean isCorrectPage() {
        return webDriver.getCurrentUrl().contains("product_details");
    }

    public boolean detailsExist(){
        if( availability.getText() != null && condition.getText() != null && brand.getText() != null && name.getText() != null){
            return true;
        }else {
            return false;
        }
    }
}
