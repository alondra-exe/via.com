package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SearchFlightPageTest extends Base {
    FlightPage fp;
    FlightPageTest fpt;
    SearchFlightPage sfp;
    @BeforeSuite
    public void reportConfig() {
        reportSetUp();
    }

    @BeforeMethod
    public void browserSetup() {
        initialization();
        fp = new FlightPage();
        sfp = new SearchFlightPage();
    }

    @Test
    public void validateModifyFlightSearch() {
        fp.SearchOneWayFlight();
        ExtentTest test = extent.createTest("Validating Modify Flight functionality of Search Flight Page");
        try{
            Assert.assertEquals(sfp.ModifyFlightSearch(), "a");
            test.log(Status.PASS, "Validation of Modify Flight functionality of Search Flight Page PASSED");
        }
        catch (NoSuchElementException | TimeoutException e){
            test.log(Status.FAIL, "Validation of Modify Flight functionality of Search Flight Page FAILED");
        }
    }

    @Test
    public void validateBookFlight() {
        fp.SearchOneWayFlight();
        ExtentTest test = extent.createTest("Validating Booking a Flight functionality of Search Flight Page");
        try {
            Assert.assertTrue(sfp.BookFlight());
            test.log(Status.PASS, "Validation of Booking a Flight functionality of Search Flight Page PASSED");
        }
        catch (NoSuchElementException e){
            test.log(Status.FAIL, "Validation of Booking a Flight functionality of Search Flight Page FAILED. Page don't loaded on time.");
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
