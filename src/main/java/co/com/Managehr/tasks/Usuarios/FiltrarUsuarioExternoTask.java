package co.com.Managehr.tasks.Usuarios;

import co.com.Managehr.models.Usuarios.Usuario;
import co.com.Managehr.userinterface.Usuarios.CambioEstadoPage;
import co.com.Managehr.userinterface.Usuarios.CrearUsuarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class FiltrarUsuarioExternoTask implements Task {
    private Usuario usuario;
    public FiltrarUsuarioExternoTask(Usuario usuario) {
        this.usuario = usuario;
    }

    public static FiltrarUsuarioExternoTask con(Usuario usuario) {
        return instrumented(FiltrarUsuarioExternoTask.class, usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CambioEstadoPage.TITULO_EXTERNO, isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(CambioEstadoPage.INPUT_FILTRO_EXTERNO, isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(CambioEstadoPage.INPUT_FILTRO_EXTERNO, isClickable()).forNoMoreThan(15).seconds(),
                Enter.theValue(String.valueOf(usuario.getNumeroDocumento())).into(CrearUsuarioPage.FILTRO_USUARIOS_INPUT)

        );



    }

}
