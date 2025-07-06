package stepDefinitions;

import Constants.UrlConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.AdPage;
import pages.CreateAccountPage;
import pages.HomePage;
import utils.CommonUtils;
import utils.TestDataGenerator;

public class SignUpSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignUpSteps.class);
    TestDataGenerator testDataGenerator = new TestDataGenerator();

    WebDriver driver;
    HomePage homePage;
    CreateAccountPage createAccountPage;
    CommonUtils commonUtils;
    AdPage adPage;

    @Given("User opens the home page")
    public void openHomepage() {
        LOGGER.info("Navigating to: {}", UrlConstants.HOMEPAGE_URL);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(UrlConstants.HOMEPAGE_URL);
        LOGGER.info("Page opened, waiting till Create account button is visible");
        homePage = new HomePage(driver);
        adPage = new AdPage(driver);
        Assert.assertTrue(homePage.isCreateAccountButtonVisible(), "Create Account button is not displayed");
        LOGGER.info("Create Account button found");
    }

    @Given("User clicks on create account button")
    public void clickOnCreateAccountButton() {
        homePage.clickOnCreateAccountButton();
        createAccountPage = new CreateAccountPage(driver);
        createAccountPage.waitTillCreateAccountPageLoaded();
        LOGGER.info("Create Account page is loaded");
    }

    @Then("User enters personal details")
    public void enterUserDetails() {
        String firstName = testDataGenerator.getRandomStringOfGivenLength(5);
        String lastName = testDataGenerator.getRandomStringOfGivenLength(5);
        String email = testDataGenerator.getRandomValidEmail();
        String password = testDataGenerator.getRandomPassword();

        createAccountPage.enterFirstName(firstName);
        createAccountPage.enterLastName(lastName);
        createAccountPage.enterEmail(email);
        createAccountPage.enterPassword(password);
        createAccountPage.enterPasswordInConfirmPasswordBox(password);
        createAccountPage.clickOnCreateAccountButton();
    }

    @Then("Close browser")
    public void closeWebDriver() {
//        driver.close();
    }


}
