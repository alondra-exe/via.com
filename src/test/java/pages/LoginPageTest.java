package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class LoginPageTest extends Base {
    @BeforeMethod
    public void browserSetup() {
        initialization();
    }

    @Test
    public void validateLogin(){
        WebElement login = driver.findElement(By.xpath("//div[@id='SignIn']"));
        actions.moveToElement(login).click().build().perform();
        driver.findElement(By.id("loginIdText")).sendKeys("prueba");
        driver.findElement(By.id("passwordText")).sendKeys("prueba");
        driver.findElement(By.id("loginValidate")).click();
    }

    @Test
    public void validateLoginWithFacebook(){
        WebElement login = driver.findElement(By.xpath("//div[@id='SignIn']"));
        actions.moveToElement(login).click().build().perform();
        driver.findElement(By.id("loginFacebook")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.id("email")).sendKeys("prueba");
        driver.findElement(By.id("pass")).sendKeys("prueba");
        driver.findElement(By.id("loginbutton")).click();
    }

    @Test
    public void validateLoginWithGoogle() {
        WebElement login = driver.findElement(By.xpath("//div[@id='SignIn']"));
        actions.moveToElement(login).click().build().perform();
        driver.findElement(By.id("loginGoogle")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.id("identifierId")).sendKeys("prueba@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        driver.findElement(By.name("password")).sendKeys("prueba");
        driver.findElement(By.id("passwordNext")).click();
    }

    @AfterMethod
    public void closeSetUp(){
        closeInitialization();
    }

}
