package co.com.Managehr.questions.Usuarios;

import co.com.Managehr.userinterface.Usuarios.GestionUsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;

public class UsuarioFiltradoInternoAdmin implements Question<Boolean> {

    public static UsuarioFiltradoInternoAdmin registroVisible() {
        return new UsuarioFiltradoInternoAdmin();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            return Visibility.of(GestionUsuariosPage.REGISTRO_INTERNO).viewedBy(actor).resolve();
        } catch (Exception e) {
            return false;
        }
    }
}