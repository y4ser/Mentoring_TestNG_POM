package tasks;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

public class T03_DataProviderParallelExecution {

    /*
    Task 2: Data Provider Parallel Execution
    Objective: Implement a data-driven test that runs search functionality with multiple search terms in
    parallel.
    Requirements:
    Create a data provider with at least 5 different search terms
    Enable parallel execution for the data provider
    Create a test method that accepts search terms and validates results
    Configure XML file with data-provider-thread-count of 2
     */

    @DataProvider(name = "searchTerms", parallel = true)
    public Object[][] getSearchTerms() {
        return new Object[][]{
                {"Yaser"},
                {"Khalid"},
                {"Fahad"},
                {"Mohammed"},
                {"Ali"},
        };
    }

    @Test(dataProvider = "searchTerms")
    void dataProviderTest(String username){

        Driver.getDriver().get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        Driver.getDriver().findElement(By.name("username")).sendKeys(username);

        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();


        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//li[@id='_valueusername']")).getText(), username);


        Driver.closeDriver();
    }

}
