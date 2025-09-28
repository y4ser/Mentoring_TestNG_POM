package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BACustomerLoginPage {

    public BACustomerLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@ng-model='custId']")
    public WebElement LoginUserSelect;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement Login;

    @FindBy(xpath = "//button[@ng-click='byebye()']")
    public WebElement Logout;



}
