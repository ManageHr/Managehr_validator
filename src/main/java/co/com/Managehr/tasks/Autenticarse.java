package co.com.Managehr.tasks;
import co.com.Managehr.models.CredencialesInicioSesion;
import co.com.Managehr.utils.hooks.SesionVariable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.commons.lang3.RandomStringUtils;
import org.aspectj.weaver.tools.cache.CachedClassReference;

import javax.print.DocFlavor;
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

        actor.attemptsTo(
                WaitUntil.the(INPUT_USUARIO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(credencial.getEmail()).into(INPUT_USUARIO),
                Enter.theValue(credencial.getClave()).into(INPUT_CLAVE),
                Click.on(BTN_INICIOSESION)
        );
    }

    public static Autenticarse aute(List<CredencialesInicioSesion> credenciales) {
        return instrumented(Autenticarse.class, credenciales);
    }
}
