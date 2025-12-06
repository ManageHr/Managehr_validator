package co.com.Managehr.questions.Contratos;

import co.com.Managehr.userinterface.Contratos.ContratosPage;
import co.com.Managehr.tasks.Contratos.CrearContrato;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
public class ValidacionContrato implements Question<Boolean> {

    private final String documento;

    public ValidacionContrato(String documento) {
        this.documento = documento;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        if (CrearContrato.usuarioNoExiste) {
            CrearContrato.usuarioNoExiste = false;
            return true;
        }


        try {

            actor.attemptsTo(
                    WaitUntil.the(ContratosPage.CAMPO_BUSQUEDA, isVisible()).forNoMoreThan(3).seconds(),
                    Clear.field(ContratosPage.CAMPO_BUSQUEDA),
                    Enter.theValue(documento).into(ContratosPage.CAMPO_BUSQUEDA),
                    Hit.the(Keys.ENTER).into(ContratosPage.CAMPO_BUSQUEDA),
                    WaitUntil.angularRequestsHaveFinished()
            );

            return ContratosPage.FILA_CONTRATO_POR_DOCUMENTO
                    .of(documento)
                    .resolveFor(actor)
                    .isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public static ValidacionContrato existeContratoConDocumento(String documento) {
        return new ValidacionContrato(documento);
    }
}
