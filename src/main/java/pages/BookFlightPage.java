package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BookFlightPage extends Base {
    @FindBy(id = "adult1Title")
    WebElement titleDropDown;
    @FindBy(id = "adult1FirstName")
    WebElement firstNameF;
    @FindBy(id = "adult1Surname")
    WebElement lastnameF;
    @FindBy(id = "adult1DOBday")
    WebElement dayBirthDropDown;
    @FindBy(id = "adult1DOBmonth")
    WebElement monthBirthDropDown;
    @FindBy(id = "adult1DOByear")
    WebElement yearBirthDropDown;
    @FindBy(id = "adult1PassportNAT")
    WebElement passportNationalityDropDown;
    @FindBy(id = "adult1PassportNUM")
    WebElement passportNumber;
    @FindBy(id = "adult1Pday")
    WebElement dayExpiryDropDown;
    @FindBy(id = "adult1Pmonth")
    WebElement monthExpiryDropDown;
    @FindBy(id = "adult1Pyear")
    WebElement yearExpiryDropDown;
    @FindBy(id = "ISDCodeTr")
    WebElement mobileCodeDropDown;
    @FindBy(id = "contactMobile")
    WebElement mobileF;
    @FindBy(id = "contactEmail")
    WebElement emailF;
    @FindBy(id = "makePayCTA")
    WebElement makePayCTA;
    @FindBy(id = "confirmProceedPayBtn")
    WebElement confirmProceedPayBtn;
    @FindBy(xpath = "//div[@id='refundProtectDiv']/div[3]/div/div[4]/div[1]/div/label")
    WebElement refundProtectDiv;
    @FindBy(id = "paymentCTA")
    WebElement paymentCTA;

    public BookFlightPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean TravellersDetails(String title, String firstname, String lastname, String birthDay, String birthMonth, String birthYear,
                                     String pNationality, String pNumber, String expiryDay, String expiryMonth, String expiryYear,
                                     String codeNumber, String phoneNumber, String email) {
        Select titleSelect = new Select(titleDropDown);
        titleSelect.selectByValue(title);
        firstNameF.sendKeys(firstname);
        lastnameF.sendKeys(lastname);
        Select dayBirth = new Select(dayBirthDropDown);
        dayBirth.selectByValue(birthDay);
        Select monthBirth = new Select(monthBirthDropDown);
        monthBirth.selectByIndex(Integer.parseInt(birthMonth));
        Select yearBirth = new Select(yearBirthDropDown);
        yearBirth.selectByValue(birthYear);
        Select passportNationality = new Select(passportNationalityDropDown);
        passportNationality.selectByValue(pNationality);
        passportNumber.sendKeys(pNumber);
        Select dayExpiry = new Select(dayExpiryDropDown);
        dayExpiry.selectByValue(expiryDay);
        Select monthExpiry = new Select(monthExpiryDropDown);
        monthExpiry.selectByIndex(Integer.parseInt(expiryMonth));
        Select yearExpiry = new Select(yearExpiryDropDown);
        yearExpiry.selectByValue(expiryYear);
        Select mobileCode = new Select(mobileCodeDropDown);
        mobileCode.selectByValue(codeNumber);
        mobileF.sendKeys(phoneNumber);
        emailF.sendKeys(email);
        actions.moveToElement(makePayCTA).pause(Duration.ofSeconds(10)).click().build().perform();
        return driver.findElement(By.id("confirmProceedPayBtn")).isDisplayed();

    }

    public boolean ReviewItinerary() {
        refundProtectDiv.click();
        confirmProceedPayBtn.click();
        return paymentCTA.isDisplayed();
    }
}
