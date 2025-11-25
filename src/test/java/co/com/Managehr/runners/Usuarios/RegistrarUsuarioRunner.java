package co.com.Managehr.runners.Usuarios;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Usuarios/registrar_usuario.feature",
        glue = {"co.com.Managehr.stepsdefinitions", "co.com.Managehr.utils.hooks"},
        snippets = SnippetType.CAMELCASE,
        tags = "@registrar_usuario",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class RegistrarUsuarioRunner {
}
