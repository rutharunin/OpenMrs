package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class DriverHelper {

    //Singelton Pattern Design
    public static WebDriver driver;

    // Private Constructor
    private DriverHelper() {
    } // private constructor I do not want anyone to create an object from this class

    public static WebDriver getDriver() {
        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
            //String browser="chrome";
            switch (ConfigReader.readProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
}