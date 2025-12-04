package co.com.Managehr.runners.Vacaciones;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Vacaciones/solicitud_vacaciones.feature",
        glue = "co.com.Managehr.stepsdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "@solicitud_vacaciones",
        plugin = {"pretty", "html:target/cucumber-reports"}

)
public class SolicitudVacacionesRunner {
}
