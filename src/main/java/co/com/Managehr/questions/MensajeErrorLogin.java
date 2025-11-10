package co.com.Managehr.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.Managehr.userinterface.Autenticacion.MENSAJE_ERROR;

public class MensajeErrorLogin implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        try {
            if (MENSAJE_ERROR.resolveFor(actor).isVisible()) {
                String mensaje = Text.of(MENSAJE_ERROR).viewedBy(actor).asString();
                System.out.println("Mensaje de error capturado: " + mensaje);
                return mensaje;
            } else {
                System.out.println("No hay mensaje de error visible");
                return "No se encontró mensaje de error";
            }

        } catch (Exception e) {
            System.out.println("No se pudo capturar el mensaje de error: " + e.getMessage());
            return "No se encontró mensaje de error";
        }
    }

    public static MensajeErrorLogin obtenido() {
        return new MensajeErrorLogin();
    }
}