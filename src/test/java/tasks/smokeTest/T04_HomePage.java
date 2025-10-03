package tasks.smokeTest;

import org.testng.annotations.Test;
import pages.T04_SDHomePage;
import utilities.ConfigReader;
import utilities.Driver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class T04_HomePage {

    T04_SDHomePage sdHomePage = new T04_SDHomePage();
    @Test
    void homePageTest(){

        Driver.getDriver().get(ConfigReader.getProperty("sd_url"));

        sdHomePage
                .enterUsername(ConfigReader.getProperty("sd_username"))
                .enterPassword(ConfigReader.getProperty("sd_password"))
                .assertLoginLogo()
                .loginButton();

        Driver.closeDriver();

    }

}
