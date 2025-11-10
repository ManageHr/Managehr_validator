package co.com.Managehr.tasks.Postulaciones;

import co.com.Managehr.userinterface.GestionPostulacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PaginaUnoPostulaciones implements Task {
    public static final PaginaUnoPostulaciones start(){
        return  instrumented(PaginaUnoPostulaciones.class);
    }
    @Override
    public<T extends Actor> void performAs(T actor){
        try {
            actor.attemptsTo(
                    WaitUntil.the(GestionPostulacionesPage.BTN_PAGINATOR_ANTERIOR,isVisible()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(GestionPostulacionesPage.BTN_PAGINATOR_ANTERIOR,isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(GestionPostulacionesPage.BTN_PAGINATOR_ANTERIOR)
            );
            Thread.sleep(3000);
            System.out.println("Se dio click en el boton anterior");
        }catch (Exception e){
            System.out.println("Boton Anterior esta desactivado");
        }
    }
}
