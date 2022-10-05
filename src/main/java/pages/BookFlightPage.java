package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookFlightPage extends Base {
    public boolean TravellersDetails(String title, String firstname, String lastname, String birthDay, String birthMonth, String birthYear,
                                     String pNationality, String pNumber, String expiryDay, String expiryMonth, String expiryYear,
                                     String codeNumber, String phoneNumber, String email) {
        WebElement titleDropDown = driver.findElement(By.id("adult1Title"));
        Select titleSelect = new Select(titleDropDown);
        titleSelect.selectByValue(title);
        driver.findElement(By.id("adult1FirstName")).sendKeys(firstname);
        driver.findElement(By.id("adult1Surname")).sendKeys(lastname);
        WebElement dayBirthDropDown = driver.findElement(By.id("adult1DOBday"));
        Select dayBirth = new Select(dayBirthDropDown);
        dayBirth.selectByValue(birthDay);
        WebElement monthBirthDropDown = driver.findElement(By.id("adult1DOBmonth"));
        Select monthBirth = new Select(monthBirthDropDown);
        monthBirth.selectByIndex(Integer.parseInt(birthMonth));
        WebElement yearBirthDropDown = driver.findElement(By.id("adult1DOByear"));
        Select yearBirth = new Select(yearBirthDropDown);
        yearBirth.selectByValue(birthYear);
        WebElement passportNationalityDropDown = driver.findElement(By.id("adult1PassportNAT"));
        Select passportNationality = new Select(passportNationalityDropDown);
        passportNationality.selectByValue(pNationality);
        driver.findElement(By.id("adult1PassportNUM")).sendKeys(pNumber);
        WebElement dayExpiryDropDown = driver.findElement(By.id("adult1Pday"));
        Select dayExpiry = new Select(dayExpiryDropDown);
        dayExpiry.selectByValue(expiryDay);
        WebElement monthExpiryDropDown = driver.findElement(By.id("adult1Pmonth"));
        Select monthExpiry = new Select(monthExpiryDropDown);
        monthExpiry.selectByIndex(Integer.parseInt(expiryMonth));
        WebElement yearExpiryDropDown = driver.findElement(By.id("adult1Pyear"));
        Select yearExpiry = new Select(yearExpiryDropDown);
        yearExpiry.selectByValue(expiryYear);
        WebElement mobileCodeDropDown = driver.findElement(By.id("ISDCodeTr"));
        Select mobileCode = new Select(mobileCodeDropDown);
        mobileCode.selectByValue(codeNumber);
        driver.findElement(By.id("contactMobile")).sendKeys(phoneNumber);
        driver.findElement(By.id("contactEmail")).sendKeys(email);
        WebElement fareChange = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("fareChangeMessage"))));
        if (fareChange.isDisplayed()) {
            driver.findElement(By.id("repiceContBook")).click();
        }
        WebElement bookFlight = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("makePayCTA"))));
        bookFlight.click();
        return driver.findElement(By.id("confirmProceedPayBtn")).isDisplayed();
    }

    public boolean ReviewItinerary() {
        driver.findElement(By.xpath("//div[@id='refundProtectDiv']/div[3]/div/div[4]/div[1]/div/label")).click();
        driver.findElement(By.id("confirmProceedPayBtn")).click();
        return driver.findElement(By.id("paymentCTA")).isDisplayed();
    }
}
