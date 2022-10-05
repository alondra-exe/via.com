package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchFlightPage extends Base {
    public boolean BookFlight() {
        WebElement bookFlight = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oneway']/div[5]/div/div/div[2]/button")));
        bookFlight.click();
        return driver.findElement(By.id("adult1FirstName")).isDisplayed();
    }
}
