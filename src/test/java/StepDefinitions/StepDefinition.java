package StepDefinitions;

import GeneralUtilities.GeneralUtility;
import PageObjectModel.TrendingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.*;

public class StepDefinition extends GeneralUtility {
    WebDriver driver;
    GeneralUtility generalUtility;
    @Given("^User Is On YouTube Homepage$")
    public void user_is_on_youtube_homepage() throws IOException {
        generalUtility = new GeneralUtility();
        this.driver= generalUtility.initializeDriver();
        driver.get(generalUtility.Url());
        driver.manage().window().maximize();
    }
    @When("^User Clicks Trending Grid$")
    public void user_clicks_trending_grid(){
        TrendingPage trendingPage = new TrendingPage(driver);
        trendingPage.trendingPage().click();
    }
    @Then("^Screenshot Trending Videos$")
    public void screenshot_trending_videos() throws IOException, InterruptedException {
        Thread.sleep(2000);
        generalUtility.takeScreenshot();
    }
}