package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BookHotelPage extends Base {
    public boolean GuestDetails() {
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
        return driver.findElement(By.id("confirmProceedPayBtn")).isDisplayed();
    }

    public boolean ReviewItinerary() {
        driver.findElement(By.id("confirmProceedPayBtn")).click();
        return driver.findElement(By.id("paymentCTA")).isDisplayed();
    }
}
