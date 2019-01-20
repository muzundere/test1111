package com.homedepot.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@regression, @smoke",
        features = "src/main/resources/features",
        glue = "com.homedepot.stepdefs",
        plugin = {"json:target/cucumber.json","pretty","html:target/html_report"},
        dryRun = false
)
public class CukesRunner {

}
