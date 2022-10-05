package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BookFlightPageTest extends Base {
    FlightPage fp;
    SearchFlightPage sfp;
    BookFlightPage bfp;
    @BeforeSuite
    public void reportConfig() {
        reportSetUp();
    }
    @BeforeMethod
    public void browserSetUp() {
        initialization();
        fp = new FlightPage();
        sfp = new SearchFlightPage();
        bfp = new BookFlightPage();
    }

    @Test
    public void validateTravellersDetails() {
        fp.SearchOneWayFlight(properties.getProperty("from"), properties.getProperty("to"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        sfp.BookFlight();
        ExtentTest test = extent.createTest("Validating Traveller's Details functionality of Book Flight Page");
        try{
            Assert.assertTrue(bfp.TravellersDetails(properties.getProperty("title"), properties.getProperty("firstname"), properties.getProperty("lastname"),
                    properties.getProperty("day-birth"), properties.getProperty("month-birth"), properties.getProperty("year-birth"), properties.getProperty("nationality"),
                    properties.getProperty("passport-number"), properties.getProperty("day-expiry"), properties.getProperty("month-expiry"), properties.getProperty("year-expiry"),
                    properties.getProperty("number-code"), properties.getProperty("phone-number"), properties.getProperty("email")));
            test.log(Status.PASS, "Validation of Traveller's Details functionality of Book Flight Page PASSED");
        }
        catch (NoSuchElementException e){
            test.log(Status.FAIL, "Validation of Traveller's Details functionality of Book Flight Page FAILED");
        }
    }

    @Test
    public void validateReviewItinerary() {
        fp.SearchOneWayFlight(properties.getProperty("from"), properties.getProperty("to"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        sfp.BookFlight();
        bfp.TravellersDetails(properties.getProperty("title"), properties.getProperty("firstname"), properties.getProperty("lastname"),
                properties.getProperty("day-birth"), properties.getProperty("month-birth"), properties.getProperty("year-birth"), properties.getProperty("nationality"),
                properties.getProperty("passport-number"), properties.getProperty("day-expiry"), properties.getProperty("month-expiry"), properties.getProperty("year-expiry"),
                properties.getProperty("number-code"), properties.getProperty("phone-number"), properties.getProperty("email"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        ExtentTest test = extent.createTest("Validating Review Itinerary Page of Book Flight Page");
        try{
            Assert.assertTrue(bfp.ReviewItinerary());
            test.log(Status.PASS, "Validation of Review Itinerary Page of Book Flight Page PASSED");
        }
        catch (NoSuchElementException e){
            test.log(Status.FAIL, "Validation of Review Itinerary Page of Book Flight Page FAILED");
        }
    }

    @AfterMethod
    public void closeSetUp() {
        Base.closeInitialization();
    }

    @AfterSuite
    public void generateReport() {
        reportTearDown();
    }
}
