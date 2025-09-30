package tests.smoke_test;

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

public class T01_ContactList {

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


        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);//put explicit wait for addContact button
            contactListPage.addContact.click();
            addContactPage.firstName.sendKeys(Faker.instance().name().firstName());
            addContactPage.lastName.sendKeys(Faker.instance().name().lastName());
            addContactPage.Submit.click();
        }

        Assert.assertEquals(contactListPage.contactRows.size(), 5);


        Driver.closeDriver();
    }

}
