package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CommonUtils {
    WebDriverWait webDriverWait;
    WebDriver driver;
    PropertyUtils propertyUtils = new PropertyUtils();
    Actions actions;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(propertyUtils.getWaitTimeout()));
    }

    public void waitTillElementVisible(By element) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitTillElementVisibleFluentWait(By element) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(propertyUtils.getMaxTimeout()))
                .pollingEvery(Duration.ofSeconds(propertyUtils.getPollingTime()))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public boolean checkIfElementIsVisible(By element) {
        List<WebElement> elementList = driver.findElements(element);
        return elementList.size() > 0 && elementList.get(0).isDisplayed();
    }

    public void clickOnGivenElement(By element) {
        driver.findElement(element).click();
    }

    public boolean isElementPresentAndVisible(By locator, Duration timeout) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, timeout);
            return shortWait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void scrollToElement(By locator) {
        actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(locator));
    }

    public void enterValueInTextBox(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }
}
