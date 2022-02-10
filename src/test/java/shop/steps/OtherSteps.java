package shop.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import shop.context.Context;
import shop.context.TestContext;
import shop.data.UserReader;
import shop.navigation.ApplicationURLs;
import shop.pages.HomePage;
import shop.pages.LoginPage;
import shop.pages.MyAccountPage;
import shop.utils.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static java.time.Duration.ofSeconds;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class OtherSteps {

    // Pages
    private final TestContext testContext;
    private final HomePage homepage = new HomePage();
    private final LoginPage loginPage= new LoginPage();
    private final MyAccountPage myAccountPage = new MyAccountPage();
//    private final TestContext testContext =  new TestContext();


    public OtherSteps(TestContext tContext) {
        this.testContext = tContext;
//        this.homepage = testContext.getPageObjectManager().getHomePage();
//        this.loginPage = testContext.getPageObjectManager().getLoginPage();
//        this.myAccountPage = testContext.getPageObjectManager().getMyAccountPage();
    }

    @Then("^I assert I am logged in as: (.+)$")
    public void iAssertIAmLoggedInAsAutomatedTest(String username) {
        homepage.loggedUsername.shouldBe(visible, ofSeconds(25)).shouldHave(Condition.exactOwnText(username));
    }

    @Then("^I am not logged in$")
    public void iAmNotLoggedIn() {
        Log.info("Error dialog about wrong email or password should be visible...");
        loginPage.invalidLoginOrPasswordLabel.shouldBe(visible);
        Log.info("Error dialog about wrong email or password should be visible. Done");
        Log.info("Error dialog is: '" + loginPage.invalidLoginOrPasswordLabel.getText() + "'");
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

    @And("^I click information button on the MyAccountPage$")
    public void iClickInformationButtonOnTheMyAccountPage() {
        myAccountPage.clickInformationButton();
    }

    @Then("^I assert I am logged in as user: (.+)$")
    public void iAssertIAmLoggedInAsUser(String user) {
        iAssertIAmLoggedInAsAutomatedTest(UserReader.getNameAndLastname(user));
    }

    @Then("^I assert that user email: (.+) is valid$")
    public void iAssertThatUserEmailIsValid(String userEmail) {
        Assert.assertEquals("Wrong email", userEmail,
                testContext.getScenarioContext().getContext(Context.USER_EMAIL_FROM_IDENTITY_PAGE));
    }

    @Then("^I assert that email for ENUM user: (.+) is valid$")
    public void iAssertThatEmailEnumUserIsValid(String user) {
        iAssertThatUserEmailIsValid(UserReader.getUserEmail(user));
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
        maps.forEach(System.out::println);
//        for (Map<String, String> row : maps) {
//            System.out.println(row.get("title1") + " " + row.get("title2") + " " + row.get("title3"));
//        }
//        System.out.println(maps.get(0).get("title1") + " " + maps.get(0).get("title2") + " " + maps.get(0).get("title3"));


        final String controlNumberColumnName = "Nr kontroli";
        final String controlTermColumnName = "Termin realizacji kontroli";
        final String controlTypeColumnName = "Typ kontroli";
        final String controlKindColumnName = "Rodzaj kontroli";

        HashMap<String, String> actualValues = new HashMap<>();
        actualValues.put(controlNumberColumnName, "23/234");
        actualValues.put(controlTermColumnName, "2022-01-26 - 2022-02-01");
        actualValues.put(controlTypeColumnName, "Wizyta monitoringowa");
        actualValues.put(controlKindColumnName, "Kontrola specjalna (doraźna)");


        for (Map<String, String> tableRow : maps) {
            String columnName = tableRow.get("columnName");
            String actualValue = null, expectedValue = null;
            try {
                switch (columnName) {
                    case controlNumberColumnName:
                        actualValue = actualValues.get(controlNumberColumnName);
                        expectedValue = getExpectedValue(tableRow);
                        break;
                    case controlTermColumnName:
                        actualValue = actualValues.get(controlTermColumnName);
                        expectedValue = getExpectedValue(tableRow);
                        break;
                    case controlTypeColumnName:
                        actualValue = actualValues.get(controlTypeColumnName);
                        expectedValue = getExpectedValue(tableRow);
                        break;
                    case controlKindColumnName:
                        actualValue = actualValues.get(controlKindColumnName);
                        expectedValue = getExpectedValue(tableRow);
                        break;
                    default:
                        System.out.println("Brak danych");
                        break;
                }
            } finally {
                Assert.assertEquals(actualValue, expectedValue);
            }
        }
    }


    private String getExpectedValue(Map<String, String> tableRow) {
        return tableRow.get("expectedValue");
    }

    @And("I provide data table test - asMap2")
    public void iProvideDataTableTestAsMap2(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps(String.class, String.class);
        maps.forEach(System.out::println);
//        for (Map<String, String> row : maps) {
//            System.out.println(row.get("title1") + " " + row.get("title2") + " " + row.get("title3"));
//        }
//        System.out.println(maps.get(0).get("title1") + " " + maps.get(0).get("title2") + " " + maps.get(0).get("title3"));

        final String controlNumberColumnName = "Nr kontroli";
        final String controlTermColumnName = "Termin realizacji kontroli";
        final String controlTypeColumnName = "Typ kontroli";
        final String controlKindColumnName = "Rodzaj kontroli";

        HashMap<String, String> actualValues = new HashMap<>();
        actualValues.put(controlNumberColumnName, "23/234");
        actualValues.put(controlTermColumnName, "2022-01-26 - 2022-02-01");
        actualValues.put(controlTypeColumnName, "Wizyta monitoringowa");
        actualValues.put(controlKindColumnName, "Kontrola specjalna (doraźna)");

        for (Map<String, String> tableRow : maps) {
            for (Map.Entry stringStringEntry : tableRow.entrySet()) {
                System.out.println(stringStringEntry.getKey());
            }

        }
    }

}