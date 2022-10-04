package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookFlightPageTest extends Base {
    @BeforeMethod
    public void browserSetUp() {
        initialization();
        flightPageTest.validateSearchOneWayFlight();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchFlightPageTest.validateBookFlight();
    }

    @Test
    public void validateTravellersDetails() {
        WebElement titleDropDown = driver.findElement(By.id("adult1Title"));
        Select title = new Select(titleDropDown);
        title.selectByValue("Mr");
        driver.findElement(By.id("adult1FirstName")).sendKeys("prueba");
        driver.findElement(By.id("adult1Surname")).sendKeys("prueba");
        WebElement dayBirthDropDown = driver.findElement(By.id("adult1DOBday"));
        Select dayBirth = new Select(dayBirthDropDown);
        dayBirth.selectByValue("03");
        WebElement monthBirthDropDown = driver.findElement(By.id("adult1DOBmonth"));
        Select monthBirth = new Select(monthBirthDropDown);
        monthBirth.selectByIndex(3);
        WebElement yearBirthDropDown = driver.findElement(By.id("adult1DOByear"));
        Select yearBirth = new Select(yearBirthDropDown);
        yearBirth.selectByValue("1975");
        WebElement passportNationalityDropDown = driver.findElement(By.id("adult1PassportNAT"));
        Select passportNationality = new Select(passportNationalityDropDown);
        passportNationality.selectByValue("CA");
        driver.findElement(By.id("adult1PassportNUM")).sendKeys("LB000375");
        WebElement dayExpiryDropDown = driver.findElement(By.id("adult1Pday"));
        Select dayExpiry = new Select(dayExpiryDropDown);
        dayExpiry.selectByValue("07");
        WebElement monthExpiryDropDown = driver.findElement(By.id("adult1Pmonth"));
        Select monthExpiry = new Select(monthExpiryDropDown);
        monthExpiry.selectByIndex(12);
        WebElement yearExpiryDropDown = driver.findElement(By.id("adult1Pyear"));
        Select yearExpiry = new Select(yearExpiryDropDown);
        yearExpiry.selectByValue("2033");
        WebElement mobileCodeDropDown = driver.findElement(By.id("ISDCodeTr"));
        Select mobileCode = new Select(mobileCodeDropDown);
        mobileCode.selectByValue("1");
        driver.findElement(By.id("contactMobile")).sendKeys("2267055077");
        driver.findElement(By.id("contactEmail")).sendKeys("testing.users.email@gmail.com");
        WebElement fareChange = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("fareChangeMessage"))));
        if (fareChange.isDisplayed()) {
            driver.findElement(By.id("repiceContBook")).click();
        }
        driver.findElement(By.id("makePayCTA")).click();
    }

    @Test
    public void validateReviewItinerary() {
        validateTravellersDetails();
        driver.findElement(By.xpath("//div[@id='refundProtectDiv']/div[3]/div/div[4]/div[1]/div/label")).click();
        driver.findElement(By.id("confirmProceedPayBtn")).click();
    }
}
