package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchFlightPage extends Base {
    public String ModifyFlightSearch() {
        driver.findElement(By.xpath("//html/body/div[7]/div/div[2]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='round-trip-panel']/div[4]/div/div")).click();
        WebElement departureDate = driver.findElement(By.xpath("//div[@id='depart-cal']/div[3]//div[text()='4']"));
        wait.until(ExpectedConditions.visibilityOf(departureDate)).click();
        driver.findElement(By.xpath("//div[@class='counter-element adult']/div/div[@class='plus']")).click();
        driver.findElement(By.id("search-flight-btn")).click();
        return driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div[1]/span[2]")).getText();
    }

    public boolean BookFlight() {
        WebElement bookFlight = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oneway']/div[5]/div/div/div[2]/button")));
        bookFlight.click();
        return driver.findElement(By.id("adult1FirstName")).isDisplayed();
    }
}
