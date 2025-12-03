package co.com.Managehr.runners.Vacaciones;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Vacaciones/solicitud_vacaciones.feature",
        glue = "co.com.Managehr.stepsdefinitions",   // incluye Autentication y Vacaciones
        snippets = SnippetType.CAMELCASE,
        tags = "@solicitud_vacaciones"
)
public class SolicitudVacacionesRunner {
}
