package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.OHRMLoginPage;
import utilities.Driver;

public class C05_OHRMLogin {

     /*
        Task 1: Parallel Test Configuration
        Objective: Create a parallel test suite that runs login tests on multiple browsers simultaneously.
        Requirements:Create a TestNG XML file with parallel execution at the method level
        Set thread count to 3
        Include at least 2 test classes: PositiveLoginTest and NegativeLoginTest
        Configure timeout for each test method to 30 seconds
        Expected Output: All tests should run in parallel, reducing total execution time.
     */

    private static final Logger log = LoggerFactory.getLogger(C05_OHRMLogin.class);

    @Test
    void positiveLoginTest(){//Happy Path

        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage
                .enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin()
                .assertLogin();

        Driver.closeDriver();

    }


    @Test
    void NegativeLoginTest1(){

        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage
                //.enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin()
                .assertUsernameError();

        Driver.closeDriver();

    }

    @Test
    void NegativeLoginTest2(){

        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage
                .enterUsername("Admin")
                //.enterPassword("admin123")
                .clickLogin()
                .assertPasswordError();

        Driver.closeDriver();

    }

    @Test
    void NegativeLoginTest3(){

        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage
               // .enterUsername("Admin")
                //.enterPassword("admin123")
                .clickLogin()
                .assertUsernameError()
                .assertPasswordError();

        Driver.closeDriver();

    }

    @Test
    void NegativeLoginTest4(){

        OHRMLoginPage loginPage = new OHRMLoginPage();
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage
                 .enterUsername("XAdmin")
                .enterPassword("admin123")
                .clickLogin()
                .assertInvalidCredentials();

        Driver.closeDriver();

    }

}
