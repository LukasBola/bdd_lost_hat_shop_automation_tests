package shop;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".",
        plugin = {"json:target/json","rerun:target/failed.txt","io.qameta.allure.cucumberjvm.AllureCucumberJvm"}
)
public class RunnerTest {
}
