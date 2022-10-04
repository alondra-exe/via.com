package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FlightPageTest extends Base {

    @BeforeMethod
    public void browserSetup() {
        initialization();
    }

    @Test
    public void validateSearchOneWayFlight() {
        WebElement from = driver.findElement(By.id("source"));
        WebElement to = driver.findElement(By.id("destination"));
        actions.moveToElement(from).click().sendKeys("YYZ").pause(Duration.ofSeconds(1)).keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        actions.moveToElement(to).click().sendKeys("NRT").pause(Duration.ofSeconds(1)).keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        driver.findElement(By.xpath("//div[@id='round-trip-panel']/div[4]/div[2]/div")).click();
        WebElement departureDate = driver.findElement(By.xpath("//div[@id='depart-cal']/div[4]//div[text()='29']"));
        wait.until(ExpectedConditions.visibilityOf(departureDate)).click();
        driver.findElement(By.id("search-flight-btn")).click();
    }

    @Test
    public void validateSearchRoundTripFlight() {
        driver.findElement(By.className("round-trip")).click();
        WebElement from = driver.findElement(By.id("source"));
        WebElement to = driver.findElement(By.id("destination"));
        actions.moveToElement(from).click().sendKeys("YYZ").pause(Duration.ofSeconds(1)).keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        actions.moveToElement(to).click().sendKeys("NRT").pause(Duration.ofSeconds(1)).keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        driver.findElement(By.xpath("//div[@id='round-trip-panel']/div[4]/div[2]/div")).click();
        WebElement departureDate = driver.findElement(By.xpath("//div[@id='depart-cal']/div[4]//div[text()='29']"));
        wait.until(ExpectedConditions.visibilityOf(departureDate)).click();
        driver.findElement(By.xpath("//div[@class='element return-element']/div/div[@class='calendar-icon']")).click();
        WebElement returnDate = driver.findElement(By.xpath("//div[@id='return-cal']/div[4]//div[text()='24']"));
        wait.until(ExpectedConditions.visibilityOf(returnDate)).click();
        driver.findElement(By.id("search-flight-btn")).click();
    }

    @Test
    public void validateMultiCityFlight() {
        driver.findElement(By.className("multi-city")).click();
        WebElement from1 = driver.findElement(By.id("source-0"));
        WebElement to1 = driver.findElement(By.id("destination-0"));
        actions.moveToElement(from1).click().sendKeys("YYZ").pause(Duration.ofSeconds(1)).keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        actions.moveToElement(to1).click().sendKeys("NRT").pause(Duration.ofSeconds(1)).keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        driver.findElement(By.xpath("//div[@id='multi-city-panel']/div[2]/div[3]/div/div")).click();
        WebElement departureDate1 = driver.findElement(By.xpath("//div[@id='depart-cal-0']/div[4]//div[text()='29']"));
        wait.until(ExpectedConditions.visibilityOf(departureDate1)).click();
        driver.findElement(By.id("multi-city-label-1")).click();
        WebElement to2 = driver.findElement(By.id("destination-1"));
        actions.moveToElement(to2).click().sendKeys("ICN").pause(Duration.ofSeconds(1)).keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        driver.findElement(By.xpath("//div[@id='multi-city-panel']/div[3]/div[3]/div/div")).click();
        WebElement departureDate2 = driver.findElement(By.xpath("//div[@id='depart-cal-1']/div[4]//div[text()='24']"));
        wait.until(ExpectedConditions.visibilityOf(departureDate2)).click();
        driver.findElement(By.id("search-flight-btn")).click();
    }

    @AfterMethod
    public void closeSetUp(){
        closeInitialization();
    }
}
