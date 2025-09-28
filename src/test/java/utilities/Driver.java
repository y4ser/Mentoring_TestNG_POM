package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

//Singleton driver class
public class Driver {

    private static WebDriver driver;//Without initialization this is null.

    private Driver() {//None can create an object from this class
    }

    //This creates a new WebDriver instance if it does not exist.
    public static WebDriver getDriver() {

        if (driver == null) {
            switch (ConfigReader.getProperty("browser").toLowerCase()) {
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "headless":
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
                    break;
                default:
                    driver = new ChromeDriver();
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    //Safely close the driver
    public static void closeDriver() {
        try {
            Thread.sleep(2000);//Don't use this
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /*
    Multi-Browser Support: Chrome, Firefox, Safari, Headless Chrome
    Configuration-Driven: Browser type from properties file
    Implicit Wait: Built-in timeout management
    Window Management: Automatic maximization
    Proper Cleanup: closeDriver() method for resource management
     */

}
