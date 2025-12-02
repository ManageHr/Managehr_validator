package co.com.Managehr.questions.Vacaciones;

import co.com.Managehr.userinterface.Vacaciones.MensajeVacacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MensajeConfirmacionVacaciones implements Question<String> {

    public static MensajeConfirmacionVacaciones texto() {
        return new MensajeConfirmacionVacaciones();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(MensajeVacacionesPage.LBL_MENSAJE_CONFIRMACION)
                .viewedBy(actor)
                .asString();
    }
}
