package shop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import com.codeborne.selenide.logevents.SelenideLogger;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.BeforeClass;
import shop.utils.Log;

import java.io.IOException;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hook {
    public String browser = "chrome";
    public String browserSize = "1920x1250";
    public Boolean headless = false;
    public Boolean startMaximized = false;
    public Boolean holdBrowserOpen = false;
    public int timeout = 15000;

    @Before
    public void initialize() throws IOException {
        System.out.println("--- Initializing browser: " + browser.toUpperCase());
        DOMConfigurator.configure("log4j.xml");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        SelenideLogger.addListener("name", new LogEventListener() {
            @Override
            public void afterEvent(LogEvent logEvent) {
                Log.info(logEvent);
            }

            @Override
            public void beforeEvent(LogEvent logEvent) {
            }
        });

        Configuration.browser = browser;
        Configuration.headless = headless;
        Configuration.timeout = timeout;
        Configuration.browserSize = browserSize;
        Configuration.startMaximized = startMaximized;
        Configuration.holdBrowserOpen = holdBrowserOpen;
        Configuration.reportsFolder = "allure-results";
        Selenide.clearBrowserCookies();
        System.setProperty("file.encoding", "UTF-8");
    }

    @After
    public void tearDown() {
        closeWebDriver();
        System.out.println("--- Browser closed");
    }

}
