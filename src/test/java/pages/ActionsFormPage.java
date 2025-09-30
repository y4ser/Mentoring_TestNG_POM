package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ActionsFormPage {

    private By name = By.id("name");
    private By age = By.id("age");
    private By departments = By.id("options");
    private By coding = By.xpath("//input[@value='coding']");
    private By design = By.xpath("//input[@value='design']");
    private By management = By.xpath("//input[@value='management']");
    private By male = By.xpath("//input[@value='male']");
    private By female = By.xpath("//input[@value='female']");
    private By other = By.xpath("//input[@value='other']");
    private By generate = By.xpath("//*[.='Generate Passcode']");
    private By submit = By.id("submitButton");
    WebDriver driver;
    private By source = By.id("drag1");
    private By target = By.id("drop1");
    private By contextClick = By.id("showSuccessButton");
    private By doubleClick = By.id("doubleClickButton");
    private By hover = By.id("hoverButton");
    private By assertMsg = By.id("info");

    Actions actions = new Actions(Driver.getDriver());


    public ActionsFormPage enterNames(String name){
        Driver.getDriver().findElement(this.name).sendKeys(name);
        return this;
    }

    public ActionsFormPage enterAge(String age){
        Driver.getDriver().findElement(this.age).sendKeys(age);
        return this;
    }

    public ActionsFormPage selectDepartment(String department){
        new Select(Driver.getDriver().findElement(departments)).selectByVisibleText(department);
        return this;
    }

    public ActionsFormPage clickCoding(){
        Driver.getDriver().findElement(coding).click();
        return this;
    }

    public ActionsFormPage clickDesign(){
        Driver.getDriver().findElement(design).click();
        return this;
    }

    public ActionsFormPage clickManagement(){
        Driver.getDriver().findElement(management).click();
        return this;
    }

    public ActionsFormPage clickMale(){
        Driver.getDriver().findElement(male).click();
        return this;
    }

    public ActionsFormPage clickFemale(){
        Driver.getDriver().findElement(female).click();
        return this;
    }

    public ActionsFormPage clickOther() {
        Driver.getDriver().findElement(other).click();
        return this;
    }

    public ActionsFormPage clickGenerate() {
        driver = Driver.getDriver();
        driver.findElement(generate).click();
        return this;
    }

    public ActionsFormPage handleJsAlertPasscode() {
        String code = driver.switchTo().alert().getText().replaceAll("\\D", "");
        driver.switchTo().alert().accept();
        driver.switchTo().alert().sendKeys(code);
        driver.switchTo().alert().accept();
        return this;
    }

    public ActionsFormPage clickSubmit() {
        Driver.getDriver().switchTo().frame(0);
        Driver.getDriver().findElement(submit).click();

        Driver.getDriver().switchTo().window(new ArrayList<>(Driver.getDriver().getWindowHandles()).get(1));
        return this;
    }


    public ActionsFormPage actionsClickDrag(){

//        Driver.getDriver().findElement(source);
//        Driver.getDriver().findElement(target);
        Driver.getDriver().findElement(contextClick);
        Driver.getDriver().findElement(doubleClick);
        Driver.getDriver().findElement(hover);

        return this;
    }

    public ActionsFormPage dragAndDrop(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement source1 = driver.findElement(source);
        WebElement target1 = driver.findElement(target);
        actions
                .dragAndDrop(source1, target1)
                .perform();
        return this;
    }

    public ActionsFormPage contextClick(){
        WebElement contextClick1 = driver.findElement(contextClick);
        actions
                .contextClick(contextClick1)
                .perform();
        return this;
    }

    public ActionsFormPage doubleClick(){
        WebElement doubleClick1 = driver.findElement(doubleClick);
        actions
                .doubleClick(doubleClick1)
                .perform();
        return this;
    }

    public ActionsFormPage moveToElement(){
        WebElement moveToElement1 = driver.findElement(hover);
        actions
                .moveToElement(moveToElement1)
                .perform();
        return this;
    }

    public ActionsFormPage assertActions(){
        assertTrue(Driver.getDriver().findElement(assertMsg).getText().contains("The Selenium WebDriver"));
        return this;
    }



}
