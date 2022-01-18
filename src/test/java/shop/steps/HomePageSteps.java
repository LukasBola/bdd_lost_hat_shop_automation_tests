package shop.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import shop.context.TestContext;
import shop.pages.HomePage;

public class HomePageSteps {

    private final HomePage homePage;
    private final TestContext testContext;

    public HomePageSteps(TestContext context) {
        this.testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @And("^I am on the HomePage$")
    public void iAmOnTheHomepage() {
        homePage.openHomepage();
    }

    @When("^I click sign in button on the HomePage$")
    public void iClickLoginButtonOnTheHomePage() {
        homePage.clickSignInButton();
    }

    @And("^I click logout button on the HomePage$")
    public void iClickLogoutButtonOnTheHomePage() {
        homePage.clickSignOutButton();
    }

    @And("^I click view my customer account button on the HomePage$")
    public void iClickViewMyCustomerAccountButtonOnTheHomePage() {
        homePage.clickLoggedUserNameButton();
    }

}
