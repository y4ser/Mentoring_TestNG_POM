package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ActionsFormPage;
import utilities.Driver;

public class C03_ActionsForm {

    /*
        Go to https://claruswaysda.github.io/ActionsForm.html
        Fill form and submit
        Do all actions and assert
*/
    @Test(threadPoolSize = 3, invocationCount = 2)
    void actionsFormTest() {
        ActionsFormPage actionsFormPage = new ActionsFormPage();
//        Go to https://claruswaysda.github.io/ActionsForm.html
        Driver.getDriver().get("https://claruswaysda.github.io/ActionsForm.html");

//        Fill form and submit
        actionsFormPage.enterNames("Yaser")
                .enterAge("24")
                .selectDepartment("IT Department")
                .clickCoding()
                .clickMale()
                .clickGenerate()
                .handleJsAlertPasscode()
                .clickSubmit();


//        Do all actions and assert
        actionsFormPage
                .dragAndDrop()
                .contextClick()
                .doubleClick()
                .moveToElement()
                .assertActions();


        Driver.closeDriver();

    }


}
