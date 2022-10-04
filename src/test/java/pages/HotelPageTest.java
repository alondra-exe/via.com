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

public class HotelPageTest extends Base {
    @BeforeMethod
    public void browserSetup() {
        initialization();
    }


    @Test
    public void validateSearchHotel() {
        driver.navigate().to(properties.getProperty("urlHotels"));
        WebElement destination = driver.findElement(By.id("destination"));
        actions.moveToElement(destination).click().sendKeys("London,United Kingdom").pause(Duration.ofSeconds(5)).click().keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[3]/div/div[2]/div/div")).click();
        WebElement checkIn = driver.findElement(By.xpath("//div[@id='depart-cal']/div[3]//div[text()='24']"));
        wait.until(ExpectedConditions.visibilityOf(checkIn)).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[3]/div/div[3]/div/div")).click();
        WebElement checkOut = driver.findElement(By.xpath("//div[@id='return-cal']/div[4]//div[text()='20']"));
        wait.until(ExpectedConditions.visibilityOf(checkOut)).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[3]/div/div[4]/div/span[3]")).click();
        driver.findElement(By.xpath("//div[@class='counter-element adult js-count via-processed']/div/div[@class='minus']")).click();
        driver.findElement(By.xpath("//div[@class='roomConfigFooter']//div[@class='done']")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[3]/div/div[10]/div[3]")).click();
    }

    @AfterMethod
    public void closeSetUp() {
        closeInitialization();
    }
}
