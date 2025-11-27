package co.com.Managehr.questions.HorasExtra;

import co.com.Managehr.tasks.HorasExtras.CambiarEstadoPrimeraSolicitudHoraExtraAdmin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.Managehr.userinterface.HorasExtras.FormHorasExtra.ESTADO_SOLICITUD_POR_DOCUMENTO_ADMIN;

public class EstadoPrimeraSolicitudHorasExtra implements Question<String> {

    public static EstadoPrimeraSolicitudHorasExtra actual() {
        return new EstadoPrimeraSolicitudHorasExtra();
    }

    @Override
    public String answeredBy(Actor actor) {


        String documento = actor.recall(CambiarEstadoPrimeraSolicitudHoraExtraAdmin.KEY_DOCUMENTO_HORA_EXTRA_ADMIN);

        if (documento == null) {
            System.out.println("⚠ documentoHoraExtraAdmin es NULL en el recall");
            return "";
        }

        String estado = Text.of(ESTADO_SOLICITUD_POR_DOCUMENTO_ADMIN.of(documento))
                .viewedBy(actor)
                .asString()
                .trim();

        System.out.println("Estado actual de la solicitud con documento " + documento + ": " + estado);
        return estado;
    }
}
