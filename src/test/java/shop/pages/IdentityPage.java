package shop.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import shop.utils.Log;

import static com.codeborne.selenide.Selenide.$;

public class IdentityPage {
    public SelenideElement
            socialTitleMrRadioButton = $(".custom-radio ", 1),
            socialTitleMrsRadioButton = $(".custom-radio ", 2),
            firsNameInput = $("input[name*='firstname']"),
            lastNameInput = $("input[name*='lastname']"),
            emailInput = $("input[name*='email']"),
            passwordInput = $("input[name*='password']"),
            newPasswordInput = $("input[name*='new_password']"),
            birthdayInput = $("input[name*='birthday']"),
            saveButton = $("button[class*='form-control-submit']");

    @Step("Click save button")
    public void clickSaveButton() {
        Log.info("Click save button...");
        saveButton.shouldBe(Condition.enabled).shouldBe(Condition.visible).click();
        Log.info("Click save button. Done");
    }

    @Step("Type name")
    public void typeName(String name) {
        Log.info("Type name: '" + name + "'...");
        firsNameInput.shouldBe(Condition.enabled).shouldBe(Condition.visible).clear();
        firsNameInput.setValue(name);
        Log.info("Type name: '" + name + "'. Done");
    }

    @Step("Type last name")
    public void typeLastName(String lastName) {
        Log.info("Type last name: '" + lastName + "'...");
        lastNameInput.shouldBe(Condition.enabled).shouldBe(Condition.visible).clear();
        lastNameInput.setValue(lastName);
        Log.info("Type last name: '" + lastName + "'. Done");
    }

}
