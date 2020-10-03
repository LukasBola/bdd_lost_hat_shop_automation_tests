package shop.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import shop.pages.LoginPage;
import shop.utils.Log;

import static com.codeborne.selenide.Selenide.$;

public class Header {
    public SelenideElement
            headerSignInButton = $(By.xpath("//span[contains(text() , 'Sign in') ]")),
            headerSignOutButton = $("a.logout"),
            cartButton = $(By.xpath("//span[contains(text() , 'Cart') ]")),
            searchInput = $("input[aria-label*='Search']"),
            loggedUsername = $(".account span[class*=hidden]"),
            pageHeaderLabel = $("header.page-header");


    @Step("Click login button")
    public LoginPage clickSignInButton() {
        Log.info("Click login button...");
        headerSignInButton.click();
        Log.info("Click login button. Done");
        return new LoginPage();
    }

    @Step("Click logout button")
    public void clickSignOutButton() {
        Log.info("Click sign out button...");
        headerSignOutButton.shouldBe(Condition.visible).click();
        Log.info("Click logout button. Done");
    }

}
