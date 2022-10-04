package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchHotelPageTest extends Base {
    @BeforeMethod
    public void browserSetup() {
        initialization();
        hotelPageTest.validateSearchHotel();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void validateBookRooms(){
        WebElement progress = driver.findElement(By.xpath("/html/body/div[7]/div/div[1]"));
        if(!progress.getText().equals("100%")){
            WebElement selectRoom = new WebDriverWait(driver, Duration.ofMinutes(2))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='0']/div[3]/div[3]/div[1]")));
            selectRoom.click();
        }
        else{
            WebElement selectRoom = new WebDriverWait(driver, Duration.ofSeconds(80))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='0']/div[3]/div[3]/div[1]")));
            selectRoom.click();
        }

        WebElement bookRoom = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='roomHotel0']/div[1]/div/div[3]/div[2]")));
        bookRoom.click();

    }

    @AfterMethod
    public void closeSetUp() {
        closeInitialization();
    }
}
