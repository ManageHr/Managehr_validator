package co.com.Managehr.tasks.Postulaciones;

import co.com.Managehr.userinterface.Postulaciones.GestionPostulacionesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
public class AbrirPostulaciones implements Task {
    private String seccion;
    private String opcion;

    public AbrirPostulaciones(String seccion, String opcion) {
        this.seccion = seccion;
        this.opcion = opcion;
    }

    public static AbrirPostulaciones abrir() {
        return instrumented(AbrirPostulaciones.class, "co/com/Managehr/models/Vacantes ","Gestion");
    }

    public static AbrirPostulaciones enSeccion(String seccion, String opcion) {
        return instrumented(AbrirPostulaciones.class, seccion, opcion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("=== NAVEGACIÓN CON SELECTORES EXACTOS ===");

        try {
            boolean vacantesExiste = GestionPostulacionesPage.BTN_VACANTES.resolveFor(actor).isPresent();
            System.out.println("¿Vacantes existe?: " + vacantesExiste);

            if (vacantesExiste) {
                actor.attemptsTo(
                        WaitUntil.the(GestionPostulacionesPage.BTN_VACANTES, isVisible()).forNoMoreThan(10).seconds(),
                        WaitUntil.the(GestionPostulacionesPage.BTN_VACANTES, isClickable()).forNoMoreThan(10).seconds(),
                        Click.on(GestionPostulacionesPage.BTN_VACANTES)
                );
                System.out.println("Clic en Vacantes exitoso");
            } else {


                actor.attemptsTo(
                        WaitUntil.the(GestionPostulacionesPage.BTN_VACANTES, isVisible()).forNoMoreThan(5).seconds(),
                        Click.on(GestionPostulacionesPage.BTN_VACANTES)
                );

            }


            Thread.sleep(2000);

            boolean postulacionesExiste = GestionPostulacionesPage.BTN_POSTULACIONES.resolveFor(actor).isPresent();
            System.out.println("¿Postulaciones existe?: " + postulacionesExiste);

            if (postulacionesExiste) {
                actor.attemptsTo(
                        WaitUntil.the(GestionPostulacionesPage.BTN_POSTULACIONES, isVisible()).forNoMoreThan(10).seconds(),
                        WaitUntil.the(GestionPostulacionesPage.BTN_POSTULACIONES, isClickable()).forNoMoreThan(10).seconds(),
                        Click.on(GestionPostulacionesPage.BTN_POSTULACIONES)
                );
            } else {
                actor.attemptsTo(
                        WaitUntil.the(GestionPostulacionesPage.BTN_POSTULACIONES, isVisible()).forNoMoreThan(5).seconds(),
                        Click.on(GestionPostulacionesPage.BTN_POSTULACIONES)
                );
            }
            Thread.sleep(3000);

            System.out.println("Navegación completada exitosamente");

        } catch (Exception e) {
            System.out.println("Error durante la navegación: " + e.getMessage());
            throw new RuntimeException("Fallo en navegación: " + e.getMessage(), e);
        }
    }
}
