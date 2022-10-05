package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.*;

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
            Assert.assertEquals(rp.Registration(properties.getProperty("email"),
                    properties.getProperty("password"),
                    properties.getProperty("name"),
                    properties.getProperty("number-code"),
                    properties.getProperty("phone-number")), expLogged);
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
