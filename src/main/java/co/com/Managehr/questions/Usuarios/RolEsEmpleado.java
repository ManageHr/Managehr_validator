package co.com.Managehr.questions.Usuarios;

import co.com.Managehr.userinterface.Usuarios.GestionUsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class RolEsEmpleado implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            String textoRol = Text.of(GestionUsuariosPage.TEXTO_ROL_DETALLES).viewedBy(actor).resolve();
            System.out.println("Rol encontrado: " + textoRol);
            return textoRol != null && textoRol.toLowerCase().contains("empleado");
        } catch (Exception e) {
            return false;
        }
    }

    public static RolEsEmpleado enDetalles() {
        return new RolEsEmpleado();
    }
}