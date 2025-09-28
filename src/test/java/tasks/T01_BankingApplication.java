package tasks;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class T01_BankingApplication {

    /*
    Example 2: Banking Application Test
     Target: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
     Test Scenario:
     1. Open 5 new customer accounts
     2. Deposit 100 USD to each account
     3. Withdraw 100 USD from any one account
     4. Delete all created accounts
     5. Verify account operations
     */

    @Test
    void BankingApplicationTest() throws InterruptedException {

        BAHomePage  baHomePage = new BAHomePage();
        BAManagerLoginPage baManagerLoginPage = new BAManagerLoginPage();
        BACustomerManagementPage baCustomerManagementPage = new BACustomerManagementPage();
        BAAccountManagementPage baAccountManagementPage = new BAAccountManagementPage();
        BACustomerLoginPage baCustomerLoginPage = new BACustomerLoginPage();
        BATransactionPage baTransactionPage = new BATransactionPage();
//        BADeleteCustomerPage baDeleteCustomerPage = new BADeleteCustomerPage();

        Driver.getDriver().get(ConfigReader.getProperty("ba_url"));

        baHomePage.managerLogin.click();
        baManagerLoginPage.addCustomer.click();

//        1. Add 5 new customer
        baManagerLoginPage.addCustomer.click();

        for (int i = 0; i < 5; i++) {
            baCustomerManagementPage.fName.sendKeys(Faker.instance().name().firstName());
            baCustomerManagementPage.lName.sendKeys(Faker.instance().name().lastName());
            baCustomerManagementPage.postCd.sendKeys(Faker.instance().address().zipCode());
            baCustomerManagementPage.submit.click();

            try {
                Driver.getDriver().switchTo().alert().accept();
            } catch (Exception ignored) {
            }
        }

//        2. Open 5 new customer accounts
        baManagerLoginPage.openAccount.click();
        Select userSelect = new Select(baAccountManagementPage.userSelect);
        Select currencySelect = new Select(baAccountManagementPage.currency);

        for (int i = 6; i < 11; i++) {
            userSelect.selectByIndex(i);
            currencySelect.selectByIndex(1);
            baAccountManagementPage.Process.click();

            try {
                Driver.getDriver().switchTo().alert().accept();
            } catch (Exception ignored) {}
        }

//        3. Deposit 100 USD to each account
        baHomePage.home.click();
        baHomePage.customerLogin.click();

        Select selectCustomer = new Select(baCustomerLoginPage.LoginUserSelect);
        for (int i = 6; i < 11; i++) {
            selectCustomer.selectByIndex(i);
            baCustomerLoginPage.Login.click();

            baTransactionPage.deposit.click();
            baTransactionPage.amount.sendKeys("100");
            baTransactionPage.depositBtn.click();

            baCustomerLoginPage.Logout.click();
        }




//        4. Withdraw 100 USD from any one account
        selectCustomer = new Select(baCustomerLoginPage.LoginUserSelect);
        selectCustomer.selectByIndex(6);
        baCustomerLoginPage.Login.click();

        baTransactionPage.withDrawl.click();
        baTransactionPage.withDrawlInput.sendKeys("100");
        baTransactionPage.withDrawlBtn.click();

        baCustomerLoginPage.Logout.click();

//        5. Delete all created accounts
        baHomePage.home.click();
        baHomePage.managerLogin.click();
        baManagerLoginPage.customers.click();

        int initialCustomerCount = baCustomerManagementPage.delete.size();
        for (int i = initialCustomerCount - 1; i >= initialCustomerCount - 5; i--) {
            baCustomerManagementPage.delete.get(i).click();
        }

//        6. Verify account operations
        List<WebElement> rowsAfterDelete = Driver.getDriver().findElements(By.xpath("//table//tbody//tr"));
        Assert.assertEquals(rowsAfterDelete.size(), initialCustomerCount - 5);


        Driver.closeDriver();

    }

}
