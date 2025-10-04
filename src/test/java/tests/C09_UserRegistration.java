package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.UserRegistrationPage;
import utilities.Driver;

public class C09_UserRegistration {

    //US01: As a new user I want to register for an account by providing my personal information.
    /*
    Go to https://claruswaysda.github.io/Registration.html
    Enter valid SSN
    ..... Task ....
     */

    @Test
    void happyPath(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-33-4567")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("yaserCV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertJSAlert("Form submitted!");
    }

    @Test
    void incorrectSSNTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("33-4567")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("yaserCV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please match the requested format.","ssn");
    }

    //Rest is assignment!!!

    @Test
    void emptyFirstnameTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-45-6789")

                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("yaserCV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please match the requested format.","firstName");
    }

    @Test
    void FirstnameWithSpecialCharTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-45-6789")
                .enterFirstname("J@hn")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("yaserCV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please match the requested format.","firstName");
    }

    @Test
    void FirstnameWithNumberTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-45-6789")
                .enterFirstname("J2hn")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("yaserCV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please match the requested format.","firstName");
    }

    @Test
    void emptyLastnameTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-45-6789")
                .enterFirstname("John")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("yaserCV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please match the requested format.","lastName");
    }

    @Test
    void LastnameWithSpecialCharTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-45-6789")
                .enterFirstname("John")
                .enterLastname("D@e")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("yaserCV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please match the requested format.","lastName");
    }

    @Test
    void LastnameWithNumberTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-45-6789")
                .enterFirstname("John")
                .enterLastname("D0e")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("yaserCV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please match the requested format.","lastName");
    }

    @Test
    void jobTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-45-6789")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .uploadCV("yaserCV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please select an item from the list.","job");
    }

    @Test
    void withoutUploadCVTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-45-6789")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")

                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please select a file.","cv");
    }


    @Test
    void emptyUsername(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-45-6789")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("yaserCV.pdf")

                .enterEmail("johndoe@gmail.com")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please fill in this field.","username");
    }

    @Test
    void emptyEmailTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-45-6789")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("yaserCV.pdf")
                .enterUsername("johndoe")

                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please fill in this field.","email");
    }


    @Test
    void EmailWithoutDomain(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-45-6789")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("yaserCV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@")
                .enterPassword("John.1234")
                .clickRegister()
                .assertValidationMessage("Please enter the part after the @ sign", "email");
    }

    @Test
    void emptyPassword(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-45-6789")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("yaserCV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")

                .clickRegister()
                .assertValidationMessage("Please fill in this field.","password");
    }

    @Test
    void PasswordLessThan8NumberTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-45-6789")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("yaserCV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("1234567")
                .clickRegister()
                .assertValidationMessage("Please finish this text to make it at least 8 (their current number is 7).","password");
    }

    @Test
    void oneLowerCaseLetterTest(){
        UserRegistrationPage registrationPage = new UserRegistrationPage();
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        registrationPage
                .enterSSN("123-45-6789")
                .enterFirstname("John")
                .enterLastname("Doe")
                .clickMale()
                .selectJob("Tester")
                .uploadCV("yaserCV.pdf")
                .enterUsername("johndoe")
                .enterEmail("johndoe@gmail.com")
                .enterPassword("12345678a")
                .clickRegister()
                .assertAlertText("Password must contain at least 8 characters including at least one uppercase letter, one lowercase letter, and one digit.");
    }

}
