package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class T04_SDProductPage extends T04_SDHomePage {

    private By sort = By.xpath("//select[@class='product_sort_container']");
    private By priceList = By.className("inventory_item_price");
    private By addCartButtons = By.cssSelector(".btn_inventory ");
    private By cartButton = By.cssSelector(".shopping_cart_link ");
    private String priceByName = "//div[@class='inventory_item_description' and contains(., '%s')]//div[@class='inventory_item_price']";

    public T04_SDProductPage sortProducts(String visibleText){
        new Select(Driver.getDriver().findElement(sort)).selectByVisibleText(visibleText);
        return this;
    }

    public T04_SDProductPage sortProducts(int index){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(sort));
        new Select(dropdown).selectByIndex(index);
        return this;
    }

    public T04_SDProductPage addProductByIndex(int index) {
        Driver.getDriver().findElements(addCartButtons).get(index).click();
        return this;
    }

    public T04_SDProductPage clickOnCart() {
        Driver.getDriver().findElement(cartButton).click();
        return new T04_SDProductPage();
    }

    public T04_SDProductPage assertPriceByName(String productName, double price) {
        String strPrice = Driver.getDriver().findElement(By.xpath(String.format(priceByName, productName))).getText();
        Assert.assertEquals(Double.parseDouble(strPrice.replaceAll("[^0-9.]", "")), price);
        return this;
    }

}
