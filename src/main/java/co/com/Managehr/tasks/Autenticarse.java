package co.com.Managehr.tasks;

import co.com.Managehr.models.CredencialesInicioSesion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.Managehr.userinterface.Autenticacion.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Autenticarse implements Task{
    private List<CredencialesInicioSesion> credenciales;

    public Autenticarse(List<CredencialesInicioSesion> credenciales) {
        this.credenciales = credenciales;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CredencialesInicioSesion credencial = credenciales.get(0);

     

        System.out.println("Ejecutando login con: " + credencial.getEmail());

        actor.attemptsTo(
                WaitUntil.the(INPUT_USUARIO, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(credencial.getEmail()).into(INPUT_USUARIO),
                Enter.theValue(credencial.getClave()).into(INPUT_CLAVE),
                Click.on(BTN_INICIOSESION)
        );

        try {
            Thread.sleep(3000);
            System.out.println("Espera completada - procediendo a validación...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        try {
            if (MENSAJE_ERROR.resolveFor(actor).isVisible()) {
                String textoError = MENSAJE_ERROR.resolveFor(actor).getText();
                System.out.println("Se encontró mensaje de error: " + textoError);
            }
        } catch (Exception e) {

        }
    }

    public static Autenticarse aute(List<CredencialesInicioSesion> credenciales) {
        return instrumented(Autenticarse.class, credenciales);
    }
}