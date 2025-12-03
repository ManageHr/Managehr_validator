package co.com.Managehr.tasks.HorasExtras;

import co.com.Managehr.userinterface.HorasExtras.FormHorasExtra;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavegarHorasExtraAdmin implements Task {

    public static NavegarHorasExtraAdmin inicio() {
        return instrumented(NavegarHorasExtraAdmin.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(FormHorasExtra.MENU_HORAS_EXTRA, isClickable())
                        .forNoMoreThan(8).seconds(),
                Click.on(FormHorasExtra.MENU_HORAS_EXTRA),

                WaitUntil.the(FormHorasExtra.LISTADO_HORAS_EXTRA_ADMIN, isVisible())
                        .forNoMoreThan(8).seconds()
        );
    }
}
