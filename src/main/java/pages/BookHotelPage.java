package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BookHotelPage extends Base {
    @FindBy(xpath = "//div[@id='room1Adult1']/div/div[1]/div[1]/label/select")
    WebElement titleDropDown;
    @FindBy(xpath = "//div[@id='room1Adult1']/div/div[1]/div[2]/input")
    WebElement firstNameH;
    @FindBy(xpath = "//div[@id='room1Adult1']/div/div[1]/div[3]/input")
    WebElement lastnameH;
    @FindBy(xpath = "//div[@id='room1Adult1']/div/div[1]/div[4]/input")
    WebElement panNumberH;
    @FindBy(id = "Room0AdultPassportNAT0")
    WebElement passportNationalityDropDown;
    @FindBy(id = "Room0AdultPassportNUM0")
    WebElement passportNumber;
    @FindBy(id = "room1Adult1Pday")
    WebElement dayExpiryDropDown;
    @FindBy(id = "room1Adult1Pmonth")
    WebElement monthExpiryDropDown;
    @FindBy(id = "room1Adult1Pyear")
    WebElement yearExpiryDropDown;
    @FindBy(id = "ISDCodeTr")
    WebElement mobileCodeDropDown;
    @FindBy(id = "contactMobile")
    WebElement mobileH;
    @FindBy(id = "contactEmail")
    WebElement emailH;
    @FindBy(id = "read_terms_label")
    WebElement readTerms;
    @FindBy(id = "confirmProceedPayBtn")
    WebElement confirmProceedPayBtn;
    @FindBy(id = "makePayCTA")
    WebElement makePayCTA;
    @FindBy(id = "paymentCTA")
    WebElement paymentCTA;

    public BookHotelPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean GuestDetails(String title, String firstname, String lastname, String panNumber,
                                String pNationality, String pNumber, String expiryDay, String expiryMonth, String expiryYear,
                                String codeNumber, String phoneNumber, String email) {
        Select titleSelected = new Select(titleDropDown);
        titleSelected.selectByValue(title);
        firstNameH.sendKeys(firstname);
        lastnameH.sendKeys(lastname);
        panNumberH.sendKeys(panNumber);
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
        mobileH.sendKeys(phoneNumber);
        emailH.sendKeys(email);
        readTerms.click();
        actions.moveToElement(makePayCTA).pause(Duration.ofSeconds(10)).click().build().perform();
        return confirmProceedPayBtn.isDisplayed();
    }

    public boolean ReviewItinerary() {
        confirmProceedPayBtn.click();
        webWait.until(ExpectedConditions.elementToBeClickable(paymentCTA));
        return paymentCTA.isDisplayed();
    }
}
