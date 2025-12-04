package co.com.Managehr.tasks.Vacaciones;

import co.com.Managehr.userinterface.Vacaciones.MenuVacacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavegarAVacaciones implements Task {

    public static NavegarAVacaciones enElMenu() {
        return instrumented(NavegarAVacaciones.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MenuVacacionesPage.BTN_VACACIONES)
        );
    }
}
