package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BATransactionPage {

    public BATransactionPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@ng-click='deposit()']")
    public WebElement deposit;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement amount;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement depositBtn;


    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    public WebElement withDrawl;

    @FindBy(xpath = "//input[@ng-model='amount']")
    public WebElement withDrawlInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement withDrawlBtn;

}
