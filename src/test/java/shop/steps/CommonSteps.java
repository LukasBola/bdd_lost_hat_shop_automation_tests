package shop.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.junit.Assert;
import shop.data.UserReader;
import shop.navigation.ApplicationURLs;
import shop.pages.HomePage;
import shop.pages.IdentityPage;
import shop.pages.LoginPage;
import shop.pages.MyAccountPage;
import shop.utils.Log;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static java.time.Duration.ofSeconds;

public class CommonSteps {

    // Pages
    public HomePage homepage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public IdentityPage identityPage;


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

    @Then("^I am logged in as: (.+)$")
    public void iAmLoggedInAsAutomatedTest(String username) {
        homepage.loggedUsername.shouldBe(visible, ofSeconds(25)).shouldHave(Condition.exactOwnText(username));

    }

    @Then("^I am not logged in$")
    public void iAmNotLoggedIn() {
        Log.info("Error dialog about wrong email or password should be visible...");
        loginPage.invalidLoginOrPasswordLabel.shouldBe(visible);
        Log.info("Error dialog about wrong email or password should be visible. Done");
        Log.info("Error dialog is: '" + loginPage.invalidLoginOrPasswordLabel.getText() + "'");
    }

    @And("^I click logout button on the HomePage$")
    public void iClickLogoutButtonOnTheHomePage() {
        homepage.clickSignOutButton();
    }

    @And("^I am logged out$")
    public void iAmLoggedOut() {
        loginPage.signInButton.shouldBe(visible).shouldBe(Condition.enabled);
        homepage.pageHeaderLabel.shouldBe(visible, Condition.text("Log in to your account"));
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
        identityPage = myAccountPage.clickInformationButton();
    }

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

    @And("^I type email for: (.+) on the LoginPage$")
    public void iTypeEmailForUSEROnTheLoginPage(String user) {
        iTypeEmailOnTheLoginPage(UserReader.getUserEmail(user));
    }

    @And("^I type password for: (.+) on the LoginPage$")
    public void iTypePasswordForUSEROnTheLoginPage(String user) {
        iTypePasswordPassOnTheLoginPage(UserReader.getUserPassword(user));
    }

    @And("^I type password for: (.+) on the IdentityPge$")
    public void iTypePasswordForUSEROnTheIdentityPge(String user) {
        iTypePasswordOnTheIdentityPge(UserReader.getUserPassword(user));
    }

    @Then("^I am logged in as user: (.+)$")
    public void iAmLoggedInAsUser(String user) {
        iAmLoggedInAsAutomatedTest(UserReader.getNameAndLastname(user));
    }

    @And("I provide data table test - row")
    public void iProvideDataTableTestRow(DataTable dataTable) {
        List<String> list = dataTable.row(3);
        System.out.println(list);
        for (String row : list) {
            System.out.println(row);
        }
        System.out.println();
    }

    @And("I provide data table test - asList")
    public void iProvideDataTableTestAsList(DataTable dataTable) {
        List<String> expectedButtons = dataTable.asList();
        final HashMap<String, Boolean> actualButtons = new HashMap<>();

        actualButtons.put("Prześlij do", true);
        actualButtons.put("Prześlij do mnie", true);
        actualButtons.put("Edytuj", true);
        actualButtons.put("Podgląd", true);
        actualButtons.put("Teczka", true);
        actualButtons.put("Opcje > Usuń", true);

        expectedButtons.forEach(
                expectedButton ->
                        assertThat(expectedButton, actualButtons.get(expectedButton), equalTo(true))
        );
    }

    @And("I provide data table test - asListS")
    public void iProvideDataTableTestAsListS(DataTable dataTable) {
        List<List<String>> list = dataTable.asLists();
        for (List<String> row : list) {
            System.out.println(row.get(0).equals("Prześlij do"));
        }
    }

    @And("I provide data table test - asMap")
    public void iProvideDataTableTestAsMap(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps(String.class, String.class);
        System.out.println(maps);
        for (Map<String, String> row : maps) {
            System.out.println(row.get("title1") + " " + row.get("title2") + " " + row.get("title3"));
        }
        System.out.println(maps.get(0).get("title1") + " " + maps.get(0).get("title2") + " " + maps.get(0).get("title3"));
    }
}