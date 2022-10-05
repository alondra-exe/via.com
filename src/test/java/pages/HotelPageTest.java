package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.*;

public class HotelPageTest extends Base {
    HotelPage hp;

    @BeforeSuite
    public void reportConfig() {
        reportSetUp();
    }

    @BeforeMethod
    public void browserSetup() {
        initialization();
        hp = new HotelPage();
    }

    @Test()
    public void validateSearchHotel() {
        ExtentTest test = extent.createTest("Validating Search Hotel functionality of Hotel Page");
        try {
            Assert.assertTrue(hp.SearchHotel(properties.getProperty("destination"), properties.getProperty("nationalityCode"),
                    properties.getProperty("residence")));
            test.log(Status.PASS, "Validation of Search Hotel functionality of Hotel Page PASSED");
        } catch (NoSuchElementException e) {
            test.log(Status.FAIL, "Validation of Search Hotel functionality of Hotel Page FAILED");
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
