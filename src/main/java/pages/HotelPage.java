package pages;

import base.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HotelPage extends Base {
    @FindBy(id = "destination")
    WebElement destination;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[3]/div/div[2]/div/div")
    WebElement calendarCheckIn;
    @FindBy(xpath = "//div[@id='depart-cal']/div[3]//div[text()='24']")
    WebElement dateCheckIn;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[3]/div/div[3]/div/div")
    WebElement calendarCheckOut;
    @FindBy(xpath = "//div[@id='return-cal']/div[4]//div[text()='20']")
    WebElement dateCheckOut;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[3]/div/div[4]/div/span[3]")
    WebElement passengers;
    @FindBy(xpath = "//div[@class='counter-element adult js-count via-processed']/div/div[@class='minus']")
    WebElement minusAdults;
    @FindBy(xpath = "//div[@class='roomConfigFooter']//div[@class='done']")
    WebElement donePassengers;
    @FindBy(id = "nationalityCountry")
    WebElement nationalityCountryDropDown;
    @FindBy(id = "residenceCountry")
    WebElement residenceCountryDropDown;
    @FindBy(xpath = "/html/body/div[3]/div[3]/div/form/div[3]/div/div[10]/div[3]")
    WebElement searchHotel;
    @FindBy(xpath = "//div[@id='0']/div[3]/div[3]/div[1]")
    WebElement selectRoom;

    public HotelPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean SearchHotel(String destinationPlace, String nationalityCode, String residenceCountry) {
        driver.navigate().to(properties.getProperty("urlHotels"));
        actions.moveToElement(destination).click().sendKeys(destinationPlace).pause(Duration.ofSeconds(5)).click().keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        calendarCheckIn.click();
        webWait.until(ExpectedConditions.visibilityOf(dateCheckIn)).click();
        calendarCheckOut.click();
        webWait.until(ExpectedConditions.visibilityOf(dateCheckOut)).click();
        passengers.click();
        minusAdults.click();
        donePassengers.click();
        Select nationality = new Select(nationalityCountryDropDown);
        nationality.selectByValue(nationalityCode);
        Select residence = new Select(residenceCountryDropDown);
        residence.selectByValue(residenceCountry);
        searchHotel.click();
        webWait.until(ExpectedConditions.elementToBeClickable(selectRoom));
        return selectRoom.isDisplayed();
    }
}
