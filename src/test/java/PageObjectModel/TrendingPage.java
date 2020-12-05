package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrendingPage {
    WebDriver driver;
    By trendingIcon = By.cssSelector("a[title='Trending']");

    public TrendingPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement trendingPage(){
        return driver.findElement(trendingIcon);
    }
}