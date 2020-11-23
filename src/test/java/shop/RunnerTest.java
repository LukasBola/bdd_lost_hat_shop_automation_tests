package shop;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        stepNotifications = true,
        features = ".",
        plugin = {"json:target/json", "rerun:target/failed.txt", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"}
)
public class RunnerTest {
}
