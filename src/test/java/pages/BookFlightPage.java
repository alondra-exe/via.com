package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookFlightPage extends Base {
    @BeforeMethod
    public void browserSetUp(){
        initialization();
        flightPageTest.validateSearchOneWayFlight();
        searchFlightPageTest.validateBookFlight();
    }

    @Test
    public void validateTravellersDetailsPage(){
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
        monthBirth.selectByValue("03");
        WebElement yearBirthDropDown = driver.findElement(By.id("adult1DOByear"));
        Select yearBirth = new Select(yearBirthDropDown);
        yearBirth.selectByValue("03");
        WebElement passportNationalityDropDown = driver.findElement(By.id("adult1PassportNAT"));
        Select passportNationality = new Select(passportNationalityDropDown);
        passportNationality.selectByValue("CA");
        driver.findElement(By.id("adult1PassportNUM")).sendKeys("LB000375");
        WebElement dayExpiryDropDown = driver.findElement(By.id("adult1Pday"));
        Select dayExpiry = new Select(dayExpiryDropDown);
        dayExpiry.selectByValue("03");
        WebElement monthExpiryDropDown = driver.findElement(By.id("adult1Pmonth"));
        Select monthExpiry = new Select(monthExpiryDropDown);
        monthExpiry.selectByValue("03");
        WebElement yearExpiryDropDown = driver.findElement(By.id("adult1Pyear"));
        Select yearExpiry = new Select(yearExpiryDropDown);
        yearExpiry.selectByValue("03");
        WebElement mobileCodeDropDown = driver.findElement(By.id("ISDCodeTr"));
        Select mobileCode = new Select(mobileCodeDropDown);
        mobileCode.selectByValue("1");
        driver.findElement(By.id("contactMobile")).sendKeys("2267055077");
        driver.findElement(By.id("contactEmail")).sendKeys("testing.users.email@gmail.com");
    }
}
