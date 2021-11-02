import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        tags = "@web-duo or @web-trio",
        features = {
                "src/test/resources/features/telefonica",
        },
        glue={
                "steps",
                "com.tsoft.bot.frontend.helpers",
                "com.tsoft.bot.frontend.steps"
        }
)
@Test
public class RunTest extends AbstractTestNGCucumberTests {}
