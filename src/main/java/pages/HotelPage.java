package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HotelPage extends Base {
    public boolean SearchHotel() {
        driver.navigate().to(properties.getProperty("urlHotels"));
        WebElement destination = driver.findElement(By.id("destination"));
        actions.moveToElement(destination).click().sendKeys(properties.getProperty("destination")).pause(Duration.ofSeconds(5)).click().keyDown(Keys.DOWN).keyDown(Keys.ENTER).build().perform();
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[3]/div/div[2]/div/div")).click();
        WebElement checkIn = driver.findElement(By.xpath("//div[@id='depart-cal']/div[3]//div[text()='24']"));
        wait.until(ExpectedConditions.visibilityOf(checkIn)).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[3]/div/div[3]/div/div")).click();
        WebElement checkOut = driver.findElement(By.xpath("//div[@id='return-cal']/div[4]//div[text()='20']"));
        wait.until(ExpectedConditions.visibilityOf(checkOut)).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[3]/div/div[4]/div/span[3]")).click();
        driver.findElement(By.xpath("//div[@class='counter-element adult js-count via-processed']/div/div[@class='minus']")).click();
        driver.findElement(By.xpath("//div[@class='roomConfigFooter']//div[@class='done']")).click();
        WebElement nationalityDropDown = driver.findElement(By.id("nationalityCountry"));
        Select nationality = new Select(nationalityDropDown);
        nationality.selectByValue(properties.getProperty("nationalityCode"));
        WebElement residenceDropDown = driver.findElement(By.id("residenceCountry"));
        Select residence = new Select(residenceDropDown);
        residence.selectByValue(properties.getProperty("residence"));
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/form/div[3]/div/div[10]/div[3]")).click();
        WebElement selectRoom = new WebDriverWait(driver, Duration.ofSeconds(80))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='0']/div[3]/div[3]/div[1]")));
        return selectRoom.isDisplayed();
    }
}
