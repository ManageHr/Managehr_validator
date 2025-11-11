package co.com.Managehr.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/usuario_externo_formulario.feature",
        glue = {"co.com.Managehr.stepsdefinitions.", "co.com.Managehr.utils.hooks"},
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty","html:target/cucumber-reports"}
)
public class FormularioExternoRunner {
}
