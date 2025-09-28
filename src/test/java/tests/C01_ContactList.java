package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CLAddContactPage;
import pages.CLAddUserPage;
import pages.CLContactListPage;
import pages.CLHomePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Locale;

public class C01_ContactList {

    /*
    Target: https://thinking-tester-contact-list.herokuapp.com/
    Test Scenario:
    1. Navigate to the application
    2. Create a new user account
    3. Login with the created user
    4. Add 5 different contacts
    5. Assert that all contacts are properly added and displayed
     */

    @Test
    void contactListTest() throws InterruptedException {
        CLHomePage homePage = new CLHomePage();
        CLAddUserPage addUserPage = new CLAddUserPage();
        CLContactListPage contactListPage = new CLContactListPage();
        CLAddContactPage addContactPage = new CLAddContactPage();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));

        homePage.signUp.click();

        addUserPage.firstname.sendKeys(Faker.instance().name().firstName());
        addUserPage.lastname.sendKeys(Faker.instance().name().lastName());
        addUserPage.email.sendKeys(Faker.instance().internet().emailAddress());
        addUserPage.password.sendKeys(Faker.instance().internet().password());
        addUserPage.submit.click();
        contactListPage.addContact.click();

        for (int i = 0; i < 5; i++ ){
            Thread.sleep(1000);
            contactListPage.addContact.click();
            Thread.sleep(1000);
            addContactPage.firstName.sendKeys(Faker.instance().name().firstName());
            addContactPage.lastName.sendKeys(Faker.instance().name().lastName());
            addContactPage.birthdate.sendKeys(new java.text.SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(Faker.instance().date().birthday()));
            addContactPage.email.sendKeys(Faker.instance().internet().emailAddress());
            addContactPage.phone.sendKeys(Faker.instance().numerify("01########"));
            addContactPage.street1.sendKeys(Faker.instance().address().streetAddress());
            Thread.sleep(1000);
            addContactPage.street2.sendKeys(Faker.instance().address().secondaryAddress());
            Thread.sleep(1000);
            addContactPage.city.sendKeys(Faker.instance().address().city());
            Thread.sleep(1000);
            addContactPage.stateProvince.sendKeys(Faker.instance().address().state());
            Thread.sleep(1000);
            addContactPage.postalCode.sendKeys(Faker.instance().address().zipCode());
            Thread.sleep(1000);
            addContactPage.country.sendKeys(Faker.instance().address().country());
            Thread.sleep(2000);
            addContactPage.Submit.click();
        }

        Assert.assertEquals(contactListPage.contactRows.size(), 5);


        Driver.closeDriver();

    }

}
