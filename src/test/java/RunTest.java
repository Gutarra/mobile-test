import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
<<<<<<< HEAD
        tags = "@web-duo or @web-trio",
        features = {
                "src/test/resources/features/telefonica",
=======
        tags = "@USSD",
        features = {
                "src/test/resources/features/buyproducts",
                "src/test/resources/features/service",
                "src/test/resources/features/ussd",
                "src/main/resources/features",
>>>>>>> mobile-prototype
        },
        glue={
                "steps",
                "com.tsoft.bot.frontend.helpers",
                "com.tsoft.bot.frontend.steps"
        }
)
@Test
public class RunTest extends AbstractTestNGCucumberTests {}
