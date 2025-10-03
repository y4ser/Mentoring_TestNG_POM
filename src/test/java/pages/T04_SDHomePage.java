package pages;

import org.openqa.selenium.By;
import utilities.Driver;

import static org.testng.Assert.assertEquals;

public class T04_SDHomePage {

    private By username = By.xpath("//input[@id='user-name']");
    private By password = By.xpath("//input[@id='password']");
    private By login = By.xpath("//input[@id='login-button']");
    private By loginLogo = By.className("login_logo");

    public T04_SDHomePage enterUsername(String username){
        Driver.getDriver().findElement(this.username).sendKeys(username);
        return this;
    }

    public T04_SDHomePage enterPassword(String password){
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    public T04_SDHomePage loginButton(){
        Driver.getDriver().findElement(login).click();
        return this;
    }

    public T04_SDHomePage assertLoginLogo(){
//        Driver.getDriver().findElement(loginLogo).getText();
        assertEquals(Driver.getDriver().findElement(loginLogo).getText(), "Swag Labs");
        return this;
    }

}
