package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.Driver;

import static org.testng.Assert.assertTrue;

public class T04_SDCheckoutPage {

    private By yourCartHeader = By.cssSelector(".header_secondary_container");
    private String productXPathInCartByName = "//div[@class='cart_item_label']//div[contains(., '%s')]";


    public T04_SDCheckoutPage assertCartHeader() {
        Assert.assertEquals(Driver.getDriver().findElement(yourCartHeader).getText(), "Your Cart");
        return this;
    }

    public T04_SDCheckoutPage assertProductInCartByName(String productName) {
        assertTrue(Driver.getDriver().findElement(By.xpath(String.format(productXPathInCartByName, productName))).isDisplayed());
        return this;
    }

}
