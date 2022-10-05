package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookHotelPage extends Base {
    public boolean GuestDetails(String title, String firstname, String lastname, String panNumber,
                                String pNationality, String pNumber, String expiryDay, String expiryMonth, String expiryYear,
                                String codeNumber, String phoneNumber, String email) {
        WebElement titleDropDown = driver.findElement(By.xpath("//div[@id='room1Adult1']/div/div[1]/div[1]/label/select"));
        Select titleSelected = new Select(titleDropDown);
        titleSelected.selectByValue(title);
        driver.findElement(By.xpath("//div[@id='room1Adult1']/div/div[1]/div[2]/input")).sendKeys(firstname);
        driver.findElement(By.xpath("//div[@id='room1Adult1']/div/div[1]/div[3]/input")).sendKeys(lastname);
        driver.findElement(By.xpath("//div[@id='room1Adult1']/div/div[1]/div[4]/input")).sendKeys(panNumber);
        WebElement passportNationalityDropDown = driver.findElement(By.id("Room0AdultPassportNAT0"));
        Select passportNationality = new Select(passportNationalityDropDown);
        passportNationality.selectByValue(pNationality);
        driver.findElement(By.id("Room0AdultPassportNUM0")).sendKeys(pNumber);
        WebElement dayExpiryDropDown = driver.findElement(By.id("room1Adult1Pday"));
        Select dayExpiry = new Select(dayExpiryDropDown);
        dayExpiry.selectByValue(expiryDay);
        WebElement monthExpiryDropDown = driver.findElement(By.id("room1Adult1Pmonth"));
        Select monthExpiry = new Select(monthExpiryDropDown);
        monthExpiry.selectByIndex(Integer.parseInt(expiryMonth));
        WebElement yearExpiryDropDown = driver.findElement(By.id("room1Adult1Pyear"));
        Select yearExpiry = new Select(yearExpiryDropDown);
        yearExpiry.selectByValue(expiryYear);
        WebElement mobileCodeDropDown = driver.findElement(By.id("ISDCodeTr"));
        Select mobileCode = new Select(mobileCodeDropDown);
        mobileCode.selectByValue(codeNumber);
        driver.findElement(By.id("contactMobile")).sendKeys(phoneNumber);
        driver.findElement(By.id("contactEmail")).sendKeys(email);
        driver.findElement(By.id("read_terms_label")).click();
        driver.findElement(By.id("makePayCTA")).click();
        return driver.findElement(By.id("confirmProceedPayBtn")).isDisplayed();
    }

    public boolean ReviewItinerary() {
        driver.findElement(By.id("confirmProceedPayBtn")).click();
        return driver.findElement(By.id("paymentCTA")).isDisplayed();
    }
}
