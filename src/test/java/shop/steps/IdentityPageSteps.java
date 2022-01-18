package shop.steps;

import io.cucumber.java.en.And;
import shop.context.Context;
import shop.context.TestContext;
import shop.data.UserReader;
import shop.pages.IdentityPage;
import shop.pages.LoginPage;
import shop.utils.Log;

public class IdentityPageSteps {

    public TestContext testContext;
    public IdentityPage identityPage;
    public LoginPage loginPage;

    public IdentityPageSteps(TestContext testContext, IdentityPage identityPage, LoginPage loginPage) {
        this.testContext = testContext;
        this.identityPage = identityPage;
        this.loginPage = loginPage;
    }

    String email;

    @And("^I type name: (.+) on the IdentityPge$")
    public void iTypeNameOnTheIdentityPge(String newName) {
        identityPage.typeName(newName);
    }

    @And("^I type last name: (.+) on the IdentityPge$")
    public void iTypeLastNameOnTheIdentityPge(String newLastName) {
        identityPage.typeLastName(newLastName);
    }

    @And("^I type password: (.+) on the IdentityPge$")
    public void iTypePasswordOnTheIdentityPge(String password) {
        loginPage.typePassword(password);
    }

    @And("^I click save button on the IdentityPge$")
    public void iClickSaveButtonOnTheIdentityPge() {
        identityPage.clickSaveButton();
    }

    @And("^I type password for: (.+) on the IdentityPge$")
    public void iTypePasswordForUSEROnTheIdentityPge(String user) {
        iTypePasswordOnTheIdentityPge(UserReader.getUserPassword(user));
    }

    @And("^I get email from the IdentityPge$")
    public void iGetEmailFromTheIdentityPge() {
        email = identityPage.getEmail();
        testContext.scenarioContext.setContext(Context.EMAIL_FROM_IDENTITY_PAGE, email);
    }
}
