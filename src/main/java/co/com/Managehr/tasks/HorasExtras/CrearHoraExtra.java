package co.com.Managehr.tasks.HorasExtras;

import co.com.Managehr.models.HorasExtras.HorasExtraUsuario;
import co.com.Managehr.userinterface.HorasExtras.FormHorasExtra;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class CrearHoraExtra implements Task {

    private final HorasExtraUsuario data;
    private final boolean esEscenarioExitoso;

    public CrearHoraExtra(HorasExtraUsuario data, boolean esEscenarioExitoso) {
        this.data = data;
        this.esEscenarioExitoso = esEscenarioExitoso;
    }

    public static CrearHoraExtra con(HorasExtraUsuario data){
        return Tasks.instrumented(CrearHoraExtra.class, data, true);
    }

    public static CrearHoraExtra conDatosIncompletos(HorasExtraUsuario data){
        return Tasks.instrumented(CrearHoraExtra.class, data, false);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       try{
           if (esEscenarioExitoso) {
               llenarFormularioCompleto(actor);
               actor.attemptsTo(

                       WaitUntil.the(FormHorasExtra.ALERTA_EXITO,isVisible()).forNoMoreThan(10).seconds(),
                       WaitUntil.the(FormHorasExtra.BTN_EXITO,isVisible()).forNoMoreThan(10).seconds(),
                       WaitUntil.the(FormHorasExtra.BTN_EXITO,isClickable()).forNoMoreThan(10).seconds(),
                       Click.on(FormHorasExtra.BTN_EXITO)
               );
               Thread.sleep(3000);
               System.out.printf("Se cerro el modal de alerta");
           } else {
               llenarFormularioIncompleto(actor);

           }

       } catch (Exception e) {
           System.out.printf("Error no encontro el menu");
       }


    }
    private void llenarFormularioCompleto(Actor actor) {
        actor.attemptsTo(
                Scroll.to(FormHorasExtra.INPUT_DESCRIPCION),
                Click.on(FormHorasExtra.INPUT_DESCRIPCION),
                Clear.field(FormHorasExtra.INPUT_DESCRIPCION),
                Enter.theValue(data.getDescripcion()).into(FormHorasExtra.INPUT_DESCRIPCION),

                Scroll.to(FormHorasExtra.INPUT_FECHA),
                Click.on(FormHorasExtra.INPUT_FECHA),
                Clear.field(FormHorasExtra.INPUT_FECHA),
                Enter.theValue(data.getFecha()).into(FormHorasExtra.INPUT_FECHA),

                Scroll.to(FormHorasExtra.SELECT_TIPO),
                SelectFromOptions.byValue(String.valueOf(data.getTipo())).from(FormHorasExtra.SELECT_TIPO),

                Scroll.to(FormHorasExtra.INPUT_CANTIDAD),
                Click.on(FormHorasExtra.INPUT_CANTIDAD),
                Clear.field(FormHorasExtra.INPUT_CANTIDAD),
                Enter.theValue(String.valueOf(data.getCantidad())).into(FormHorasExtra.INPUT_CANTIDAD),
                WaitUntil.the(FormHorasExtra.BTN_ENVIAR,isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(FormHorasExtra.BTN_ENVIAR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(FormHorasExtra.BTN_ENVIAR)
        );
    }
    private void llenarFormularioIncompleto(Actor actor) {
        actor.attemptsTo(
                Scroll.to(FormHorasExtra.INPUT_FECHA),
                Click.on(FormHorasExtra.INPUT_FECHA),
                Clear.field(FormHorasExtra.INPUT_FECHA),
                Enter.theValue(data.getFecha()).into(FormHorasExtra.INPUT_FECHA),

                Scroll.to(FormHorasExtra.SELECT_TIPO),
                SelectFromOptions.byValue(String.valueOf(data.getTipo())).from(FormHorasExtra.SELECT_TIPO),

                Scroll.to(FormHorasExtra.INPUT_CANTIDAD),
                Click.on(FormHorasExtra.INPUT_CANTIDAD),
                Clear.field(FormHorasExtra.INPUT_CANTIDAD),
                Enter.theValue(String.valueOf(data.getCantidad())).into(FormHorasExtra.INPUT_CANTIDAD),
                WaitUntil.the(FormHorasExtra.BTN_ENVIAR,isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(FormHorasExtra.BTN_ENVIAR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(FormHorasExtra.BTN_ENVIAR)
        );
    }

}