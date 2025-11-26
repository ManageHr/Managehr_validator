package co.com.Managehr.questions.Usuarios;

import co.com.Managehr.userinterface.Usuarios.CambioEstadoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class BotonGuardarHabilitado implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            System.out.println("=== VALIDANDO BOTÓN GUARDAR ===");

            boolean botonHabilitado = CambioEstadoPage.BTN_GUARDAR_CAMBIOS.resolveFor(actor).isEnabled();
            boolean botonVisible = CambioEstadoPage.BTN_GUARDAR_CAMBIOS.resolveFor(actor).isVisible();

            System.out.println("Botón guardar habilitado: " + botonHabilitado);
            System.out.println("Botón guardar visible: " + botonVisible);

            return botonHabilitado && botonVisible;

        } catch (Exception e) {
            System.out.println("Error validando botón guardar: " + e.getMessage());
            return false;
        }
    }

    public static BotonGuardarHabilitado estaHabilitado() {
        return new BotonGuardarHabilitado();
    }
}