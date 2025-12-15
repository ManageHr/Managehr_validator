package co.com.Managehr.stepsdefinitions.Contratos;

import co.com.Managehr.tasks.Contratos.DescargarExcelContratosTask;
import co.com.Managehr.tasks.Contratos.GenerarReporteContratosTask;
import co.com.Managehr.tasks.Contratos.ModalReporteContratoTask;
import co.com.Managehr.tasks.Contratos.NavegarContratosTask;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GenerarReporteContratosStepDefinitions {

    @Dado("^que me encuentro en la página de gestión de contratos$")
    public void queMeEncuentroEnLaPáginaDeGestiónDeContratos() {
        theActorInTheSpotlight().attemptsTo(
                NavegarContratosTask.ahora()
        );
    }

    @Cuando("^doy clic en \"([^\"]*)\"$")
    public void doyClicEn(String opcion) {
        if (opcion.equals("Contratos")) {
            theActorInTheSpotlight().attemptsTo(
                    NavegarContratosTask.ahora()
            );
        } else if (opcion.equals("Reporte por Usuario")) {
            theActorInTheSpotlight().attemptsTo(
                    GenerarReporteContratosTask.ahora()
            );
        }
    }

    @Entonces("^debo visualizar que me encuentro en \"([^\"]*)\"$")
    public void deboVisualizarQueMeEncuentroEn(String pagina) {

        if (pagina.equals("Gestión de Contratos")) {
            theActorInTheSpotlight().attemptsTo(
                    NavegarContratosTask.ahora()
            );
        }
    }

    @Entonces("^se debe visualizar el modal con el reporte$")
    public void seDebeVisualizarElModalConElReporte() {
        theActorInTheSpotlight().attemptsTo(
                ModalReporteContratoTask.verificarModal()
        );
    }

    @Cuando("^doy clic en el botón \"([^\"]*)\"$")
    public void doyClicEnElBotón(String boton) {

                theActorInTheSpotlight().attemptsTo(
                        DescargarExcelContratosTask.ahora()
                );

    }

    @Entonces("^se debe descargar el archivo Excel en la carpeta de descargas$")
    public void seDebeDescargarElArchivoExcelEnLaCarpetaDeDescargas() {

    }

    @Entonces("^se debe descargar un archivo PDF$")
    public void seDebeDescargarUnArchivoPDF() {

    }

    @Entonces("^el modal debe cerrarse$")
    public void elModalDebeCerrarse() {

    }
}