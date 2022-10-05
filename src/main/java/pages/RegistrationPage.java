package pages;

import base.Base;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends Base {
    public String Registration() {
        WebElement login = driver.findElement(By.xpath("//div[@id='SignIn']"));
        actions.moveToElement(login).click().build().perform();
        driver.findElement(By
                .xpath("//div[@id='SignInContent']/div[1]/div[1]/div[2]/span/label/span")).click();
        driver.findElement(By.id("emailIdSignUp")).sendKeys(properties.getProperty("email"));
        driver.findElement(By.id("passwordSignUp")).sendKeys(properties.getProperty("password"));
        driver.findElement(By.id("nameSignUp")).sendKeys(properties.getProperty("name"));
        WebElement mobileCodeDropDown = driver.findElement(By.id("mobileIsdSignUp"));
        Select mobileCode = new Select(mobileCodeDropDown);
        mobileCode.selectByValue(properties.getProperty("numbercode"));
        driver.findElement(By.id("mobileNoSignUp")).sendKeys(properties.getProperty("phonenumber"));
        driver.findElement(By.id("signUpValidate")).click();
        WebElement signup = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id("userNameSecondaryNav")));
        signup.click();
        return driver.findElement(By.xpath("//div[@id='userNameSecondaryNavContent']/div/div[1]/p")).getText();
    }
}
