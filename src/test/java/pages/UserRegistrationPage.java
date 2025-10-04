package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class UserRegistrationPage {

    private By ssn = By.id("ssn");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By male = By.xpath("//label[@for='male']");
    private By job = By.id("job");
    private By cv = By.id("cv");
    private By username = By.id("username");
    private By email = By.id("email");
    private By password = By.id("password");
    private By register = By.xpath("//button[.='Register']");

    public UserRegistrationPage enterSSN(String ssn) {
        Driver.getDriver().findElement(this.ssn).sendKeys(ssn);
        return this;
    }

    public UserRegistrationPage enterFirstname(String firstName) {
        Driver.getDriver().findElement(this.firstName).sendKeys(firstName);
        return this;
    }

    public UserRegistrationPage enterLastname(String lastName) {
        Driver.getDriver().findElement(this.lastName).sendKeys(lastName);
        return this;
    }


    public UserRegistrationPage clickMale() {
        Driver.getDriver().findElement(this.male).click();
        return this;
    }

    public UserRegistrationPage selectJob(String job) {
        new Select(Driver.getDriver().findElement(this.job)).selectByVisibleText(job);
        return this;
    }

    public UserRegistrationPage uploadCV(String cvPath) {
        Driver.getDriver().findElement(cv).sendKeys(System.getProperty("user.dir") + "/" + cvPath);
        return this;
    }


    public UserRegistrationPage enterUsername(String username) {
        Driver.getDriver().findElement(this.username).sendKeys(username);
        return this;
    }

    public UserRegistrationPage enterEmail(String email) {
        Driver.getDriver().findElement(this.email).sendKeys(email);
        return this;
    }

    public UserRegistrationPage enterPassword(String password) {
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    public UserRegistrationPage clickRegister() {
        Driver.getDriver().findElement(this.register).click();
        return this;
    }

    public UserRegistrationPage assertJSAlert(String message) {
        WebDriver driver = Driver.getDriver();
        assertEquals(driver.switchTo().alert().getText(), message);
        driver.switchTo().alert().accept();
        return this;
    }

    public UserRegistrationPage assertValidationMessage(String message, String input) {
        By by = null;
        switch (input.toLowerCase()) {
            case "ssn":
                by = ssn;
                break;
            case "firstname":
                by = firstName;
                break;
            case "lastname":
                by = lastName;
                break;
            case "job":
                by = job;
                break;
            case "cv":
                by = cv;
                break;
            case "username":
                by = username;
                break;
            case "email":
                by = email;
                break;
            case "password":
                by = password;
                break;
        }
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String error = (String) js.executeScript("return arguments[0].validationMessage;", Driver.getDriver().findElement(by));
        assertEquals(error, message);
        return this;
    }

    // test

    public UserRegistrationPage assertAlertText(String message) {
        WebDriver driver = Driver.getDriver();
        assertEquals(driver.switchTo().alert().getText(), message);
        driver.switchTo().alert().accept();
        return this;
    }

}

