package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

public class T06_ContactListPage {

    private By addContactBtn = By.id("add-contact");
    private By contactRows = By.xpath("//table/tr");

    public T06_AddContactPage clickAddContactBtn(){
        Driver.getDriver().findElement(this.addContactBtn).click();
        return new T06_AddContactPage();
    }

    public T06_ContactListPage assertContactCount(int expectedCount) {
        List<WebElement> rows = Driver.getDriver().findElements(contactRows);
        Assert.assertEquals(rows.size(), expectedCount);
        return this;
    }

    public T06_ContactListPage assertContactExists(String firstName, String lastName) {
        boolean found = Driver.getDriver()
                .findElements(contactRows)
                .stream()
                .anyMatch(row -> row.getText().contains(firstName) && row.getText().contains(lastName));

        Assert.assertTrue(found);
        return this;
    }





}
