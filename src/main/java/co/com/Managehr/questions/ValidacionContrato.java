package co.com.Managehr.questions;

import co.com.Managehr.userinterface.ContratosPage;
import co.com.Managehr.tasks.CrearContrato;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidacionContrato implements Question<Boolean> {

    private final String documento;

    public ValidacionContrato(String documento) {
        this.documento = documento;
    }

    @Override
    public Boolean answeredBy(Actor actor) {


        if (CrearContrato.usuarioNoExiste) {
            CrearContrato.usuarioNoExiste = false; // limpiar para futuros tests
            return true;
        }

        try {
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
