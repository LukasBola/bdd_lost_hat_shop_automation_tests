package shop.steps;

import io.cucumber.java.en.And;
import shop.context.Context;
import shop.context.TestContext;
import shop.data.UserReader;
import shop.pages.IdentityPage;
import shop.pages.LoginPage;

public class IdentityPageSteps {

    private final TestContext testContext;
    private final IdentityPage identityPage;
    private final LoginPage loginPage;

    public IdentityPageSteps(TestContext context) {
        this.testContext = context;
        identityPage = testContext.getPageObjectManager().getIdentityPage();
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

//    Data for ScenarioContext
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
        testContext.getScenarioContext().setContext(Context.USER_EMAIL_FROM_IDENTITY_PAGE, email);
    }
}
