package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchFlightPage extends Base {
    @FindBy(xpath = "//div[@class='oneway']/div[5]/div/div/div[2]/button")
    WebElement bookFlight;
    @FindBy(id = "adult1FirstName")
    WebElement travellersDetails;

    public SearchFlightPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean BookFlight() {
        webWait.until(ExpectedConditions.elementToBeClickable(bookFlight));
        bookFlight.click();
        return travellersDetails.isDisplayed();
    }
}
