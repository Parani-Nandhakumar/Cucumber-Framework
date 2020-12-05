package GeneralUtilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GeneralUtility {
    WebDriver driver;
    Properties properties;
    public WebDriver initializeDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
    public String Url() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/file.properties");
        properties = new Properties();
        properties.load(fileInputStream);
        return properties.getProperty("Url");
    }
    public void takeScreenshot() throws IOException {
        String targetScreenshot = System.getProperty("user.dir") + "/src/screenshot/screenshot.jpg";
        File sourceScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceScreenshot, new File(targetScreenshot));
    }
}
