package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.CommonUtils;

import java.time.Duration;

public class AdPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdPage.class);
    private final String AD_PAGE_IFRAME_NAME = "aswift_5";
    private final String AD_BOX_IFRAME_NAME = "ad_iframe";
    WebDriver driver;
    CommonUtils commonUtils;
    private final By adCard = By.xpath("//div[@id='ad_position_box']");
    private final By adDismissButton = By.xpath("//div[@id='dismiss-button']");

    public AdPage(WebDriver driver) {
        this.driver = driver;
        commonUtils = new CommonUtils(driver);
    }

    public void checkAndCloseAd() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(AD_PAGE_IFRAME_NAME));
            if (commonUtils.isElementPresentAndVisible(adCard, Duration.ofSeconds(5))) {
                LOGGER.info("Ad is visible, closing the ad.");
                commonUtils.clickOnGivenElement(adDismissButton);
            } else {
                LOGGER.info("No ad is visible, proceeding ahead.");
            }
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
    }
}
