package co.com.Managehr.tasks.HorasExtras;

import co.com.Managehr.userinterface.HorasExtras.FormHorasExtra;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EliminarPrimeraSolicitudHoraExtraAdmin implements Task {

    public static EliminarPrimeraSolicitudHoraExtraAdmin registro() {
        return instrumented(EliminarPrimeraSolicitudHoraExtraAdmin.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String documento = null;
        try {
            documento = actor.recall("documentoHoraExtraAdmin");
        } catch (Exception e) {
            System.out.println("No se encontró 'documentoHoraExtraAdmin' en memoria, se eliminará la primera fila.");
        }

        System.out.println("Eliminando solicitud con documento (puede ser null): " + documento);

        boolean eliminarPorDocumento = documento != null && !documento.trim().isEmpty();


        cerrarSweetAlertSiEstaVisible(actor);


        actor.attemptsTo(
                WaitUntil.the(FormHorasExtra.LISTADO_HORAS_EXTRA_ADMIN, isVisible())
                        .forNoMoreThan(8).seconds()
        );

        Target botonEliminar = eliminarPorDocumento
                ? FormHorasExtra.BTN_ELIMINAR_SOLICITUD_POR_DOCUMENTO_ADMIN.of(documento)
                : FormHorasExtra.BTN_ELIMINAR_PRIMERA_FILA_ADMIN;

        for (int intento = 1; intento <= 3; intento++) {
            try {
                System.out.println("Intentando clic en botón eliminar (intento " + intento + ")");


                actor.attemptsTo(
                        WaitUntil.the(botonEliminar, isClickable())
                                .forNoMoreThan(5).seconds(),
                        Scroll.to(botonEliminar),
                        Click.on(botonEliminar)
                );

                break;

            } catch (Exception e) {
                System.out.println("Error al hacer clic en eliminar (intento "
                        + intento + "): " + e.getMessage());

                cerrarSweetAlertSiEstaVisible(actor);

                if (intento == 3) {
                    throw e;
                }
            }
        }


        actor.attemptsTo(
                WaitUntil.the(FormHorasExtra.ALERTA_CONFIRM_ELIMINAR_ADMIN, isVisible())
                        .forNoMoreThan(5).seconds(),
                Click.on(FormHorasExtra.BTN_CONFIRMAR_ELIMINAR_ADMIN),
                WaitUntil.the(FormHorasExtra.ALERTA_CONFIRM_ELIMINAR_ADMIN, isNotVisible())
                        .forNoMoreThan(5).seconds()
        );

        cerrarSweetAlertSiEstaVisible(actor);


        actor.attemptsTo(
                WaitUntil.the(FormHorasExtra.LISTADO_HORAS_EXTRA_ADMIN, isVisible())
                        .forNoMoreThan(8).seconds()
        );
    }

    private <T extends Actor> void cerrarSweetAlertSiEstaVisible(T actor) {
        try {
            if (FormHorasExtra.ALERTA_EXITO.resolveAllFor(actor).isEmpty()) {
                return;
            }

            if (FormHorasExtra.ALERTA_EXITO.resolveFor(actor).isCurrentlyVisible()) {

                actor.attemptsTo(
                        WaitUntil.the(FormHorasExtra.ALERTA_EXITO, isNotVisible())
                                .forNoMoreThan(4).seconds()
                );
            }
        } catch (Exception e) {
            System.out.println("No se pudo esperar el SweetAlert de éxito (se ignora): " + e.getMessage());
        }
    }
}
