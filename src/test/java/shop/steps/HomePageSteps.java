package shop.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import shop.pages.HomePage;

public class HomePageSteps {

    private HomePage homepage;

    public HomePageSteps(HomePage homepage) {
        this.homepage = homepage;
    }

    @And("^I am on the HomePage$")
    public void iAmOnTheHomepage() {
        homepage.openHomepage();
    }

    @When("^I click sign in button on the HomePage$")
    public void iClickLoginButtonOnTheHomePage() {
        homepage.clickSignInButton();
    }

    @And("^I click logout button on the HomePage$")
    public void iClickLogoutButtonOnTheHomePage() {
        homepage.clickSignOutButton();
    }

    @And("^I click view my customer account button on the HomePage$")
    public void iClickViewMyCustomerAccountButtonOnTheHomePage() {
        homepage.clickLoggedUserNameButton();
    }

}
