package co.com.Managehr.tasks.Usuarios;

import co.com.Managehr.questions.Usuarios.BotonCerrarDisponible;
import co.com.Managehr.questions.Usuarios.ModalCerrado;
import co.com.Managehr.questions.Usuarios.ModalConfirmacionVisible;
import co.com.Managehr.userinterface.Usuarios.CambioEstadoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.is;

public class CerrarModalConfirmacionTask implements Task {

    public static CerrarModalConfirmacionTask despuesDeActualizar() {
        return instrumented(CerrarModalConfirmacionTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        long startTime = System.currentTimeMillis();
        System.out.println("=== CERRANDO MODAL DE CONFIRMACIÓN ===");
        actor.should(
                seeThat("El modal de confirmación es visible",
                        ModalConfirmacionVisible.esVisible(),
                        is(true)
                )
        );
        actor.should(
                seeThat("El botón cerrar está disponible",
                        BotonCerrarDisponible.estaDisponible(),
                        is(true)
                )
        );
        actor.attemptsTo(
                Click.on(CambioEstadoPage.BOTON_CERRAR_MODAL)
        );

        long endTime = System.currentTimeMillis();

        System.out.println("Cierre modal tomó: " + (endTime - startTime) + "ms");

    }
}