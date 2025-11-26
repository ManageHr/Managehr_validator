package co.com.Managehr.questions.Usuarios;

import co.com.Managehr.userinterface.Usuarios.CambioEstadoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;

public class ModalConfirmacionVisible implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            System.out.println("=== VALIDANDO MODAL DE CONFIRMACIÓN ===");
            boolean modalVisible = Visibility.of(CambioEstadoPage.MODAL_CONFIRMACION).viewedBy(actor).resolve();
            if (modalVisible) {
                String textoModal = Text.of(CambioEstadoPage.MODAL_CONFIRMACION).viewedBy(actor).resolve();
                System.out.println("Texto del modal: " + textoModal);
                boolean contieneExito = textoModal.toLowerCase().contains("éxito") ||
                        textoModal.toLowerCase().contains("exito") ||
                        textoModal.toLowerCase().contains("actualizado") ||
                        textoModal.toLowerCase().contains("correctamente");

                System.out.println("Contiene texto de éxito: " + contieneExito);
                return contieneExito;
            }
            System.out.println("Modal de confirmación visible: " + modalVisible);
            return modalVisible;
        } catch (Exception e) {
            System.out.println("Error validando modal de confirmación: " + e.getMessage());
            return false;
        }
    }
    public static ModalConfirmacionVisible esVisible() {
        return new ModalConfirmacionVisible();
    }
}