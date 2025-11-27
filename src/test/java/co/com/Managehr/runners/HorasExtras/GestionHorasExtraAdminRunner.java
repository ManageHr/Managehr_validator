package co.com.Managehr.runners.HorasExtras;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/HorasExtras/gestion_horas_extra_admin.feature",
        glue = "co.com.Managehr.stepsdefinitions",
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class GestionHorasExtraAdminRunner {

    @BeforeClass
    public static void configurarIncognito() {
        System.setProperty("chrome.switches", "--incognito;--start-maximized");
    }


}
