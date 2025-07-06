package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

public class CreateAccountPage {
    WebDriver driver;
    CommonUtils commonUtils;
    AdPage adPage;
    private By createAccountTextString = By.xpath("//span[text() = 'Create New Customer Account']");
    private By firstName = By.xpath("//input[@id='firstname']");
    private By lastName = By.xpath("//input[@id='lastname']");
    private By email = By.xpath("//input[@id='email_address']");
    private By password = By.xpath("//input[@id='password']");
    private By confirmPassword = By.xpath("//input[@id='password-confirmation']");
    private By createAccountButton = By.xpath("//div//button[@class='action submit primary']");

    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
        commonUtils = new CommonUtils(driver);
        adPage = new AdPage(driver);
    }

    public void waitTillCreateAccountPageLoaded(){
        adPage.checkAndCloseAd();
        commonUtils.waitTillElementVisibleFluentWait(createAccountTextString);
    }

    public void enterFirstName(String name){
        commonUtils.scrollToElement(firstName);
        commonUtils.enterValueInTextBox(firstName, name);
    }

    public void enterLastName(String name){
        commonUtils.scrollToElement(lastName);
        commonUtils.enterValueInTextBox(lastName, name);
    }

    public void enterEmail(String emailId){
        commonUtils.scrollToElement(email);
        commonUtils.enterValueInTextBox(email, emailId);
    }

    public void enterPassword(String pass){
        commonUtils.scrollToElement(password);
        commonUtils.enterValueInTextBox(password, pass);
    }

    public void enterPasswordInConfirmPasswordBox(String pass){
        commonUtils.scrollToElement(confirmPassword);
        commonUtils.enterValueInTextBox(confirmPassword, pass);
    }

    public void clickOnCreateAccountButton(){
        commonUtils.clickOnGivenElement(createAccountButton);
    }

}
