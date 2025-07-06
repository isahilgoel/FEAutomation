package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

public class HomePage {
    WebDriver driver;
    CommonUtils commonUtils;
    AdPage adPage;
    private By createAccountButton = By.xpath("//div[@class = 'panel header' ]//a[text()='Create an Account']");
    private By adDismissButton = By.xpath("//div[@id='dismiss-button']");
    private By adCard = By.xpath("//div[@id='dismiss-button']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        commonUtils = new CommonUtils(driver);
        adPage = new AdPage(driver);
    }

    public boolean isCreateAccountButtonVisible() {
        try {
            adPage.checkAndCloseAd();
            commonUtils.waitTillElementVisibleFluentWait(createAccountButton);
            return commonUtils.checkIfElementIsVisible(createAccountButton);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clickOnCreateAccountButton(){
        adPage.checkAndCloseAd();
        commonUtils.clickOnGivenElement(createAccountButton);
    }
}
