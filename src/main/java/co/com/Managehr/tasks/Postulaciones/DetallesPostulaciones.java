package co.com.Managehr.tasks.Postulaciones;

import co.com.Managehr.userinterface.GestionPostulacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
public class DetallesPostulaciones implements Task {
    public static DetallesPostulaciones validar(){
        return instrumented(DetallesPostulaciones.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor){
        System.out.println("Iniciando proceso de ver detalles");
        try{
            actor.attemptsTo(
                    WaitUntil.the(GestionPostulacionesPage.BTN_DETALLES,isVisible()).forNoMoreThan(20).seconds(),
                    WaitUntil.the(GestionPostulacionesPage.BTN_DETALLES,isClickable()).forNoMoreThan(20).seconds(),
                    Click.on(GestionPostulacionesPage.BTN_DETALLES)
            );
            System.out.println("Es visible los datos de la postulacion");

            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("No se pudo abrir la informacion"+e.getMessage());
        }
        try{
            actor.attemptsTo(
                    WaitUntil.the(GestionPostulacionesPage.BTN_CERRAR_DETALLES, isVisible()).forNoMoreThan(20).seconds(),
                    WaitUntil.the(GestionPostulacionesPage.BTN_CERRAR_DETALLES, isClickable()).forNoMoreThan(20).seconds(),
                    Click.on(GestionPostulacionesPage.BTN_CERRAR_DETALLES)
            );
            System.out.println("Se cerro el modal de detalles");
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("no se pudo cerrar el modal"+e.getMessage());
        }
    }
}
