package co.com.Managehr.questions.Usuarios;

import co.com.Managehr.userinterface.Usuarios.CambioEstadoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ModalCerrado implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            System.out.println("=== VALIDANDO CIERRE DE MODAL ===");

            boolean modalNoVisible = !Visibility.of(CambioEstadoPage.MODAL_CONFIRMACION).viewedBy(actor).resolve();
            boolean modalEdicionNoVisible = !Visibility.of(CambioEstadoPage.MODAL_ESTADO).viewedBy(actor).resolve();

            System.out.println("Modal confirmación cerrado: " + modalNoVisible);
            System.out.println("Modal edición cerrado: " + modalEdicionNoVisible);

            return modalNoVisible && modalEdicionNoVisible;

        } catch (Exception e) {
            System.out.println("Error validando cierre de modal: " + e.getMessage());
            return false;
        }
    }

    public static ModalCerrado correctamente() {
        return new ModalCerrado();
    }
}