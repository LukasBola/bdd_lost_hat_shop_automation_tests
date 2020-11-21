package shop.pages;

import io.qameta.allure.Step;
import shop.components.Header;
import shop.navigation.ApplicationURLs;
import shop.utils.Log;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class HomePage implements Header {

    @Step("Open homepage")
    public void openHomepage() {
        open(ApplicationURLs.BASE_URL);
        Log.info("Current URL: " + url());
    }
}
