package co.com.Managehr.questions.Usuarios;

import co.com.Managehr.userinterface.Usuarios.CambioEstadoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class BotonCerrarDisponible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            System.out.println("=== VALIDANDO BOTÓN CERRAR ===");

            boolean botonVisible = Visibility.of(CambioEstadoPage.BOTON_CERRAR_MODAL).viewedBy(actor).resolve();
            boolean botonHabilitado = CambioEstadoPage.BOTON_CERRAR_MODAL.resolveFor(actor).isEnabled();

            System.out.println("Botón cerrar visible: " + botonVisible);
            System.out.println("Botón cerrar habilitado: " + botonHabilitado);

            return botonVisible && botonHabilitado;

        } catch (Exception e) {
            System.out.println("Error validando botón cerrar: " + e.getMessage());
            return false;
        }
    }

    public static BotonCerrarDisponible estaDisponible() {
        return new BotonCerrarDisponible();
    }
}