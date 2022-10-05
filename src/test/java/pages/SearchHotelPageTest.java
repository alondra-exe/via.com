package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class SearchHotelPageTest extends Base {
    @BeforeSuite
    public void reportConfig() {
        reportSetUp();
    }

    @BeforeMethod
    public void browserSetup() {
        initialization();
        hotelPageTest.validateSearchHotel();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test
    public void validateBookRooms() {
        ExtentTest test = extent.createTest("Validating Booking a Hotel functionality of Search Hotel Page");
        WebElement selectRoom = new WebDriverWait(driver, Duration.ofSeconds(80))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='0']/div[3]/div[3]/div[1]")));
        selectRoom.click();
        WebElement bookRoom = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='roomHotel0']/div[1]/div/div[3]/div[2]")));
        bookRoom.click();
        test.log(Status.PASS, "Validation of Booking a Hotel functionality of Search Hotel Page PASSED");
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
