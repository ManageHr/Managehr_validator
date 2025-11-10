package co.com.Managehr.questions;

import co.com.Managehr.userinterface.ContratosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionContrato implements Question<Boolean> {

    private final String documento;

    public ValidacionContrato(String documento) {
        this.documento = documento;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            return ContratosPage.FILA_CONTRATO_POR_DOCUMENTO.of(documento).resolveFor(actor).isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public static ValidacionContrato existeContratoConDocumento(String documento) {
        return new ValidacionContrato(documento);
    }
}
