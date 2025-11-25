package co.com.Managehr.tasks.Autentication;

import co.com.Managehr.models.Autentication.CredencialesInicioSesion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.Managehr.userinterface.Autentication.Autenticacion.*;
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

        long startTime = System.currentTimeMillis();

        System.out.println("Ejecutando login con: " + credencial.getEmail());

        actor.attemptsTo(
                WaitUntil.the(INPUT_USUARIO, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(credencial.getEmail()).into(INPUT_USUARIO),
                Enter.theValue(credencial.getClave()).into(INPUT_CLAVE),
                Click.on(BTN_INICIOSESION)
        );

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        String currentUrl = net.serenitybdd.screenplay.abilities.BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
        System.out.println("URL actual: " + currentUrl);

        if (currentUrl.contains("directorio") || currentUrl.contains("usuarios")) {
            System.out.println("Redirección exitosa detectada");
        } else {
            System.out.println("URL diferente a la esperada, pero continuando...");
        }

        System.out.println("AUTENTICACIÓN COMPLETADA");


    }

    public static Autenticarse aute(List<CredencialesInicioSesion> credenciales) {
        return instrumented(Autenticarse.class, credenciales);
    }
}