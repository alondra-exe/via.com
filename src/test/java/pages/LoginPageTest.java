package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends Base {
    LoginPage lp;

    @BeforeSuite
    public void reportConfig() {
        reportSetUp();
    }

    @BeforeMethod
    public void browserSetup() {
        initialization();
        lp = new LoginPage();
    }

    @Test(priority = 1)
    public void validateLogin() {
        ExtentTest test = extent.createTest("Validating Login functionality of Login Page");
        String expLogged = "Welcome Back !";
        Assert.assertEquals(lp.Login(properties.getProperty("email"), properties.getProperty("password")), expLogged);
        test.log(Status.PASS, "Validation of Login functionality of Login Page PASSED");
    }

    @Test(priority = 2)
    public void validateLoginWithFacebook() {
        ExtentTest test = extent.createTest("Validating Login with Facebook functionality of Login Page");
        try {
            String expLogged = "Welcome Back !";
            Assert.assertEquals(lp.LoginWithFacebook(properties.getProperty("email"), properties.getProperty("password")), expLogged);
            test.log(Status.PASS, "Validation of Login functionality with Facebook of Login Page PASSED");
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "Validation of Login functionality with Facebook of Login Page FAILED. User facebook doesn't exists. But login functionality is correct.");
        }
    }

    @Test(priority = 3)
    public void validateLoginWithGoogle() {
        ExtentTest test = extent.createTest("Validating Login with Google functionality of Login Page");
        try {
            String expLogged = "Welcome Back !";
            Assert.assertEquals(lp.LoginWithGoogle(properties.getProperty("gmail"), properties.getProperty("gmail-password")), expLogged);
            test.log(Status.PASS, "Validation of Login with Google functionality of Login Page PASSED");
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "Validation of Login with Google functionality of Login Page FAILED. Login page don't let enter password.");
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
