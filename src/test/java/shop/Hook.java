package shop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hook {
    public static String browser = "chrome";
    public static String browserSize = "1920x1080";
    public static Boolean headless = false;
    public static Boolean startMaximized = false;
    public static Boolean holdBrowserOpen = false;
    public static int timeout = 15000;

    @Before("@reopen_browser_for_each_test")
    public void reopenBrowserSetUp() {
        setUp();
    }

    @After("@reopen_browser_for_each_test")
    public void reopenBrowserTearDown() {
        tearDown();
    }

    @BeforeClass
    public static void setUp() {
        System.out.println("--- Initializing browser: " + browser.toUpperCase() + " ---");
        DOMConfigurator.configure("log4j.xml");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
//        SelenideLogger.addListener("name", new LogEventListener() {
//            @Override
//            public void afterEvent(LogEvent logEvent) {
//                Log.info(logEvent);
//            }
//
//            @Override
//            public void beforeEvent(LogEvent logEvent) {
//            }
//        });
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

    @AfterClass
    public static void tearDown() {
        closeWebDriver();
        System.out.println("--- Browser closed ---");
    }
}
