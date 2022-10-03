package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationPageTest extends Base {
    @BeforeMethod
    public void browserSetup() {
        initialization();
        driver.findElement(By.id("wzrk-cancel")).click();
    }

    @Test
    public void validateRegistration() {
        WebElement login = driver.findElement(By.xpath("//div[@id='SignIn']"));
        actions.moveToElement(login).click().build().perform();
        driver.findElement(By
                .xpath("//div[@id='SignInContent']/div[1]/div[1]/div[2]/span/label/span")).click();
        driver.findElement(By.id("emailIdSignUp")).sendKeys("prueba");
        driver.findElement(By.id("passwordSignUp")).sendKeys("prueba");
        driver.findElement(By.id("nameSignUp")).sendKeys("prueba");
        WebElement multiDropDown = driver.findElement(By.id("mobileIsdSignUp"));
        Select obj1 = new Select(multiDropDown);
        obj1.selectByValue("1");
        driver.findElement(By.id("mobileNoSignUp")).sendKeys("prueba");
        driver.findElement(By.id("signUpValidate")).click();
    }

    @AfterMethod
    public void closeSetUp(){
        closeInitialization();
    }
}
