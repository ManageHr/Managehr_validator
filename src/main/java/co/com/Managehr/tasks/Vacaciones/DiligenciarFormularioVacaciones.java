package co.com.Managehr.tasks.Vacaciones;


import co.com.Managehr.models.Vacaciones.FormularioVacaciones;
import co.com.Managehr.userinterface.Vacaciones.FormularioVacacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DiligenciarFormularioVacaciones implements Task {

    private final FormularioVacaciones datos;

    public DiligenciarFormularioVacaciones(FormularioVacaciones datos) {
        this.datos = datos;
    }

    public static DiligenciarFormularioVacaciones conDatos(FormularioVacaciones datos) {
        return instrumented(DiligenciarFormularioVacaciones.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(datos.getMotivo()).into(FormularioVacacionesPage.TXT_MOTIVO),
                Enter.theValue(datos.getFechaInicio()).into(FormularioVacacionesPage.TXT_FECHA_INICIO),
                Enter.theValue(datos.getFechaFin()).into(FormularioVacacionesPage.TXT_FECHA_FIN),
                Click.on(FormularioVacacionesPage.BTN_ENVIAR_SOLICITUD)
        );
    }
}
