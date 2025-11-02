package junitTest;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepdef/api","hooks"},
        features = {"src/test/resources/features/api"},
        plugin = {"pretty", "html:reports/cucumberApi.html", "json:reports/cucumberApi.json"},
        tags = "@api"
)
public class CucumberTestApi {}