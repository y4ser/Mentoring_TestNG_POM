package tasks;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.T02_FluentWebTablePage;
import utilities.Driver;

public class T02_DynamicWebTableManagement {

    /*
        Task 3: Dynamic Web Table Management
        Go to https://claruswaysda.github.io/addRecordWebTable.html
        Add records to the table using DataProvider
    */

    T02_FluentWebTablePage fluentWebTablePage = new T02_FluentWebTablePage();

    @DataProvider(name = "records")
    public Object[][] dataRecords(){
        return new Object[][]{
                {"Yaser", "24", "USA"},
                {"Ahmad", "21", "UK"},
                {"Faisal", "28", "Canada"},
                {"Mohammed", "38", "USA"},
                {"Khalid", "38", "UK"}
        };
    }

    @Test(dataProvider = "records")
    void dynamicWebTableManagementTest(String name, String age, String country) {

//        Go to https://claruswaysda.github.io/addRecordWebTable.html
        Driver.getDriver().get("https://claruswaysda.github.io/addRecordWebTable.html");


//        Add records to the table using DataProvider
        fluentWebTablePage.enterName(name)
                .enterAge(age)
                .selectCountry(country)
                .clickOnAddRecord()
                .assertTableContainsText(name)
                .deleteRecordByName(name)
                .assertTableNotContainsText(name);



        Driver.closeDriver();
    }


}
