package co.com.Managehr.tasks.Postulaciones;

import co.com.Managehr.userinterface.GestionPostulacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
public class AbrirModalEditarEstadoPostulacion implements Task {
    public static AbrirModalEditarEstadoPostulacion start(){
        return instrumented(AbrirModalEditarEstadoPostulacion.class);
    }
    public <T extends Actor> void performAs(T actor){
        try{
            actor.attemptsTo(
                    WaitUntil.the(GestionPostulacionesPage.BTN_EDITAR_ESTADO,isVisible()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(GestionPostulacionesPage.BTN_EDITAR_ESTADO,isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(GestionPostulacionesPage.BTN_EDITAR_ESTADO)
            );

            System.out.println("Se da click en editar");

        }catch (Exception e){
            System.out.println("No se encontro el boton"+e.getMessage());
        }

    }
}
