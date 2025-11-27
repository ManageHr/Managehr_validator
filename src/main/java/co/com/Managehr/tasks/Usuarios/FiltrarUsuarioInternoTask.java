package co.com.Managehr.tasks.Usuarios;

import co.com.Managehr.models.Usuarios.Usuario;
import co.com.Managehr.userinterface.Usuarios.GestionUsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class FiltrarUsuarioInternoTask implements Task {
    private Usuario usuario;

    public FiltrarUsuarioInternoTask(Usuario usuario) {
        this.usuario = usuario;
    }

    public static FiltrarUsuarioInternoTask con(Usuario usuario) {
        return instrumented(FiltrarUsuarioInternoTask.class, usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String documento = String.valueOf(usuario.getNumeroDocumento());

        System.out.println("=== FILTRANDO USUARIO INTERNO ===");
        System.out.println("Documento: " + documento);

        actor.attemptsTo(
                WaitUntil.the(GestionUsuariosPage.INPUT_FILTRO_INTERNO, isVisible()).forNoMoreThan(8).seconds(),
                Enter.theValue(documento).into(GestionUsuariosPage.INPUT_FILTRO_INTERNO),
                WaitUntil.the(GestionUsuariosPage.REGISTRO_INTERNO, isVisible()).forNoMoreThan(5).seconds()
        );
    }
}