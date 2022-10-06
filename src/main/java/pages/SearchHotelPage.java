package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class SearchHotelPage extends Base {
    @FindBy(xpath = "/html/body/div[8]")
    WebElement loaded;
    @FindBy(xpath = "//div[@id='0']/div[3]/div[3]/div[1]")
    WebElement selectRoom;
    @FindBy(xpath = "//div[@id='roomHotel0']/div[1]/div/div[3]/div[2]")
    WebElement bookRoom;
    @FindBy(xpath = "//div[@id='room1Adult1']/div/div[1]/div[2]/input")
    WebElement guestsDetails;

    public SearchHotelPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean BookRooms() {
        webWait.until(ExpectedConditions.elementToBeClickable(loaded));
        webWait.until(ExpectedConditions.elementToBeClickable(selectRoom));
        actions.moveToElement(selectRoom).pause(Duration.ofSeconds(10)).click().build().perform();
        webWait.until(ExpectedConditions.elementToBeClickable(bookRoom));
        bookRoom.click();
        return guestsDetails.isDisplayed();
    }
}
