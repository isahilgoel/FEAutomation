package base;

import constants.UrlConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AdPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    protected WebDriver driver;
    protected HomePage homePage;
    protected AdPage adPage;
    protected LoginPage loginPage;
    protected CreateAccountPage createAccountPage;

    public void setUpDriverAndNavigateToHomepage() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--load-extension=" + new File("src/main/resources/uBlock0.chromium").getAbsolutePath());
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.ads", 2);
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-notifications");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        LOGGER.info("ChromeDriver initialized with options: {}", chromeOptions);
        LOGGER.info("Navigating to homepage: {}", UrlConstants.HOMEPAGE_URL);
        driver.get(UrlConstants.HOMEPAGE_URL);

        homePage = new HomePage(driver);
        adPage = new AdPage(driver);
        loginPage = new LoginPage(driver);
        createAccountPage = new CreateAccountPage(driver);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}