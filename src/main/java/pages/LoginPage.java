package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class LoginPage extends Base {

    public String Login(String email, String password) {
        WebElement login = driver.findElement(By.xpath("//div[@id='SignIn']"));
        actions.moveToElement(login).click().build().perform();
        driver.findElement(By.id("loginIdText")).sendKeys(email);
        driver.findElement(By.id("passwordText")).sendKeys(password);
        driver.findElement(By.id("loginValidate")).click();
        driver.findElement(By.id("userNameSecondaryNav")).click();
        return driver.findElement(By.xpath("//div[@id='userNameSecondaryNavContent']/div/div[1]/p")).getText();
    }

    public String LoginWithFacebook(String email, String password) {
        WebElement login = driver.findElement(By.xpath("//div[@id='SignIn']"));
        actions.moveToElement(login).click().build().perform();
        driver.findElement(By.id("loginFacebook")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("loginbutton")).click();
        driver.findElement(By.id("userNameSecondaryNav")).click();
        return driver.findElement(By.xpath("//div[@id='userNameSecondaryNavContent']/div/div[1]/p")).getText();
    }

    public String LoginWithGoogle(String gmail, String gmailPassword) {
        WebElement login = driver.findElement(By.xpath("//div[@id='SignIn']"));
        actions.moveToElement(login).click().build().perform();
        driver.findElement(By.id("loginGoogle")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.id("identifierId")).sendKeys(gmail);
        driver.findElement(By.id("identifierNext")).click();
        driver.findElement(By.xpath("//div[@id='password']/div[1]/div/div[1]/input")).sendKeys(gmailPassword);
        driver.findElement(By.id("passwordNext")).click();
        driver.findElement(By.id("userNameSecondaryNav")).click();
        return driver.findElement(By.xpath("//div[@id='userNameSecondaryNavContent']/div/div[1]/p")).getText();
    }
}
