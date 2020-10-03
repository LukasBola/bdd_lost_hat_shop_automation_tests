package shop;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"@target/failed.txt"},
        plugin = {"json:target/json","rerun:target/failed.txt","io.qameta.allure.cucumberjvm.AllureCucumberJvm"})
public class Rerun {
}