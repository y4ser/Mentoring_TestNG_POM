package tasks;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.T06_AddContactPage;
import pages.T06_ContactListPage;
import pages.T06_LoginPage;
import utilities.Driver;
import utilities.ExtentReportManager;

import java.time.LocalTime;
import java.util.Locale;

public class T06_ExtentReportsImplementation {

     /*
 Target: https://thinking-tester-contact-list.herokuapp.com/
 Test Scenario:
 1. Navigate to the application
 2. Create a new user account
 3. Login with the created user
 4. Add 5 different contacts
 5. Assert that all contacts are properly added and displayed
 Page Objects Needed:
 - LoginPage (registration and login elements)
 - ContactListPage (contact management elements)
 - AddContactPage (contact form elements)
 Assertions:
 - Verify successful user registration
 - Verify successful login
 - Verify each contact is added correctly
 - Verify total contact count equals 5
 Reporting Requirements:- Use ExtentReports
 - Create TestBaseReport base class
 - Add .info() logs for each major step
 - Use .pass() for successful assertions
 - Use .fail() for failed assertions with screenshots
 - Add system information (Browser, Environment, Tester)
 - Generate report with timestamp in filename
 */

    T06_LoginPage loginPage = new T06_LoginPage();
    T06_ContactListPage contactListPage = new T06_ContactListPage();
    T06_AddContactPage addContactPage = new T06_AddContactPage();

    @Test
    void extentReportsTest() {

//        Test Scenario:
//        1. Navigate to the application
//        2. Create a new user account
//        3. Login with the created user
//        4. Add 5 different contacts
//        5. Assert that all contacts are properly added and displayed

        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/");

        loginPage
                .clickSignup()
                .enterFirstName(Faker.instance().name().firstName())
                .enterLastName(Faker.instance().name().lastName())
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword(Faker.instance().internet().password())
                .clickSubmit()
                .assertSignupSuccess();

        ExtentReportManager.log(Status.PASS, "User registration successful.");

        for (int i = 0; i < 5; i++) {

            contactListPage.clickAddContactBtn();
            String firstName = Faker.instance().name().firstName();
            String lastName = Faker.instance().name().lastName();

            addContactPage
                    .enterFirstName(firstName)
                    .enterLastName(lastName)
                    .enterBirthdate(new java.text.SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(Faker.instance().date().birthday()))
                    .enterEmail(Faker.instance().internet().emailAddress())
                    .enterPhone(Faker.instance().numerify("01########"))
                    .enterStreet1(Faker.instance().address().streetAddress())
                    .enterStreet2(Faker.instance().address().secondaryAddress())
                    .enterCity(Faker.instance().address().city())
                    .enterStateProvince(Faker.instance().address().state())
                    .enterPostalCode(Faker.instance().address().zipCode())
                    .enterCountry(Faker.instance().address().country())
                    .clickSubmit();

            contactListPage.assertContactExists(firstName, lastName);
            ExtentReportManager.log(Status.PASS, "Contact " + (i + 1) + " added and verified.");

        }
        contactListPage.assertContactCount(5);
        ExtentReportManager.log(Status.PASS, "All 5 contacts added successfully.");

    }

}
