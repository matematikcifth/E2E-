package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/ui_testler/TC01_AdminOdaOlusturur.feature",
                "src/test/resources/api_testler/TC02_ApiRoom.feature",
                "src/test/resources/database_testler/TC03_DataBaseRoom.feature"
        },
        glue = {"stepdefinitions","hooks"},
        dryRun = false
)

public class E2ERunner {

}
