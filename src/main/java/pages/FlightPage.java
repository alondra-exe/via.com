package pages;

import base.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class FlightPage extends Base {
    @FindBy(id = "source")
    WebElement from;
    @FindBy(id = "destination")
    WebElement to;
    @FindBy(xpath = "//div[@id='round-trip-panel']/div[4]/div[2]/div")
    WebElement calendarOWF;
    @FindBy(xpath = "//div[@id='depart-cal']/div[4]//div[text()='29']")
    WebElement departureDate;
    @FindBy(id = "search-flight-btn")
    WebElement searchFlightBtn;
    @FindBy(id = "flightSearchResults")
    WebElement flightSearchResults;
    @FindBy(className = "round-trip")
    WebElement roundTrip;
    @FindBy(xpath = "//div[@id='round-trip-panel']/div[4]/div[2]/div")
    WebElement calendarRT1;
    @FindBy(xpath = "//div[@class='element return-element']/div/div[@class='calendar-icon']")
    WebElement calendarRT2;
    @FindBy(xpath = "//div[@id='return-cal']/div[4]//div[text()='24']")
    WebElement returnDate;
    @FindBy(className = "multi-city")
    WebElement multiCity;
    @FindBy(id = "source-0")
    WebElement fromMC;
    @FindBy(id = "destination-0")
    WebElement destinationMC1;
    @FindBy(xpath = "//div[@id='multi-city-panel']/div[2]/div[3]/div/div")
    WebElement calendarMC1;
    @FindBy(xpath = "//div[@id='depart-cal-0']/div[4]//div[text()='29']")
    WebElement departureDate1;
    @FindBy(id = "multi-city-label-1")
    WebElement flight2;
    @FindBy(id = "destination-1")
    WebElement destinationMC2;
    @FindBy(xpath = "//div[@id='multi-city-panel']/div[3]/div[3]/div/div")
    WebElement calendarMC2;
    @FindBy(xpath = "//div[@id='depart-cal-1']/div[4]//div[text()='24']")
    WebElement departureDate2;

    public FlightPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean SearchOneWayFlight(String fromSource, String toDestination) {
        actions.moveToElement(from).click().sendKeys(fromSource).pause(Duration.ofSeconds(5)).keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        actions.moveToElement(to).click().sendKeys(toDestination).pause(Duration.ofSeconds(5)).keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        calendarOWF.click();
        webWait.until(ExpectedConditions.visibilityOf(departureDate)).click();
        searchFlightBtn.click();
        webWait.until(ExpectedConditions.elementToBeClickable(flightSearchResults));
        return flightSearchResults.isDisplayed();
    }

    public boolean SearchRoundTripFlight(String fromSource, String toDestination) {
        roundTrip.click();
        actions.moveToElement(from).click().sendKeys(fromSource).pause(Duration.ofSeconds(5)).keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        actions.moveToElement(to).click().sendKeys(toDestination).pause(Duration.ofSeconds(5)).keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        calendarRT1.click();
        webWait.until(ExpectedConditions.visibilityOf(departureDate)).click();
        calendarRT2.click();
        webWait.until(ExpectedConditions.visibilityOf(returnDate)).click();
        searchFlightBtn.click();
        webWait.until(ExpectedConditions.elementToBeClickable(flightSearchResults));
        return flightSearchResults.isDisplayed();
    }

    public boolean SearchMultiCityFlight(String fromSource, String toDestination, String multiToDestination) {
        multiCity.click();
        actions.moveToElement(fromMC).click().sendKeys(fromSource).pause(Duration.ofSeconds(5)).keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        actions.moveToElement(destinationMC1).click().sendKeys(toDestination).pause(Duration.ofSeconds(5)).keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        calendarMC1.click();
        webWait.until(ExpectedConditions.visibilityOf(departureDate1)).click();
        flight2.click();
        actions.moveToElement(destinationMC2).click().sendKeys(multiToDestination).pause(Duration.ofSeconds(1)).keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        calendarMC2.click();
        webWait.until(ExpectedConditions.visibilityOf(departureDate2)).click();
        searchFlightBtn.click();
        webWait.until(ExpectedConditions.elementToBeClickable(flightSearchResults));
        return flightSearchResults.isDisplayed();
    }
}
