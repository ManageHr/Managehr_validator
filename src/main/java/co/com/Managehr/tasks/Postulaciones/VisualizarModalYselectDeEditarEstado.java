package co.com.Managehr.tasks.Postulaciones;

import co.com.Managehr.userinterface.Postulaciones.GestionPostulacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
public class VisualizarModalYselectDeEditarEstado implements Task {
    private String select;


    public static VisualizarModalYselectDeEditarEstado start(){
        return instrumented(VisualizarModalYselectDeEditarEstado.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor){
        System.out.println("Iniciar vista del modal con el select de estados");
        try{

                    actor.attemptsTo(
                            WaitUntil.the(GestionPostulacionesPage.MODAL_EDITAR, isVisible()).forNoMoreThan(10).seconds(),
                            WaitUntil.the(GestionPostulacionesPage.SELECT_ESTADO, isVisible()).forNoMoreThan(10).seconds(),
                            WaitUntil.the(GestionPostulacionesPage.SELECT_ESTADO, isClickable()).forNoMoreThan(10).seconds()
                    );

            Thread.sleep(3000);
            System.out.println("Se selecciono el estado");
        } catch (Exception e) {
            System.out.println("No se encontro el modal");
        }
    }
}
