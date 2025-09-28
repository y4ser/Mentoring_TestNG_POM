package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class BACustomerManagementPage {

    public BACustomerManagementPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@ng-model = 'fName']")
    public WebElement fName;


    @FindBy(xpath = "//input[@ng-model = 'lName']")
    public WebElement lName;

    @FindBy(xpath = "//input[@ng-model = 'postCd']")
    public WebElement postCd;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement submit;

    @FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
    public List <WebElement> delete;

}
