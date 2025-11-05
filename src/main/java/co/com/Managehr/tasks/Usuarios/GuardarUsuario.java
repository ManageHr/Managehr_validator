package co.com.Managehr.tasks.Usuarios;

import co.com.Managehr.userinterface.CrearUsuarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class GuardarUsuario implements Task {

    public static GuardarUsuario ahora() {
        return instrumented(GuardarUsuario.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Haciendo clic en Guardar...");
        actor.attemptsTo(
                Click.on(CrearUsuarioPage.BTN_GUARDAR)
        );
        try {
            System.out.println("Esperando a que se procese la respuesta...");
            Thread.sleep(3000);
            System.out.println("Procesamiento completado - continuando con validación de alerta");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}