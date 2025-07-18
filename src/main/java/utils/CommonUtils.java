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

    /***
     * Waits until the element is visible on the page.
     * @param element The locator of the element to wait for.
     */
    public void waitTillElementVisible(By element) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    /***
     * Waits until the element is visible on the page using Fluent Wait.
     * This method allows for a more flexible waiting strategy.
     * @param element The locator of the element to wait for.
     */
    public void waitTillElementVisibleFluentWait(By element) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(propertyUtils.getMaxTimeout()))
                .pollingEvery(Duration.ofSeconds(propertyUtils.getPollingTime()))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    /***
     * Checks if the element is present and visible on the page.
     * @param element The locator of the element to check.
     * @return true if the element is present and visible, false otherwise.
     */
    public boolean checkIfElementIsVisible(By element) {
        List<WebElement> elementList = driver.findElements(element);
        return elementList.size() > 0 && elementList.get(0).isDisplayed();
    }

    /***
     * Clicks on the given element.
     * @param element The locator of the element to click.
     */
    public void clickOnGivenElement(By element) {
        driver.findElement(element).click();
    }

    /***
     * Refreshes the current page.
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }

    /***
     * Checks if the element is present and visible within a specified timeout.
     * @param locator The locator of the element to check.
     * @param timeout The maximum time to wait for the element to be visible.
     * @return true if the element is present and visible, false otherwise.
     */
    public boolean isElementPresentAndVisible(By locator, Duration timeout) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, timeout);
            return shortWait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;
        } catch (TimeoutException e) {
            return false;
        }
    }

    /***
     * Scrolls to the specified element on the page.
     * @param locator The locator of the element to scroll to.
     */
    public void scrollToElement(By locator) {
        actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(locator));
    }

    /***
     * Enters a value into a text box identified by the given locator.
     * @param locator The locator of the text box.
     * @param value The value to enter into the text box.
     */
    public void enterValueInTextBox(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }
}
