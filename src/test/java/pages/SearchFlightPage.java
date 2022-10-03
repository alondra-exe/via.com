package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SearchFlightPage extends Base {
    @BeforeMethod
    public void browserSetup() {
        initialization();
    }

    @Test
    public void validateSearchFlightPage(){
        driver.navigate().to("https://in.via.com/flight/search?returnType=one-way&destination=NRT&bdestination=NRT&destinationL=Narita,Tokyo&destinationCity=Tokyo&destinationCN=Japan&source=YYZ&bsource=YYZ&sourceL=Lester%20B%20Pearson%20Intl,Toronto&sourceCity=Toronto&sourceCN=Canada&month=11&day=29&year=2022&date=11/29/2022&numAdults=1&numChildren=0&numInfants=0&validation_result=&domesinter=international&livequote=-1&flightClass=ALL&travType=INTL&routingType=ALL&preferredCarrier=&prefCarrier=0&isAjax=false");
        boolean flightResume = driver.findElement(By.partialLinkText("Flight Results")).isDisplayed();
        Assert.assertTrue(flightResume);
    }

    @Test
    public void validateModifyFlightSearch() throws InterruptedException {
        driver.navigate().to("https://in.via.com/flight/search?returnType=one-way&destination=NRT&bdestination=NRT&destinationL=Narita,Tokyo&destinationCity=Tokyo&destinationCN=Japan&source=YYZ&bsource=YYZ&sourceL=Lester%20B%20Pearson%20Intl,Toronto&sourceCity=Toronto&sourceCN=Canada&month=11&day=29&year=2022&date=11/29/2022&numAdults=1&numChildren=0&numInfants=0&validation_result=&domesinter=international&livequote=-1&flightClass=ALL&travType=INTL&routingType=ALL&preferredCarrier=&prefCarrier=0&isAjax=false");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//html/body/div[6]/div/div[2]/div[2]")).click();
        js.executeScript("document.getElementById('departure').setAttribute('data-date', '11/04/2022')");
        driver.findElement(By.id("search-flight-btn")).click();

        Thread.sleep(5000);

    }

    @Test
    public void validateBookFlight(){
        driver.navigate().to("https://in.via.com/flight/search?returnType=one-way&destination=NRT&bdestination=NRT&destinationL=Narita,Tokyo&destinationCity=Tokyo&destinationCN=Japan&source=YYZ&bsource=YYZ&sourceL=Lester%20B%20Pearson%20Intl,Toronto&sourceCity=Toronto&sourceCN=Canada&month=11&day=29&year=2022&date=11/29/2022&numAdults=1&numChildren=0&numInfants=0&validation_result=&domesinter=international&livequote=-1&flightClass=ALL&travType=INTL&routingType=ALL&preferredCarrier=&prefCarrier=0&isAjax=false");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//div[@id='searchResultContainer']/div[7]/div/div[3]/div[1]/div[3]/div[2]/button")).click();
    }

    @AfterMethod
    public void closeSetUp(){
        closeInitialization();
    }
}
