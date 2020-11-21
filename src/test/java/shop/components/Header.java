package shop.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import shop.pages.LoginPage;
import shop.pages.MyAccountPage;
import shop.utils.Log;

import static com.codeborne.selenide.Selenide.$;

public interface Header {
    SelenideElement
            headerSignInButton = $(By.xpath("//span[contains(text() , 'Sign in') ]")),
            headerSignOutButton = $("a.logout"),
            cartButton = $(By.xpath("//span[contains(text() , 'Cart') ]")),
            searchInput = $("input[aria-label*='Search']"),
            loggedUsername = $(".account span[class*=hidden]"),
            pageHeaderLabel = $("header.page-header");


    @Step("Click login button")
    default LoginPage clickSignInButton() {
        Log.info("Click login button...");
        headerSignInButton.click();
        Log.info("Click login button. Done");
        return new LoginPage();
    }

    @Step("Click logout button")
    default void clickSignOutButton() {
        Log.info("Click sign out button...");
        headerSignOutButton.shouldBe(Condition.visible).click();
        Log.info("Click logout button. Done");
    }

    @Step("Click logged user name button")
    default MyAccountPage clickLoggedUserNameButton() {
        Log.info("Click logged user name button...");
        loggedUsername.shouldBe(Condition.visible).click();
        Log.info("Click logged user name button. Done");
        return new MyAccountPage();
    }

}
