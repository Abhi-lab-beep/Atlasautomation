package Testbase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class testbase {

    public static WebDriver driver;

    @BeforeClass
    @Parameters({"os", "browser"})
    public void setup(String os, String br) {
        switch (br.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid browser");
                return;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://atlas.qa.century-crm.com/#/login");
    }

    /*  @AfterClass
   public void teardown() throws InterruptedException {
        Thread.sleep(20);
        if (driver != null) {
            driver.close();
        }*/
    

    public static String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        Files.copy(sourceFile.toPath(), targetFile.toPath());

        return targetFilePath;
    }
}
