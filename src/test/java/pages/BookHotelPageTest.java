package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.time.Duration;

public class BookHotelPageTest extends Base {
    @BeforeSuite
    public void reportConfig() {
        reportSetUp();
    }

    @BeforeMethod
    public void browserSetup() {
        initialization();
        hotelPageTest.validateSearchHotel();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        searchHotelPageTest.validateBookRooms();
    }

    @Test
    public void validateGuestDetails() {
        ExtentTest test = extent.createTest("Validating Guests Details functionality of Book Hotel Page");
        WebElement titleDropDown = driver.findElement(By.xpath("//div[@id='room1Adult1']/div/div[1]/div[1]/label/select"));
        Select title = new Select(titleDropDown);
        title.selectByValue(properties.getProperty("title"));
        driver.findElement(By.xpath("//div[@id='room1Adult1']/div/div[1]/div[2]/input")).sendKeys(properties.getProperty("firstname"));
        driver.findElement(By.xpath("//div[@id='room1Adult1']/div/div[1]/div[3]/input")).sendKeys(properties.getProperty("lastname"));
        driver.findElement(By.xpath("//div[@id='room1Adult1']/div/div[1]/div[4]/input")).sendKeys(properties.getProperty("pannumber"));
        WebElement passportNationalityDropDown = driver.findElement(By.id("Room0AdultPassportNAT0"));
        Select passportNationality = new Select(passportNationalityDropDown);
        passportNationality.selectByValue(properties.getProperty("nationality"));
        driver.findElement(By.id("Room0AdultPassportNUM0")).sendKeys(properties.getProperty("passportnumber"));
        WebElement dayExpiryDropDown = driver.findElement(By.id("room1Adult1Pday"));
        Select dayExpiry = new Select(dayExpiryDropDown);
        dayExpiry.selectByValue(properties.getProperty("dayexpiry"));
        WebElement monthExpiryDropDown = driver.findElement(By.id("room1Adult1Pmonth"));
        Select monthExpiry = new Select(monthExpiryDropDown);
        monthExpiry.selectByIndex(Integer.parseInt(properties.getProperty("monthexpiry")));
        WebElement yearExpiryDropDown = driver.findElement(By.id("room1Adult1Pyear"));
        Select yearExpiry = new Select(yearExpiryDropDown);
        yearExpiry.selectByValue(properties.getProperty("yearexpiry"));
        WebElement mobileCodeDropDown = driver.findElement(By.id("ISDCodeTr"));
        Select mobileCode = new Select(mobileCodeDropDown);
        mobileCode.selectByValue(properties.getProperty("numbercode"));
        driver.findElement(By.id("contactMobile")).sendKeys(properties.getProperty("phonenumber"));
        driver.findElement(By.id("contactEmail")).sendKeys(properties.getProperty("email"));
        driver.findElement(By.id("read_terms_label")).click();
        driver.findElement(By.id("makePayCTA")).click();
        test.log(Status.PASS, "Validation of Guests Details functionality of Book Hotel Page PASSED");
    }

    @Test
    public void validateReviewItinerary() {
        validateGuestDetails();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        ExtentTest test = extent.createTest("Validating Review Itinerary Page of Book Hotel Page");
        driver.findElement(By.id("confirmProceedPayBtn")).click();
        test.log(Status.PASS, "Validation of Review Itinerary Page of Book Hotel Page PASSED");
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
