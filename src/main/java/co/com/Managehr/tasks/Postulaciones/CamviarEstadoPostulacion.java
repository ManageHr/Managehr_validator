package co.com.Managehr.tasks.Postulaciones;

import co.com.Managehr.userinterface.GestionPostulacionesPage;
import cucumber.api.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ISelect;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
public class CamviarEstadoPostulacion implements Task {
    private String select;

    public CamviarEstadoPostulacion(String select) {
        this.select = select;
    }
    public static CamviarEstadoPostulacion start(String estilo){
        return instrumented(CamviarEstadoPostulacion.class,estilo);
    }
    @Override
    public <T extends Actor> void performAs(T actor){
        try{
            actor.attemptsTo(
                    WaitUntil.the(GestionPostulacionesPage.SELECT_ESTADO,isVisible()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(GestionPostulacionesPage.SELECT_ESTADO, isClickable()).forNoMoreThan(10).seconds(),
                    SelectFromOptions.byVisibleText(select).from(GestionPostulacionesPage.SELECT_ESTADO)
            );
            Thread.sleep(300);
            System.out.println("Se cambio el estado a "+select);
        }catch (Exception e){
            System.out.println("No se pudo cambiar el estado "+e.getMessage());
        }
    }
}
