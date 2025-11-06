package co.com.Managehr.tasks.Postulaciones;

import co.com.Managehr.userinterface.GestionPostulacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
public class GuardarEstadoPostulacion implements Task {

    public static GuardarEstadoPostulacion guardar(){
        return instrumented(GuardarEstadoPostulacion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        try {
            actor.attemptsTo(
                    WaitUntil.the(GestionPostulacionesPage.BTN_GUARDAR_ESTADO,isVisible()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(GestionPostulacionesPage.BTN_GUARDAR_ESTADO,isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(GestionPostulacionesPage.BTN_GUARDAR_ESTADO)
            );
            System.out.println("Sedio click en guardar estado");
            Thread.sleep(3000);
        }catch (Exception e){
            System.out.println("Ocurrio un error al guerdar estado");
        }
    }
}
