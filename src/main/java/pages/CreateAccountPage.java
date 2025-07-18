package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

import java.time.Duration;

public class CreateAccountPage {
    private final By createAccountTextString = By.xpath("//span[text() = 'Create New Customer Account']");
    private final By firstName = By.xpath("//input[@id='firstname']");
    private final By lastName = By.xpath("//input[@id='lastname']");
    private final By email = By.xpath("//input[@id='email_address']");
    private final By password = By.xpath("//input[@id='password']");
    private final By confirmPassword = By.xpath("//input[@id='password-confirmation']");
    private final By createAccountButton = By.xpath("//div//button[@class='action submit primary']");
    private final By successAccountCreationMessage = By.xpath("//div[@class='page messages']");
    private final By contactInformation = By.xpath("//div[@class='box box-information']//div[@class='box-content']");
    WebDriver driver;
    CommonUtils commonUtils;
    AdPage adPage;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        commonUtils = new CommonUtils(driver);
        adPage = new AdPage(driver);
    }

    public void waitTillCreateAccountPageLoaded() {
        adPage.checkAndCloseAd();
        commonUtils.waitTillElementVisibleFluentWait(createAccountTextString);
    }

    public void enterFirstName(String name) {
        commonUtils.scrollToElement(firstName);
        commonUtils.enterValueInTextBox(firstName, name);
    }

    public void enterLastName(String name) {
        commonUtils.scrollToElement(lastName);
        commonUtils.enterValueInTextBox(lastName, name);
    }

    public void enterEmail(String emailId) {
        commonUtils.scrollToElement(email);
        commonUtils.enterValueInTextBox(email, emailId);
    }

    public void enterPassword(String pass) {
        commonUtils.scrollToElement(password);
        commonUtils.enterValueInTextBox(password, pass);
    }

    public void enterPasswordInConfirmPasswordBox(String pass) {
        commonUtils.scrollToElement(confirmPassword);
        commonUtils.enterValueInTextBox(confirmPassword, pass);
    }

    public void clickOnCreateAccountButton() {
        commonUtils.clickOnGivenElement(createAccountButton);
    }

    public boolean checkAccountCreationMessage() {
        return commonUtils.isElementPresentAndVisible(successAccountCreationMessage, Duration.ofSeconds(2));
    }

    public String getAccountInformation() {
        return driver.findElement(successAccountCreationMessage).getText();
    }

    public String getContactInformationDisplayedOnPage() {
        return driver.findElement(contactInformation).getText();
    }

}
