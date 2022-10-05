package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class FlightPageTest extends Base {
    FlightPage fp;
    @BeforeSuite
    public void reportConfig() {
        reportSetUp();
    }
    @BeforeMethod
    public void browserSetup() {
        initialization();
        fp = new FlightPage();
    }

    @Test
    public void validateSearchOneWayFlight() {
        ExtentTest test = extent.createTest("Validating Search One Way Flight functionality of Flight Page");
        try{
            Assert.assertTrue(fp.SearchMultiCityFlight());
            test.log(Status.PASS, "Validation of Search One Way Flight functionality of Flight Page PASSED");
        }
        catch (NoSuchElementException e){
            test.log(Status.FAIL, "Validation of Search One Way Flight functionality of Flight Page FAILED");
        }
    }

    @Test
    public void validateSearchRoundTripFlight() {
        ExtentTest test = extent.createTest("Validating Search Round Trip Flight functionality of Flight Page");
        try{
            Assert.assertTrue(fp.SearchMultiCityFlight());
            test.log(Status.PASS, "Validation of Search Round Trip Flight functionality of Flight Page PASSED");
        }
        catch (NoSuchElementException e){
            test.log(Status.FAIL, "Validation of Search Round Trip Flight functionality of Flight Page FAILED");
        }
    }

    @Test
    public void validateMultiCityFlight() {
        ExtentTest test = extent.createTest("Validating Search Multi-city Flight functionality of Flight Page");
        try{
            Assert.assertTrue(fp.SearchMultiCityFlight());
            test.log(Status.PASS, "Validation of Multi-city Flight functionality of Flight Page PASSED");
        }
        catch (NoSuchElementException e){
            test.log(Status.FAIL, "Validation of Multi-city Flight functionality of Flight Page FAILED");
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
