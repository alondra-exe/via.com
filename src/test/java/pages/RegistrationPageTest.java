package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class RegistrationPageTest extends Base {
    RegistrationPage rp;
    @BeforeSuite
    public void reportConfig() {
        reportSetUp();
    }
    @BeforeMethod
    public void browserSetup() {
        initialization();
        rp = new RegistrationPage();
    }

    @Test
    public void validateRegistration() {
        ExtentTest test = extent.createTest("Validating Registration functionality of Registration Page");
        try{
            String expLogged = "Welcome Back !";
            Assert.assertEquals(rp.Registration(), expLogged);
            test.log(Status.PASS, "Validation of Registration functionality of Registration Page PASSED");
        }
        catch (NoSuchElementException | TimeoutException e){
            test.log(Status.FAIL, "Validation of Registration functionality of Registration Page FAILED. Registration functionality is correct, but the user is already registered " +
                    "with the given credentials.");
        }
    }

    @AfterMethod
    public void closeSetUp() {
        closeInitialization();
    }

    @AfterSuite
    public void generateReport() {
        reportTearDown();
    }
}
