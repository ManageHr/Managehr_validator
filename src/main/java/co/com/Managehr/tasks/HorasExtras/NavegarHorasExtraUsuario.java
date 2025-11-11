package co.com.Managehr.tasks.HorasExtras;

import co.com.Managehr.userinterface.FormHorasExtra;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static  net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
public class NavegarHorasExtraUsuario implements Task {
    public static NavegarHorasExtraUsuario inicio(){
        return instrumented(NavegarHorasExtraUsuario.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor){
               try {
                   actor.attemptsTo(
                           WaitUntil.the(FormHorasExtra.MENU_HORAS_EXTRA, isVisible()).forNoMoreThan(30).seconds(),
                           Click.on(FormHorasExtra.MENU_HORAS_EXTRA),
                           WaitUntil.the(FormHorasExtra.FORM_CONTENEDOR, isVisible()).forNoMoreThan(30).seconds()
                   );
                   Thread.sleep(3000);
                   System.out.printf("Se dio click en Horas Extra");
               } catch (Exception e) {
                   System.out.printf("No encontro horas extra en el menu");
               }
    }
}
