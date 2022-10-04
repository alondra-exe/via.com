package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchFlightPageTest extends Base {

    @BeforeMethod
    public void browserSetup() {
        initialization();
        flightPageTest.validateSearchOneWayFlight();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void validateSearchFlightPage() {
        boolean flightResume = driver.findElement(By.xpath("//html/body/div[7]/div/div[2]/div[2]/div")).isDisplayed();
        boolean searchRefineResults = driver.findElement(By.xpath("//html/body/div[7]/div/div[2]/div[3]/div")).isDisplayed();
        boolean flightResults = driver.findElement(By.id("flightSearchResults")).isDisplayed();
        Assert.assertTrue(flightResume);
        Assert.assertTrue(searchRefineResults);
        Assert.assertTrue(flightResults);
    }

    @Test
    public void validateModifyFlightSearch() {
        driver.findElement(By.xpath("//html/body/div[7]/div/div[2]/div[2]/div")).click();
        driver.findElement(By.xpath("//div[@id='round-trip-panel']/div[4]/div/div")).click();
        WebElement departureDate = driver.findElement(By.xpath("//div[@id='depart-cal']/div[3]//div[text()='4']"));
        wait.until(ExpectedConditions.visibilityOf(departureDate)).click();
        driver.findElement(By.xpath("//div[@class='counter-element adult']/div/div[@class='plus']")).click();
        driver.findElement(By.id("search-flight-btn")).click();
    }

    @Test
    public void validateBookFlight() {
        driver.findElement(By.xpath("//div[@class='oneway']/div[5]/div/div/div[2]/button")).click();
    }

    @AfterMethod
    public void closeSetUp() {
        closeInitialization();
    }
}
