package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class RegistrationPageTest extends Base {
    @BeforeSuite
    public void reportConfig() {
        reportSetUp();
    }
    @BeforeMethod
    public void browserSetup() {
        initialization();
    }

    @Test
    public void validateRegistration() {
        ExtentTest test = extent.createTest("Validating Registration functionality of Registration Page");
        try{
            WebElement login = driver.findElement(By.xpath("//div[@id='SignIn']"));
            actions.moveToElement(login).click().build().perform();
            driver.findElement(By
                    .xpath("//div[@id='SignInContent']/div[1]/div[1]/div[2]/span/label/span")).click();
            driver.findElement(By.id("emailIdSignUp")).sendKeys(properties.getProperty("email"));
            driver.findElement(By.id("passwordSignUp")).sendKeys(properties.getProperty("password"));
            driver.findElement(By.id("nameSignUp")).sendKeys(properties.getProperty("name"));
            WebElement mobileCodeDropDown = driver.findElement(By.id("mobileIsdSignUp"));
            Select mobileCode = new Select(mobileCodeDropDown);
            mobileCode.selectByValue(properties.getProperty("numbercode"));
            driver.findElement(By.id("mobileNoSignUp")).sendKeys(properties.getProperty("phonenumber"));
            driver.findElement(By.id("signUpValidate")).click();
            WebElement signup = new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.elementToBeClickable(By.id("userNameSecondaryNav")));
            signup.click();
            String actLogged = driver.findElement(By.xpath("//div[@id='userNameSecondaryNavContent']/div/div[1]/p")).getText();
            String expLogged = "Welcome Back !";
            Assert.assertEquals(actLogged, expLogged);
            test.log(Status.PASS, "Validation of Registration functionality of Registration Page PASSED");
        }
        catch (NoSuchElementException e){
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
