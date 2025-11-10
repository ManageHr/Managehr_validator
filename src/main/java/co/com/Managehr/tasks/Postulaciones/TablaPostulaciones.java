package co.com.Managehr.tasks.Postulaciones;

import co.com.Managehr.userinterface.CrearUsuarioPage;
import co.com.Managehr.userinterface.GestionPostulacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
public class TablaPostulaciones implements Task {
    private String buscar;

    public TablaPostulaciones(String buscar) {
        this.buscar = buscar;
    }

    public static TablaPostulaciones filtrar(String dato) {
        return instrumented(TablaPostulaciones.class, dato);
    }
    @Override
    public <T extends Actor> void performAs(T actor){
        System.out.println("=====INICO DE FLUJO====");
        try{
            actor.attemptsTo(
                    WaitUntil.the(GestionPostulacionesPage.TABLA_POSTULACIONES, isVisible()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(GestionPostulacionesPage.INPUT_FILTRO, isVisible()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(GestionPostulacionesPage.INPUT_FILTRO, isClickable()).forNoMoreThan(10).seconds(),
                    Enter.theValue(buscar).into(GestionPostulacionesPage.INPUT_FILTRO)
            );
            Thread.sleep(3000);
            System.out.println("Se visualiza la tabla con el registro esperado");
        } catch (Exception e) {
            System.out.println("Se cerro el flujo con ERROR "+e.getMessage());
        }
    }
}
