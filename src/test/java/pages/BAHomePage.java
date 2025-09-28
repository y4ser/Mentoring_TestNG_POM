package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BAHomePage {

    public BAHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@ng-click = 'manager()']")
    public WebElement managerLogin;

    @FindBy(xpath = "//button[@ng-click = 'customer()']")
    public WebElement customerLogin;

    @FindBy(xpath = "//button[@ng-click = 'home()']")
    public WebElement home;

}
