import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        tags = "@MOVISTAR-APP",
        features = {
                "src/test/resources/features/buyproducts",
                "src/test/resources/features/service",
                "src/test/resources/features/ussd",
                "src/test/resources/features/MovistarApp",
                "src/main/resources/features",
        },
        glue={
                "steps",
                "com.tsoft.bot.frontend.helpers",
                "com.tsoft.bot.frontend.steps",
                "com.tsoft.bot.mobile.helpers"
        }
)
@Test
public class RunTest extends AbstractTestNGCucumberTests {}
