package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BookHotelPageTest extends Base {
    HotelPage hp;
    SearchHotelPage shp;
    BookHotelPage bhp;

    @BeforeSuite
    public void reportConfig() {
        reportSetUp();
    }

    @BeforeMethod
    public void browserSetup() {
        initialization();
        hp = new HotelPage();
        shp = new SearchHotelPage();
        bhp = new BookHotelPage();
    }

    @Test
    public void validateGuestDetails() {
        hp.SearchHotel(properties.getProperty("destination"), properties.getProperty("nationalityCode"),
                properties.getProperty("residence"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        shp.BookRooms();
        ExtentTest test = extent.createTest("Validating Guests Details functionality of Book Hotel Page");
        try {
            Assert.assertTrue(bhp.GuestDetails(properties.getProperty("title"), properties.getProperty("firstname"), properties.getProperty("lastname"),
                    properties.getProperty("pan-number"), properties.getProperty("nationality"), properties.getProperty("passport-number"),
                    properties.getProperty("day-expiry"), properties.getProperty("month-expiry"), properties.getProperty("year-expiry"),
                    properties.getProperty("number-code"), properties.getProperty("phone-number"), properties.getProperty("email")));
            test.log(Status.PASS, "Validation of Guests Details functionality of Book Hotel Page PASSED");
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "Validation of Guests Details functionality of Book Flight Page FAILED");
        }
    }

    @Test
    public void validateReviewItinerary() {
        hp.SearchHotel(properties.getProperty("destination"), properties.getProperty("nationalityCode"),
                properties.getProperty("residence"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        shp.BookRooms();
        bhp.GuestDetails(properties.getProperty("title"), properties.getProperty("firstname"), properties.getProperty("lastname"),
                properties.getProperty("pan-number"), properties.getProperty("nationality"), properties.getProperty("passport-number"),
                properties.getProperty("day-expiry"), properties.getProperty("month-expiry"), properties.getProperty("year-expiry"),
                properties.getProperty("number-code"), properties.getProperty("phone-number"), properties.getProperty("email"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        ExtentTest test = extent.createTest("Validating Review Itinerary Page of Book Hotel Page");
        try {
            Assert.assertTrue(bhp.ReviewItinerary());
            test.log(Status.PASS, "Validation of Review Itinerary Page of Book Hotel Page PASSED");
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "Validation of Review Itinerary Page of Book Hotel Page FAILED");
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
