package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

public class LoginPage {
    private final By loginButton = By.xpath("//div[@class='panel header']//li[@class='authorization-link']");
    private final By emailTextBox = By.xpath("//input[@id='email']");
    private final By passwordTextBox = By.xpath("//input[@id='pass' and @title='Password']");
    private final By signInButton = By.xpath("//div[@class='login-container']//button[@id='send2']");
    private final By signInSuccessButton = By.xpath("//header[@class='page-header']//span[@class='logged-in']");
    WebDriver driver;
    CommonUtils commonUtils;
    AdPage adPage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        commonUtils = new CommonUtils(driver);
        adPage = new AdPage(driver);
    }

    public void userClicksOnLoginButton() {
        commonUtils.clickOnGivenElement(loginButton);
    }

    public void enterEmail(String email) {
        commonUtils.scrollToElement(emailTextBox);
        commonUtils.enterValueInTextBox(emailTextBox, email);
    }

    public void enterPassword(String password) {
        commonUtils.scrollToElement(passwordTextBox);
        commonUtils.enterValueInTextBox(passwordTextBox, password);
    }

    public void clickOnSignInButton() {
        commonUtils.clickOnGivenElement(signInButton);
    }

    public boolean isSignInSuccessful() {
        try {
            commonUtils.waitTillElementVisibleFluentWait(signInSuccessButton);
            return commonUtils.checkIfElementIsVisible(signInSuccessButton);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
