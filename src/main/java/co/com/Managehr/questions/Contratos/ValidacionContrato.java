package co.com.Managehr.questions.Contratos;

import co.com.Managehr.userinterface.Contratos.ContratosPage;
import co.com.Managehr.tasks.Contratos.CrearContrato;
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
            CrearContrato.usuarioNoExiste = false;
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
