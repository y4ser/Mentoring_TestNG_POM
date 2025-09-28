package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BAManagerLoginPage {

    public BAManagerLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@ng-click = 'addCust()']")
    public WebElement addCustomer;


    @FindBy(xpath = "//button[@ng-click = 'openAccount()']")
    public WebElement openAccount;


    @FindBy(xpath = "//button[@ng-click = 'showCust()']")
    public WebElement customers;

}
