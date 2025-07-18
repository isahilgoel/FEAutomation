package stepDefinitions;

import base.TestBase;
import constants.FieldConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.TestDataGenerator;

public class SignUpSteps extends TestBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignUpSteps.class);
    TestDataGenerator testDataGenerator = new TestDataGenerator();
    String firstName;
    String lastName;
    String email;
    String password;

    @Given("User opens the home page")
    public void openHomepage() {
        setUpDriverAndNavigateToHomepage();
        Assert.assertTrue(homePage.isCreateAccountButtonVisible(), "Create Account button is not displayed");
        LOGGER.info("Create Account button found");
    }

    @Then("User clicks on create account button")
    public void clickOnCreateAccountButton() {
        homePage.clickOnCreateAccountButton();
        createAccountPage.waitTillCreateAccountPageLoaded();
        LOGGER.info("Create Account page is loaded");
    }

    @When("User enters personal details")
    public void enterUserDetails() {
        email = testDataGenerator.getRandomValidEmail();
        password = testDataGenerator.getRandomPassword();
        firstName = testDataGenerator.getRandomStringOfGivenLength(5);
        lastName = testDataGenerator.getRandomStringOfGivenLength(5);
        createAccountPage.enterFirstName(firstName);
        createAccountPage.enterLastName(lastName);
        createAccountPage.enterEmail(email);
        createAccountPage.enterPassword(password);
        createAccountPage.enterPasswordInConfirmPasswordBox(password);
        createAccountPage.clickOnCreateAccountButton();
    }

    @Then("User verifies account information")
    public void userVerifyAccountDetails() {
        Assert.assertTrue(createAccountPage.checkAccountCreationMessage());
        Assert.assertTrue(createAccountPage.getContactInformationDisplayedOnPage().contains(firstName), "First name is not displayed");
        Assert.assertTrue(createAccountPage.getContactInformationDisplayedOnPage().contains(lastName), "Last name is not displayed");
        Assert.assertTrue(createAccountPage.getContactInformationDisplayedOnPage().contains(email), "Email is not displayed");
    }

    @Then("User clicks on the login button")
    public void userClicksOnLoginButton() {
        loginPage.userClicksOnLoginButton();
    }

    @Then("User enters login credentials")
    public void userEntersEmailAndPassword() {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @Then("User enters invalid login credentials")
    public void userEntersInvalidCredsOnLoginPage() {
        email = testDataGenerator.getRandomValidEmail();
        password = testDataGenerator.getRandomPassword();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        LOGGER.info("Entered invalid credentials: Email - {}, Password - {}", email, password);
    }


    @Then("User clicks on sign in button")
    public void userClicksOnSignInButton() {
        loginPage.clickOnSignInButton();
    }

    @Then("User verifies error message for invalid credentials")
    public void verifyErrorForLoginWithInvalidDetails() {
        Assert.assertEquals(loginPage.getSignInErrorMessage(), FieldConstants.SIGN_IN_ERROR_MESSAGE, "Error message does not match expected value");
    }

    @Then("User verifies successful login")
    public void userVerifiesLoginIsSuccessful() {
        Assert.assertTrue(loginPage.isSignInSuccessful(), "Login was not successful");
        LOGGER.info("Login successful for user: {}", email);
    }

    @Then("Close browser")
    public void closeWebDriver() {
        driver.close();
    }
}
