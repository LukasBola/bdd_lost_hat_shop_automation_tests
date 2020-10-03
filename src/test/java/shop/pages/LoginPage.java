package shop.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import shop.utils.Log;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public SelenideElement
            emailInput = $(" input[class*='form'][name*='email']"),
            passwordInput = $(" input[class*='form'][name*='password']"),
            signInButton = $("#submit-login"),
            invalidLoginOrPasswordLabel = $(By.xpath("//*[@class = 'alert alert-danger']"));

    @Step("Type email")
    public void typeEmail(String email) {
        Log.info("Type email: '" + email + "'...");
        emailInput.shouldBe(Condition.enabled).shouldBe(Condition.visible).setValue(email);
        Log.info("Type email: '" + email + "'. Done");
    }

    @Step("Type password")
    public void typePassword(String password) {
        Log.info("Type password: '" + password + "'...");
        passwordInput.shouldBe(Condition.enabled).shouldBe(Condition.visible).setValue(password);
        Log.info("Type password: '" + password + "'. Done");
    }

    @Step("Click sign in button")
    public void clickSignIn() {
        Log.info("Click login button...");
        signInButton.shouldBe(Condition.enabled).shouldBe(Condition.visible).click();
        Log.info("Click login button. Done");
    }


}
