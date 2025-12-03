package co.com.Managehr.tasks.HorasExtras;

import co.com.Managehr.userinterface.HorasExtras.FormHorasExtra;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class CambiarEstadoPrimeraSolicitudHoraExtraAdmin implements Task {


    public static final String KEY_DOCUMENTO_HORA_EXTRA_ADMIN = "documentoHoraExtraAdmin";

    private final String nuevoEstado;

    public CambiarEstadoPrimeraSolicitudHoraExtraAdmin(String nuevoEstado) {
        this.nuevoEstado = nuevoEstado;
    }

    public static CambiarEstadoPrimeraSolicitudHoraExtraAdmin a(String nuevoEstado) {
        return instrumented(CambiarEstadoPrimeraSolicitudHoraExtraAdmin.class, nuevoEstado);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        String documento = Text.of(FormHorasExtra.DOCUMENTO_PRIMERA_FILA_ADMIN)
                .viewedBy(actor)
                .asString()
                .trim();

        System.out.println("Documento de la solicitud que se va a editar: " + documento);


        actor.remember(KEY_DOCUMENTO_HORA_EXTRA_ADMIN, documento);


        actor.attemptsTo(
                WaitUntil.the(FormHorasExtra.BTN_CAMBIAR_ESTADO_PRIMERA_FILA_ADMIN, isClickable())
                        .forNoMoreThan(5).seconds(),
                Click.on(FormHorasExtra.BTN_CAMBIAR_ESTADO_PRIMERA_FILA_ADMIN),

                WaitUntil.the(FormHorasExtra.SELECT_ESTADO_MODAL_ADMIN, isVisible())
                        .forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(nuevoEstado)
                        .from(FormHorasExtra.SELECT_ESTADO_MODAL_ADMIN),

                WaitUntil.the(FormHorasExtra.BTN_GUARDAR_CAMBIO_ESTADO_ADMIN, isClickable())
                        .forNoMoreThan(5).seconds(),
                Click.on(FormHorasExtra.BTN_GUARDAR_CAMBIO_ESTADO_ADMIN),

                WaitUntil.the(
                                FormHorasExtra.ESTADO_SOLICITUD_POR_DOCUMENTO_ADMIN.of(documento),
                                containsText(nuevoEstado))
                        .forNoMoreThan(8).seconds()
        );
    }
}
