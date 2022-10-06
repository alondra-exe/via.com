package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Base {
    @FindBy(xpath = "//div[@id='SignIn']")
    WebElement signIn;
    @FindBy(xpath = "//div[@id='SignInContent']/div[1]/div[1]/div[2]/span/label/span")
    WebElement SignInContent;
    @FindBy(id = "emailIdSignUp")
    WebElement emailSignUp;
    @FindBy(id = "passwordSignUp")
    WebElement passwordSignUp;
    @FindBy(id = "nameSignUp")
    WebElement nameSignUp;
    @FindBy(id = "mobileIsdSignUp")
    WebElement mobileIsdSignUp;
    @FindBy(id = "mobileNoSignUp")
    WebElement mobileNoSignUp;
    @FindBy(id = "signUpValidate")
    WebElement signUpValidate;
    @FindBy(id = "userNameSecondaryNav")
    WebElement userNameSecondaryNav;
    @FindBy(xpath = "//div[@id='userNameSecondaryNavContent']/div/div[1]/p")
    WebElement signInMessage;

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    public String Registration(String email, String password, String name, String numberCode, String phoneNumber) {
        actions.moveToElement(signIn).click().build().perform();
        SignInContent.click();
        emailSignUp.sendKeys(email);
        passwordSignUp.sendKeys(password);
        nameSignUp.sendKeys(name);
        WebElement mobileCodeDropDown = mobileIsdSignUp;
        Select mobileCode = new Select(mobileCodeDropDown);
        mobileCode.selectByValue(numberCode);
        mobileNoSignUp.sendKeys(phoneNumber);
        signUpValidate.click();
        webWait.until(ExpectedConditions.elementToBeClickable(userNameSecondaryNav));
        userNameSecondaryNav.click();
        return signInMessage.getText();
    }
}
