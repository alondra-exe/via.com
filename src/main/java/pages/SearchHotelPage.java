package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchHotelPage extends Base {
    public boolean BookRooms() {
        WebElement selectRoom = new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='0']/div[3]/div[3]/div[1]")));
        selectRoom.click();
        WebElement bookRoom = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='roomHotel0']/div[1]/div/div[3]/div[2]")));
        bookRoom.click();
        return driver.findElement(By.xpath("//div[@id='room1Adult1']/div/div[1]/div[2]/input")).isDisplayed();
    }
}
