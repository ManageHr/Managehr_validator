package co.com.Managehr.tasks.Usuarios;

import co.com.Managehr.userinterface.Usuarios.CrearUsuarioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class CompletarFlujoUsuario implements Task {

    private String documentoBusqueda;

    public CompletarFlujoUsuario(String documentoBusqueda) {
        this.documentoBusqueda = documentoBusqueda;
    }

    public static CompletarFlujoUsuario conDocumento(String documento) {
        return instrumented(CompletarFlujoUsuario.class, documento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("=== INICIANDO FLUJO COMPLETO ===");

        try {
            System.out.println("Buscando en filtro por documento: " + documentoBusqueda);
            actor.attemptsTo(
                    WaitUntil.the(CrearUsuarioPage.FILTRO_USUARIOS_INPUT, isVisible()).forNoMoreThan(15).seconds(),
                    WaitUntil.the(CrearUsuarioPage.FILTRO_USUARIOS_INPUT, isClickable()).forNoMoreThan(15).seconds(),
                    Enter.theValue("").into(CrearUsuarioPage.FILTRO_USUARIOS_INPUT),
                    Enter.theValue(documentoBusqueda).into(CrearUsuarioPage.FILTRO_USUARIOS_INPUT)
            );
            Thread.sleep(3000);
            System.out.println("Espera de filtrado completada");

        } catch (Exception e) {
            System.out.println("Error en la búsqueda por filtro: " + e.getMessage());
        }

        System.out.println("=== FLUJO COMPLETO FINALIZADO ===");
    }
}