package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CommonUtils;

public class HomePage {
    private final By createAccountButton = By.xpath("//div[@class = 'panel header' ]//a[text()='Create an Account']");
    WebDriver driver;
    CommonUtils commonUtils;
    AdPage adPage;

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

    public void clickOnCreateAccountButton() {
        adPage.checkAndCloseAd();
        commonUtils.clickOnGivenElement(createAccountButton);
    }
}
