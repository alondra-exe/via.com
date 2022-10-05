package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SearchHotelPageTest extends Base {
    HotelPage hp;
    SearchHotelPage shp;

    @BeforeSuite
    public void reportConfig() {
        reportSetUp();
    }

    @BeforeMethod
    public void browserSetup() {
        initialization();
        hp = new HotelPage();
        shp = new SearchHotelPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test
    public void validateBookRooms() {
        hp.SearchHotel(properties.getProperty("destination"), properties.getProperty("nationalityCode"),
                properties.getProperty("residence"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        ExtentTest test = extent.createTest("Validating Booking a Hotel functionality of Search Hotel Page");
        try {
            Assert.assertTrue(shp.BookRooms());
            test.log(Status.PASS, "Validation of Booking a Hotel functionality of Search Hotel Page PASSED");
        } catch (NoSuchElementException | TimeoutException e) {
            test.log(Status.FAIL, "Validation of Booking a Hotel functionality of Search Hotel Page FAILED");
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
