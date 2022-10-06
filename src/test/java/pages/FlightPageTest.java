package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.*;

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

    @Test(priority = 1)
    public void validateSearchOneWayFlight() {
        ExtentTest test = extent.createTest("Validating Search One Way Flight functionality of Flight Page");
        try {
            Assert.assertTrue(fp.SearchOneWayFlight(properties.getProperty("from"), properties.getProperty("to")));
            test.log(Status.PASS, "Validation of Search One Way Flight functionality of Flight Page PASSED");
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "Validation of Search One Way Flight functionality of Flight Page FAILED");
        }
    }

    @Test(priority = 2)
    public void validateSearchRoundTripFlight() {
        ExtentTest test = extent.createTest("Validating Search Round Trip Flight functionality of Flight Page");
        try {
            Assert.assertTrue(fp.SearchRoundTripFlight(properties.getProperty("from"), properties.getProperty("to")));
            test.log(Status.PASS, "Validation of Search Round Trip Flight functionality of Flight Page PASSED");
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "Validation of Search Round Trip Flight functionality of Flight Page FAILED");
        }
    }

    @Test(priority = 3)
    public void validateMultiCityFlight() {
        ExtentTest test = extent.createTest("Validating Search Multi-city Flight functionality of Flight Page");
        try {
            Assert.assertTrue(fp.SearchMultiCityFlight(properties.getProperty("from"),
                    properties.getProperty("to"),
                    properties.getProperty("to2")));
            test.log(Status.PASS, "Validation of Multi-city Flight functionality of Flight Page PASSED");
        } catch (NoSuchElementException e) {
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
