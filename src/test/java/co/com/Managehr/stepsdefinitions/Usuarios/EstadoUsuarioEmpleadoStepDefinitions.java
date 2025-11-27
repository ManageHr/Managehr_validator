package co.com.Managehr.stepsdefinitions.Usuarios;

import co.com.Managehr.models.Usuarios.Usuario;
import co.com.Managehr.questions.Usuarios.UsuarioFiltradoExternoAdmin;
import co.com.Managehr.tasks.Usuarios.CambiarEstadoExternoTask;
import co.com.Managehr.tasks.Usuarios.CerrarModalConfirmacionTask;
import co.com.Managehr.tasks.Usuarios.FiltrarUsuarioExternoTask;
import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EstadoUsuarioEmpleadoStepDefinitions {

    @Cuando("^se encuentra en la vista con el titulo de \"([^\"]*)\"$")
    public void seEncuentraEnLaVistaConElTituloDe(String arg1) {


    }

    @Cuando("^se encuentra busca por filtro con el numero de documento \"([^\"]*)\"$")
    public void seEncuentraBuscaPorFiltroConElNumeroDeDocumento(String documento) {
        Usuario us = new Usuario();
        us.setNumeroDocumento(Long.parseLong(documento));

        System.out.println("=== EJECUTANDO FILTRADO ===");
        System.out.println("Documento a buscar: " + documento);

        theActorInTheSpotlight().attemptsTo(FiltrarUsuarioExternoTask.con(us));

        Boolean usuarioEncontrado = theActorInTheSpotlight().asksFor(
                UsuarioFiltradoExternoAdmin.conDocumento(documento)
        );
        if (usuarioEncontrado==false){
            System.out.println("El usuario no se encontro");
        }

    }
    @Entonces("^se valide que el usuario esta en la tabla externo$")
    public void seValideQueElUsuarioEstaEnLaTablaExterno() {
        Boolean enTabla = theActorInTheSpotlight().asksFor(
                UsuarioFiltradoExternoAdmin.registroVisible()
        );

        assert enTabla : "El usuario no está visible en la tabla";
    }
    @Entonces("^se da click en el boton de editar$")
    public void seDaClickEnElBotonDeEditar() {


    }

    @Entonces("^se debe mostrar un modal con el estado y se debe cambiar$")
    public void seDebeMostrarUnModalConElEstadoYSeDebeCambiar(DataTable datosModal) {
        Map<String, String> datos = datosModal.asMap(String.class, String.class);
        Usuario us = new Usuario();
        us.setRol(Integer.parseInt(datos.get("rol")));
        theActorInTheSpotlight().attemptsTo(
                CambiarEstadoExternoTask.con(us)
        );
    }

    @Entonces("^sale un modal de actualizado y se debe cerrar el modal$")
    public void saleUnModalDeActualizadoYSeDebeCerrarElModal() {
        long startTime = System.currentTimeMillis();
        theActorInTheSpotlight().attemptsTo(
                CerrarModalConfirmacionTask.despuesDeActualizar()
        );
        long endTime = System.currentTimeMillis();

        System.out.println("Cierre modal STEP tomó: " + (endTime - startTime) + "ms");
    }


}
