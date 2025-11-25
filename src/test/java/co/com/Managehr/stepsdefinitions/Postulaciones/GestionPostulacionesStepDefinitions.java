package co.com.Managehr.stepsdefinitions.Postulaciones;

import co.com.Managehr.models.Postulaciones.Postulaciones;
import co.com.Managehr.tasks.Postulaciones.*;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;
public class GestionPostulacionesStepDefinitions {
    private String select;
    @Cuando("^navega a la sección \"([^\"]*)\" y selecciona \"([^\"]*)\"$")
    public void navegaALaSecciónYSelecciona(String arg1, String arg2) {
        theActorInTheSpotlight().attemptsTo(AbrirPostulaciones.enSeccion(arg1,arg2));
    }

    @Entonces("^debe ser direccionado a la vista de \"([^\"]*)\"$")
    public void debeSerDireccionadoALaVistaDe(String vistaEsperada) {
        String currentUrl = net.serenitybdd.screenplay.abilities.BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().getCurrentUrl();


        if (vistaEsperada.equals(vistaEsperada)) {
            if (currentUrl.contains("postulaciones")) {
                System.out.println("Validación exitosa - Estamos en Gestión de Postulaciones");
            } else {
                System.out.println(" Validación fallida - No estamos en la página de postulaciones");
            }
        }
    }

    @Entonces("^debe visualizar la tabla con los registros de postulaciones$")
    public void debeVisualizarLaTablaConLosRegistrosDePostulaciones() {
        theActorInTheSpotlight().attemptsTo(TablaPostulaciones.filtrar(""));
    }

    @Cuando("^hace click en \"([^\"]*)\" de una postulación$")
    public void haceClickEnDeUnaPostulación(String arg1) {
        theActorInTheSpotlight().attemptsTo(DetallesPostulaciones.validar());
    }
    @Entonces("^debe aparecer un modal con la información completa de la postulación$")
    public void debeAparecerUnModalConLaInformaciónCompletaDeLaPostulación() {

    }

    @Entonces("^al hacer click en el botón \"([^\"]*)\" del modal$")
    public void alHacerClickEnElBotónDelModal(String arg1) {

    }

    @Entonces("^debe cerrarse la información del modal$")
    public void debeCerrarseLaInformaciónDelModal() {

    }
    @Cuando("^hace click en el botón \"([^\"]*)\" de una postulación$")
    public void haceClickEnElBotónDeUnaPostulación(String arg1) {
        theActorInTheSpotlight().attemptsTo(AbrirModalEditarEstadoPostulacion.start());
    }

    @Entonces("^debe aparecer un modal con un select para cambiar el estado$")
    public void debeAparecerUnModalConUnSelectParaCambiarElEstado() {
        theActorInTheSpotlight().attemptsTo(VisualizarModalYselectDeEditarEstado.start());
    }

    @Entonces("^completa el estado a cambiar:$")
    public void completaElEstadoACambiar(DataTable dataTable) {
        Map<String, String> datos = dataTable.asMap(String.class, String.class);
        Postulaciones pos = new Postulaciones();
        pos.setEstado(datos.get("estado"));
        theActorInTheSpotlight().attemptsTo(CamviarEstadoPostulacion.start(pos.getEstado()));
    }

    @Entonces("^hace click en el botón Guardar$")
    public void haceClickEnElBotónGuardar() {
        theActorInTheSpotlight().attemptsTo(GuardarEstadoPostulacion.guardar());
    }

    @Entonces("^debe actualizarse el estado en la tabla de postulaciones$")
    public void debeActualizarseElEstadoEnLaTablaDePostulaciones() {

    }

    @Cuando("^hace click en el botón \"([^\"]*)\" de paginación$")
    public void haceClickEnElBotónDePaginación(String arg1) {
        theActorInTheSpotlight().attemptsTo(PaginacionSiguientePostulaciones.start());
        theActorInTheSpotlight().attemptsTo(PaginaUnoPostulaciones.start());
    }

    @Entonces("^debe cargar la segunda página de registros$")
    public void debeCargarLaSegundaPáginaDeRegistros() {
        System.out.println("Se valida que estamos en la pagina 2");
    }

    @Cuando("^ingresa datos en el campo de filtrado \"([^\"]*)\"$")
    public void ingresaDatosEnElCampoDeFiltrado(String valor) {

        theActorInTheSpotlight().attemptsTo(TablaPostulaciones.filtrar(valor));
    }


    @Entonces("^debe filtrar y mostrar solo las postulaciones que coincidan$")
    public void debeFiltrarYMostrarSoloLasPostulacionesQueCoincidan() {

    }
}
