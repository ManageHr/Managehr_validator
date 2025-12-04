package co.com.Managehr.tasks.Autentication;


import co.com.Managehr.userinterface.Autentication.LogoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CerrarSesion implements Task {

    public static CerrarSesion ahora() {
        return instrumented(CerrarSesion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(">>> Haciendo clic en el botón 'Cerrar sesión'");
        actor.attemptsTo(
                Click.on(LogoutPage.BTN_CERRAR_SESION)
        );
        System.out.println(">>> Sesión cerrada correctamente (se espera volver al login)");
    }
}
