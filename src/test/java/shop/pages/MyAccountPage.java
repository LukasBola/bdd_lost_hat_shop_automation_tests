package shop.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import shop.utils.Log;

import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage {

    public SelenideElement informationButton = $("#identity-link");

    @Step("Click information button")
    public IdentityPage clickInformationButton(){
        Log.info("Click information button...");
        informationButton.shouldBe(Condition.enabled).shouldBe(Condition.visible).click();
        Log.info("Click information. Done");
        return new IdentityPage();
    }
}
