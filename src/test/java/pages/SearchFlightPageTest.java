package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchFlightPageTest extends Base {
    FlightPage fp;
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
    public void validateBookFlight() {
        fp.SearchOneWayFlight(properties.getProperty("from"), properties.getProperty("to"));
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
