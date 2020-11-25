package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class StepDefinition {
    WebDriver driver;
    @Given("^User Is On YouTube Homepage$")
    public void user_is_on_youtube_homepage(){
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
    }
    @When("^User Clicks Trending Grid$")
    public void user_clicks_trending_grid(){
        driver.findElement(By.cssSelector("a[title='Trending']")).click();
    }
    @Then("^Screenshot Trending Videos$")
    public void screenshot_trending_videos() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String targetScreenshot = System.getProperty("user.dir") + "/src/screenshot/screenshot.jpg";
        File sourceScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceScreenshot, new File(targetScreenshot));
    }
}