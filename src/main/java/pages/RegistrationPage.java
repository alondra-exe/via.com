package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends Base {
    public String Registration(String email, String password, String name, String numberCode, String phoneNumber) {
        WebElement login = driver.findElement(By.xpath("//div[@id='SignIn']"));
        actions.moveToElement(login).click().build().perform();
        driver.findElement(By
                .xpath("//div[@id='SignInContent']/div[1]/div[1]/div[2]/span/label/span")).click();
        driver.findElement(By.id("emailIdSignUp")).sendKeys(email);
        driver.findElement(By.id("passwordSignUp")).sendKeys(password);
        driver.findElement(By.id("nameSignUp")).sendKeys(name);
        WebElement mobileCodeDropDown = driver.findElement(By.id("mobileIsdSignUp"));
        Select mobileCode = new Select(mobileCodeDropDown);
        mobileCode.selectByValue(numberCode);
        driver.findElement(By.id("mobileNoSignUp")).sendKeys(phoneNumber);
        driver.findElement(By.id("signUpValidate")).click();
        WebElement signup = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id("userNameSecondaryNav")));
        signup.click();
        return driver.findElement(By.xpath("//div[@id='userNameSecondaryNavContent']/div/div[1]/p")).getText();
    }
}
