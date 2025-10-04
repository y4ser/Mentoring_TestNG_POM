package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;

public class T06_LoginPage {

    private By signup = By.id("signup");

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("email");
    private By password = By.id("password");
    private By submit = By.id("submit");


    public T06_LoginPage clickSignup(){
        Driver.getDriver().findElement(signup).click();
        return this;
    }

    public T06_LoginPage  enterFirstName(String firstName){
        Driver.getDriver().findElement(this.firstName).sendKeys(firstName);
        return this;
    }

    public T06_LoginPage enterLastName(String lastName){
        Driver.getDriver().findElement(this.lastName).sendKeys(lastName);
        return this;
    }

    public T06_LoginPage enterEmail(String email){
        Driver.getDriver().findElement(this.email).sendKeys(email);
        return this;
    }

    public T06_LoginPage enterPassword(String password){
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    public T06_LoginPage clickSubmit(){
        Driver.getDriver().findElement(this.submit).click();
        return this;
    }

    public T06_LoginPage assertSignupSuccess(){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/contactList"));

        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/contactList"), "Signup was not successful");
        return this;
    }



}
