package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.Set;

public class LoginPageTest extends Base {
    @BeforeSuite
    public void reportConfig() {
        reportSetUp();
    }

    @BeforeMethod
    public void browserSetup() {
        initialization();
    }

    @Test
    public void validateLogin() {
        ExtentTest test = extent.createTest("Validating Login functionality of Login Page");
        WebElement login = driver.findElement(By.xpath("//div[@id='SignIn']"));
        actions.moveToElement(login).click().build().perform();
        driver.findElement(By.id("loginIdText")).sendKeys(properties.getProperty("email"));
        driver.findElement(By.id("passwordText")).sendKeys(properties.getProperty("password"));
        driver.findElement(By.id("loginValidate")).click();
        driver.findElement(By.id("userNameSecondaryNav")).click();
        String actLogged = driver.findElement(By.xpath("//div[@id='userNameSecondaryNavContent']/div/div[1]/p")).getText();
        String expLogged = "Welcome Back !";
        Assert.assertEquals(actLogged, expLogged);
        test.log(Status.PASS, "Validation of Login functionality of Login Page PASSED");
    }

    @Test
    public void validateLoginWithFacebook() {
        ExtentTest test = extent.createTest("Validating Login with Facebook functionality of Login Page");
        WebElement login = driver.findElement(By.xpath("//div[@id='SignIn']"));
        actions.moveToElement(login).click().build().perform();
        driver.findElement(By.id("loginFacebook")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.id("email")).sendKeys(properties.getProperty("email"));
        driver.findElement(By.id("pass")).sendKeys(properties.getProperty("password"));
        driver.findElement(By.id("loginbutton")).click();
        try{
            driver.findElement(By.id("userNameSecondaryNav")).click();
            String actLogged = driver.findElement(By.xpath("//div[@id='userNameSecondaryNavContent']/div/div[1]/p")).getText();
            String expLogged = "Welcome Back !";
            Assert.assertEquals(actLogged, expLogged);
            test.log(Status.PASS, "Validation of Login functionality with Facebook of Login Page PASSED");
        }
        catch (NoSuchElementException e){
            test.log(Status.FAIL, "Validation of Login functionality with Facebook of Login Page FAILED. User facebook doesn't exists. But login functionality is correct.");
        }
    }

    @Test
    public void validateLoginWithGoogle() {
        ExtentTest test = extent.createTest("Validating Login with Google functionality of Login Page");
        WebElement login = driver.findElement(By.xpath("//div[@id='SignIn']"));
        actions.moveToElement(login).click().build().perform();
        driver.findElement(By.id("loginGoogle")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.id("identifierId")).sendKeys(properties.getProperty("gmail"));
        driver.findElement(By.id("identifierNext")).click();
        try{
            driver.findElement(By.xpath("//div[@id='password']/div[1]/div/div[1]/input")).sendKeys(properties.getProperty("gmailpassword"));
            driver.findElement(By.id("passwordNext")).click();
            driver.findElement(By.id("userNameSecondaryNav")).click();
            String actLogged = driver.findElement(By.xpath("//div[@id='userNameSecondaryNavContent']/div/div[1]/p")).getText();
            String expLogged = "Welcome Back !";
            Assert.assertEquals(actLogged, expLogged);
            test.log(Status.PASS, "Validation of Login with Google functionality of Login Page PASSED");
        }
        catch (NoSuchElementException e){
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
