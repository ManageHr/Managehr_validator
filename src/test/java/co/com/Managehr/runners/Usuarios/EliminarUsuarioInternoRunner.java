package co.com.Managehr.runners.Usuarios;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Usuarios/eliminar_usuario_interno.feature",
        glue = {"co.com.Managehr.stepsdefinitions", "co.com.Managehr.utils.hooks"},
        snippets = SnippetType.CAMELCASE,
        tags = "@eliminar_usuario_interno"
)
public class EliminarUsuarioInternoRunner {
}