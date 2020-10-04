package shop.steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import shop.navigation.ApplicationURLs;
import shop.pages.HomePage;
import shop.pages.LoginPage;
import shop.pages.MyAccountPage;
import shop.utils.Log;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

public class CommonSteps {

    // Pages
    public HomePage homepage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;


    @And("^I am on the HomePage$")
    public void iAmOnTheHomepage() {
        homepage = new HomePage();
        homepage.openHomepage();
    }

    @When("^I click sign in button on the HomePage$")
    public void iClickLoginButtonOnTheHomePage() {
        loginPage = homepage.clickSignInButton();
    }

    @And("^I type email: (.+) on the LoginPage$")
    public void iTypeEmailTest_TestComOnTheLoginPage(String email) {
        loginPage.typeEmail(email);
    }

    @And("^I type password: (.+) on the LoginPage$")
    public void iTypePasswordPassOnTheLoginPage(String password) {
        loginPage.typePassword(password);
    }

    @And("^I click login button on the LoginPage$")
    public void iClickLoginButtonOnTheLoginPage() {
        loginPage.clickSignIn();
    }

    @Then("^I am logged in as: (.+)$")
    public void iAmLoggedInAsAutomatedTest(String username) {
        homepage.loggedUsername.
                shouldBe(Condition.visible).
                shouldBe(Condition.enabled).
                shouldHave(Condition.text(username));
    }

    @Then("^I am not logged in$")
    public void iAmNotLoggedIn() {
        Log.info("Error dialog about wrong email or password should be visible...");
        loginPage.invalidLoginOrPasswordLabel.shouldBe(Condition.visible);
        Log.info("Error dialog about wrong email or password should be visible. Done");
        Log.info("Error dialog is: '" + loginPage.invalidLoginOrPasswordLabel.getText() + "'");
    }

    @And("^I click logout button on the HomePage$")
    public void iClickLogoutButtonOnTheHomePage() {
        homepage.clickSignOutButton();
    }

    @And("^I am logged out$")
    public void iAmLoggedOut() {
        loginPage.signInButton.shouldBe(Condition.visible).shouldBe(Condition.enabled);
        homepage.pageHeaderLabel.shouldBe(Condition.visible).shouldHave(Condition.text("Log in to your account"));
    }

    @Then("^I check if (.+) has expected (.+) title$")
    public void iCheckIfPageHasExpectedTitle(String pageURL, String expectedTitle) {
        switch (pageURL) {
            case "Home Page":
                open(ApplicationURLs.BASE_URL);
                Assert.assertEquals(expectedTitle, title());
                break;
            case "Login Page":
                open(ApplicationURLs.LOGIN_PAGE_URL);
                Assert.assertEquals(expectedTitle, title());
                break;
            case "Art Page":
                open(ApplicationURLs.ART_PAGE_URL);
                Assert.assertEquals(expectedTitle, title());
                break;
            case "Clothes Page":
                open(ApplicationURLs.CLOTHES_PAGE_URL);
                Assert.assertEquals(expectedTitle, title());
                break;
            case "Accessories Page":
                open(ApplicationURLs.ACCESSORIES_PAGE_URL);
                Assert.assertEquals(expectedTitle, title());
                break;
        }
    }

    @And("^I click view my customer account button on the HomePage$")
    public void iClickViewMyCustomerAccountButtonOnTheHomePage() {
        myAccountPage = homepage.clickLoggedUserNameButton();
    }

    @And("^I click information button on the MyAccountPage$")
    public void iClickInformationButtonOnTheMyAccountPage() {
        myAccountPage.clickInformationButton();
    }
}