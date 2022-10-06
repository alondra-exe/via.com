package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class LoginPage extends Base {
    @FindBy(xpath = "//div[@id='SignIn']")
    WebElement loginSection;
    @FindBy(id = "loginIdText")
    WebElement emailElement;
    @FindBy(id = "passwordText")
    WebElement passwordElement;
    @FindBy(id = "loginValidate")
    WebElement loginButton;
    @FindBy(id = "userNameSecondaryNav")
    WebElement userButton;
    @FindBy(xpath = "//div[@id='userNameSecondaryNavContent']/div/div[1]/p")
    WebElement welcomeMessage;
    @FindBy(id = "loginFacebook")
    WebElement loginFacebook;
    @FindBy(id = "email")
    WebElement emailFacebook;
    @FindBy(id = "pass")
    WebElement passFacebook;
    @FindBy(id = "loginbutton")
    WebElement loginFacebookButton;
    @FindBy(id = "loginGoogle")
    WebElement loginGoogle;
    @FindBy(id = "identifierId")
    WebElement gmailElement;
    @FindBy(id = "identifierNext")
    WebElement gmailButton;
    @FindBy(xpath = "//div[@id='password']/div[1]/div/div[1]/input")
    WebElement gmailPass;
    @FindBy(id = "passwordNext")
    WebElement passwordButton;


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String Login(String email, String password) {
        actions.moveToElement(loginSection).click().build().perform();
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        loginButton.click();
        userButton.click();
        return welcomeMessage.getText();
    }

    public String LoginWithFacebook(String email, String password) {
        actions.moveToElement(loginSection).click().build().perform();
        loginFacebook.click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        emailFacebook.sendKeys(email);
        passFacebook.sendKeys(password);
        loginFacebookButton.click();
        userButton.click();
        return welcomeMessage.getText();
    }

    public String LoginWithGoogle(String gmail, String gmailPassword) {
        actions.moveToElement(loginSection).click().build().perform();
        loginGoogle.click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        gmailElement.sendKeys(gmail);
        gmailButton.click();
        gmailPass.sendKeys(gmailPassword);
        passwordButton.click();
        userButton.click();
        return welcomeMessage.getText();
    }
}
