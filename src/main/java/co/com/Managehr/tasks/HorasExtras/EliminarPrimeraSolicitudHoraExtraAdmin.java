package co.com.Managehr.tasks.HorasExtras;

import co.com.Managehr.userinterface.HorasExtras.FormHorasExtra;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class EliminarPrimeraSolicitudHoraExtraAdmin implements Task {

    public static EliminarPrimeraSolicitudHoraExtraAdmin registro() {
        return instrumented(EliminarPrimeraSolicitudHoraExtraAdmin.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String documento = actor.recall("documentoHoraExtraAdmin");

        System.out.println("Eliminando solicitud con documento: " + documento);

        if (documento != null && !documento.trim().isEmpty()) {

            actor.attemptsTo(
                    WaitUntil.the(FormHorasExtra.BTN_ELIMINAR_SOLICITUD_POR_DOCUMENTO_ADMIN.of(documento),
                            isClickable()).forNoMoreThan(5).seconds(),
                    Click.on(FormHorasExtra.BTN_ELIMINAR_SOLICITUD_POR_DOCUMENTO_ADMIN.of(documento))
            );
        } else {

            actor.attemptsTo(
                    WaitUntil.the(FormHorasExtra.BTN_ELIMINAR_PRIMERA_FILA_ADMIN,
                            isClickable()).forNoMoreThan(5).seconds(),
                    Click.on(FormHorasExtra.BTN_ELIMINAR_PRIMERA_FILA_ADMIN)
            );
        }


        actor.attemptsTo(

                WaitUntil.the(FormHorasExtra.ALERTA_CONFIRM_ELIMINAR_ADMIN, isVisible())
                        .forNoMoreThan(3).seconds(),


                Click.on(FormHorasExtra.BTN_CONFIRMAR_ELIMINAR_ADMIN)


        );

        System.out.println("Eliminación completada exitosamente");
    }
}