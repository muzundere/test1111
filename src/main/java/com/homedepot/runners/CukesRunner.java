package com.homedepot.runners;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "src/main/java/com/homedepot/stepdefs",
        plugin = "json:target/cucumber.json",
        dryRun = false
)
public class CukesRunner {

}
