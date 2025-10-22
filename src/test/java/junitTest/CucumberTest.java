package junitTest;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepdef/ui","hooks"},
        features = {"src/test/resources/features/ui"},
        plugin = {"pretty", "html:reports/cucumber.html", "json:reports/cucumber.json"},
        tags = "@ui"
)
public class CucumberTest {}
