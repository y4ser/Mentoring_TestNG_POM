package tasks;

import org.testng.annotations.Test;
import utilities.Driver;

public class T05_ScreenshotCapture {

    /*
    Task 4: Screenshot Capture Listener for Failed Tests
    Objective: Implement a custom TestNG listener that automatically captures screenshots when tests fail.
    Requirements:
    Create a custom listener class implementing ITestListener interface
    Override the onTestFailure method to capture screenshots
    Save screenshots in a "screenshots" folder with meaningful names (testName_timestamp.png)
    Include browser setup in the listener to access WebDriver instance
    Apply the listener to a test class that contains at least one intentionally failing test
    Verify screenshots are captured and saved correctly when tests fail
     */

    @Test
    void passingTest(){

        Driver.getDriver().get("https://www.instagram.com/");


    }

    @Test
    void failingTest (){

        Driver.getDriver().get("https://github.com/login");

        assert false;


    }

}
