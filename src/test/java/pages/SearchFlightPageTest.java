package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SearchFlightPageTest extends Base {
    @BeforeSuite
    public void reportConfig() {
        reportSetUp();
    }

    @BeforeMethod
    public void browserSetup() {
        initialization();
        flightPageTest.validateSearchOneWayFlight();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test
    public void validateSearchFlightPage() {
        ExtentTest test = extent.createTest("Validating Flight Results Page of Search Flight Page");
        boolean flightResume = driver.findElement(By.xpath("//html/body/div[7]/div/div[2]/div[2]/div")).isDisplayed();
        boolean searchRefineResults = driver.findElement(By.xpath("//html/body/div[7]/div/div[2]/div[3]/div")).isDisplayed();
        boolean flightResults = driver.findElement(By.id("flightSearchResults")).isDisplayed();
        Assert.assertTrue(flightResume);
        Assert.assertTrue(searchRefineResults);
        Assert.assertTrue(flightResults);
        test.log(Status.PASS, "Validation of Flight Results Page of Search Flight Page PASSED");
    }

    @Test
    public void validateModifyFlightSearch() {
        ExtentTest test = extent.createTest("Validating Modify Flight functionality of Search Flight Page");
        driver.findElement(By.xpath("//html/body/div[7]/div/div[2]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='round-trip-panel']/div[4]/div/div")).click();
        WebElement departureDate = driver.findElement(By.xpath("//div[@id='depart-cal']/div[3]//div[text()='4']"));
        wait.until(ExpectedConditions.visibilityOf(departureDate)).click();
        driver.findElement(By.xpath("//div[@class='counter-element adult']/div/div[@class='plus']")).click();
        driver.findElement(By.id("search-flight-btn")).click();
        test.log(Status.PASS, "Validation of Modify Flight functionality of Search Flight Page PASSED");
    }

    @Test
    public void validateBookFlight() {
        ExtentTest test = extent.createTest("Validating Booking a Flight functionality of Search Flight Page");

        try {
            WebElement bookFlight = new WebDriverWait(driver, Duration.ofSeconds(60))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oneway']/div[5]/div/div/div[2]/button")));
            bookFlight.click();
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
