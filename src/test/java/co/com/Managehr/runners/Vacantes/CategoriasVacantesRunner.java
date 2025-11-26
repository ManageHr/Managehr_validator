package co.com.Managehr.runners.Vacantes;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Vacantes/categorias_vacantes.feature",
        glue = "co.com.Managehr.stepsdefinitions",
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class CategoriasVacantesRunner {

    @BeforeClass
    public static void configurarIncognito() {
        System.setProperty("chrome.switches", "--incognito;--start-maximized");
    }
}
