package tasks.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.T04_SDCheckoutPage;
import pages.T04_SDHomePage;
import pages.T04_SDProductPage;
import utilities.ConfigReader;
import utilities.Driver;

public class T04_CheckoutPage {

    T04_SDHomePage sdHomePage = new T04_SDHomePage();
    T04_SDProductPage sdProductPage = new T04_SDProductPage();
    T04_SDCheckoutPage sdCheckoutPage = new T04_SDCheckoutPage();

    @Test
    void checkoutPageTest(){



        Driver.getDriver().get(ConfigReader.getProperty("sd_url"));
        sdHomePage.enterUsername(ConfigReader.getProperty("sd_username"))
                .enterPassword(ConfigReader.getProperty("sd_password"))
                .loginButton();

        sdProductPage
                .sortProducts(1).
                addProductByIndex(3)
                .assertPriceByName("Sauce Labs Bolt T-Shirt", 15.99)
                .clickOnCart();

        sdCheckoutPage
                .assertCartHeader()
                .assertProductInCartByName("Sauce Labs Bolt T-Shirt");

        Driver.closeDriver();
    }

}
