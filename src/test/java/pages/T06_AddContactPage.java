package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;
import java.util.Locale;

public class T06_AddContactPage {


    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By birthdate = By.id("birthdate");
    private By email = By.id("email");
    private By phone = By.id("phone");
    private By street1 = By.id("street1");
    private By street2 = By.id("street2");
    private By city = By.id("city");
    private By stateProvince = By.id("stateProvince");
    private By postalCode = By.id("postalCode");
    private By country = By.id("country");
    private By submit = By.id("submit");


    public T06_AddContactPage enterFirstName(String firstName){
        Driver.getDriver().findElement(this.firstName).sendKeys(firstName);
        return this;
    }

    public T06_AddContactPage enterLastName(String lastName){
        Driver.getDriver().findElement(this.lastName).sendKeys(lastName);
        return this;
    }

    public T06_AddContactPage enterBirthdate(String birthdate){
        Driver.getDriver().findElement(this.birthdate).sendKeys(birthdate);
        return this;
    }

    public T06_AddContactPage enterEmail(String email){
        Driver.getDriver().findElement(this.email).sendKeys(email);
        return this;
    }

    public T06_AddContactPage enterPhone(String phone){
        Driver.getDriver().findElement(this.phone).sendKeys(phone);
        return this;
    }

    public T06_AddContactPage enterStreet1(String street1){
        Driver.getDriver().findElement(this.street1).sendKeys(street1);
        return this;
    }

    public T06_AddContactPage enterStreet2(String street2) {
        Driver.getDriver().findElement(this.street2).sendKeys(street2);
        return this;
    }

    public T06_AddContactPage enterCity(String city){
        Driver.getDriver().findElement(this.city).sendKeys(city);
        return this;
    }

    public T06_AddContactPage enterStateProvince(String stateProvince){
        Driver.getDriver().findElement(this.stateProvince).sendKeys(stateProvince);
        return this;
    }

    public T06_AddContactPage enterPostalCode(String postalCode){
        Driver.getDriver().findElement(this.postalCode).sendKeys(postalCode);
        return this;
    }

    public T06_AddContactPage enterCountry(String country){
        Driver.getDriver().findElement(this.country).sendKeys(country);
        return this;
    }

    public T06_AddContactPage clickSubmit(){
        Driver.getDriver().findElement(submit).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("/contactList"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-contact")));
        return this;
    }



}
