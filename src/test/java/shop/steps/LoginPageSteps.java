package shop.steps;

import io.cucumber.java.en.And;
import shop.data.UserReader;
import shop.pages.LoginPage;

public class LoginPageSteps {

    public LoginPage loginPage;

    public LoginPageSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @And("^I type email: (.+) on the LoginPage$")
    public void iTypeEmailOnTheLoginPage(String email) {
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

    @And("^I type email for: (.+) on the LoginPage$")
    public void iTypeEmailForUSEROnTheLoginPage(String user) {
        iTypeEmailOnTheLoginPage(UserReader.getUserEmail(user));
    }

    @And("^I type password for: (.+) on the LoginPage$")
    public void iTypePasswordForUSEROnTheLoginPage(String user) {
        iTypePasswordPassOnTheLoginPage(UserReader.getUserPassword(user));
    }

}
