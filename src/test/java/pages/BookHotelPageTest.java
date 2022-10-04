package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookHotelPageTest extends Base {
    @BeforeMethod
    public void browserSetup() {
        initialization();
        hotelPageTest.validateSearchHotel();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        searchHotelPageTest.validateBookRooms();
    }

    @Test
    public void validateGuestDetails(){
        WebElement titleDropDown = driver.findElement(By.xpath("//div[@id='room1Adult1']/div/div[1]/div[1]/label/select"));
        Select title = new Select(titleDropDown);
        title.selectByValue("Mr");
        driver.findElement(By.xpath("//div[@id='room1Adult1']/div/div[1]/div[2]/input")).sendKeys("prueba");
        driver.findElement(By.xpath("//div[@id='room1Adult1']/div/div[1]/div[3]/input")).sendKeys("prueba");
        driver.findElement(By.xpath("//div[@id='room1Adult1']/div/div[1]/div[4]/input")).sendKeys("ABCPL1234H");
        WebElement passportNationalityDropDown = driver.findElement(By.id("Room0AdultPassportNAT0"));
        Select passportNationality = new Select(passportNationalityDropDown);
        passportNationality.selectByValue("CA");
        driver.findElement(By.id("Room0AdultPassportNUM0")).sendKeys("LB000375");
        WebElement dayExpiryDropDown = driver.findElement(By.id("room1Adult1Pday"));
        Select dayExpiry = new Select(dayExpiryDropDown);
        dayExpiry.selectByValue("07");
        WebElement monthExpiryDropDown = driver.findElement(By.id("room1Adult1Pmonth"));
        Select monthExpiry = new Select(monthExpiryDropDown);
        monthExpiry.selectByIndex(12);
        WebElement yearExpiryDropDown = driver.findElement(By.id("room1Adult1Pyear"));
        Select yearExpiry = new Select(yearExpiryDropDown);
        yearExpiry.selectByValue("2033");
        WebElement mobileCodeDropDown = driver.findElement(By.id("ISDCodeTr"));
        Select mobileCode = new Select(mobileCodeDropDown);
        mobileCode.selectByValue("1");
        driver.findElement(By.id("contactMobile")).sendKeys("2267055077");
        driver.findElement(By.id("contactEmail")).sendKeys("testing.users.email@gmail.com");
        driver.findElement(By.id("read_terms_label")).click();
        driver.findElement(By.id("makePayCTA")).click();
    }

    @Test
    public void validateReviewItinerary() {
        validateGuestDetails();
        driver.findElement(By.id("confirmProceedPayBtn")).click();
    }
}
