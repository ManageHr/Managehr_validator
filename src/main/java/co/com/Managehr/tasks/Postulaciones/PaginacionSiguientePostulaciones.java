package co.com.Managehr.tasks.Postulaciones;

import co.com.Managehr.userinterface.Postulaciones.GestionPostulacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
public class PaginacionSiguientePostulaciones implements Task {

    public static final PaginacionSiguientePostulaciones start(){
        return  instrumented(PaginacionSiguientePostulaciones.class);
    }
    @Override
    public<T extends Actor> void performAs(T actor){
        try {
            actor.attemptsTo(
                    WaitUntil.the(GestionPostulacionesPage.BTN_PAGINATOR_SIGUIENTE,isVisible()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(GestionPostulacionesPage.BTN_PAGINATOR_SIGUIENTE,isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(GestionPostulacionesPage.BTN_PAGINATOR_SIGUIENTE)
            );
            Thread.sleep(3000);
            System.out.println("Se dio click en siguiente");
        }catch (Exception e){
            System.out.println("Boton Siguiente esta deactivado");
        }
    }
}
