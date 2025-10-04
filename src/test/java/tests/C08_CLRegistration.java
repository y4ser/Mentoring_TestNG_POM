package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.CLRegistrationPage;
import utilities.Driver;

//@Listeners(MyTestListener.class)
public class C08_CLRegistration {

    private CLRegistrationPage registrationPage;

    @Test
    void happyPath(){
        registrationPage = new CLRegistrationPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        registrationPage
                .enterFirstname(Faker.instance().name().firstName())
                .enterLastName(Faker.instance().name().lastName())
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertAddContactButton();


    }

    @Test
    void emptyFirstnameTest(){
        registrationPage = new CLRegistrationPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        registrationPage
                .enterLastName(Faker.instance().name().lastName())
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertErrorMessage("`firstName` is required.");


    }

    @Test
    void FirstnameWithSpecialCharTest(){
        registrationPage = new CLRegistrationPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        registrationPage
                .enterFirstname("y#ser")
                .enterLastName(Faker.instance().name().lastName())
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertErrorMessage("firstName");


    }


    @Test
    void FirstnameWithNumberTest(){
        registrationPage = new CLRegistrationPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        registrationPage
                .enterFirstname("y4ser")
                .enterLastName(Faker.instance().name().lastName())
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertErrorMessage("firstName");


    }


    @Test
    void emptyLastnameTest(){
        registrationPage = new CLRegistrationPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        registrationPage
                .enterFirstname(Faker.instance().name().firstName())
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertErrorMessage("`lastName` is required.");


    }


    @Test
    void LastnameWithSpecialCharTest(){
        registrationPage = new CLRegistrationPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        registrationPage
                .enterFirstname(Faker.instance().name().firstName())
                .enterLastName("y@ser")
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertErrorMessage("lastName");


    }


    @Test
    void LastnameWithNumberTest(){
        registrationPage = new CLRegistrationPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        registrationPage
                .enterFirstname(Faker.instance().name().firstName())
                .enterLastName(Faker.instance().name().lastName())
                .enterEmail(Faker.instance().internet().emailAddress())
                .enterPassword("Password.123")
                .clickSubmit()
                .assertErrorMessage("lastName");


    }


}