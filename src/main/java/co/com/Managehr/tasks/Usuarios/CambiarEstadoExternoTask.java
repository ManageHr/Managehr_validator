package co.com.Managehr.tasks.Usuarios;

import co.com.Managehr.models.Usuarios.Usuario;
import co.com.Managehr.questions.Usuarios.BotonGuardarHabilitado;
import co.com.Managehr.userinterface.Usuarios.CambioEstadoPage;
import co.com.Managehr.userinterface.Usuarios.CrearUsuarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import static org.hamcrest.Matchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
public class CambiarEstadoExternoTask implements Task {
    private Usuario usuario;
    public CambiarEstadoExternoTask(Usuario usuario) {
        this.usuario = usuario;
    }

    public static CambiarEstadoExternoTask con(Usuario usuario) {
        return instrumented(CambiarEstadoExternoTask.class, usuario);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String textoRol = obtenerTextoRol(usuario.getRol());
        actor.attemptsTo(
                WaitUntil.the(CambioEstadoPage.BTN_EDITAR_ESTADO, isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(CambioEstadoPage.BTN_EDITAR_ESTADO, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(CambioEstadoPage.BTN_EDITAR_ESTADO)
        );
        try {
            Thread.sleep(3000);
            System.out.println("filtrando usuario");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        actor.attemptsTo(
                WaitUntil.the(CambioEstadoPage.SELECT_ROL, isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(CambioEstadoPage.SELECT_ROL, isClickable()).forNoMoreThan(15).seconds(),
                SelectFromOptions.byVisibleText(textoRol).from(CambioEstadoPage.SELECT_ROL)
        );

        actor.should(
                seeThat("El botón guardar está habilitado",
                        BotonGuardarHabilitado.estaHabilitado(),
                        is(true)
                )
        );
        actor.attemptsTo(
                Click.on(CambioEstadoPage.BTN_GUARDAR_CAMBIOS)
        );

    }
    private String obtenerTextoRol(int rol) {
        switch (rol) {
            case 1: return "Administrador";
            case 2: return "Jefe de personal";
            case 3: return "Empleado";
            case 4: return "Recursos Humanos";
            case 5: return "Externo";
            default: return "Default";
        }
    }
}
