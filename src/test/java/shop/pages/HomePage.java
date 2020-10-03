package shop.pages;

import io.qameta.allure.Step;
import shop.components.Header;
import shop.utils.Log;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class HomePage extends Header {

    @Step("Open homepage")
    public void openHomepage() {
        open("https://autodemo.testoneo.com/en/");
        Log.info("Current URL: " + url());
    }
}
