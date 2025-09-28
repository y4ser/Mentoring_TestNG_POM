package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BAAccountManagementPage {

    public BAAccountManagementPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "userSelect")
    public WebElement userSelect;


    @FindBy(id = "currency")
    public WebElement currency;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement Process;

}
