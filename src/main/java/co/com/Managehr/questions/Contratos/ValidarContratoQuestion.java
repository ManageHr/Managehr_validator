package co.com.Managehr.questions.Contratos;

import co.com.Managehr.userinterface.Contratos.GestionContratosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidarContratoQuestion {

    public static Question<Boolean> contratoExiste(String documento) {
        return Question.about("Verificar si el contrato existe")
                .answeredBy(actor -> {
                    actor.attemptsTo(
                            WaitUntil.the(GestionContratosPage.EXISTE_REGISTRO(documento), isVisible())
                                    .forNoMoreThan(5).seconds()
                    );
                    return GestionContratosPage.EXISTE_REGISTRO(documento).resolveFor(actor).isVisible();
                });
    }

    public static Question<Boolean> tablaEstaVacia() {
        return Question.about("Verificar si la tabla está vacía")
                .answeredBy(actor -> {
                    try {

                        int numeroDeFilas = contarRegistrosEnTabla().answeredBy(actor);

                        return numeroDeFilas == 0;

                    } catch (Exception e) {
                        return false;
                    }
                });
    }

    public static Question<Boolean> noExisteRegistroConDocumento(String documento) {
        return Question.about("Verificar que no existe registro con documento")
                .answeredBy(actor -> {
                    try {


                        return !GestionContratosPage.EXISTE_REGISTRO(documento).resolveFor(actor).isVisible();
                    } catch (Exception e) {
                        return true;
                    }
                });
    }

    public static Question<String> mensajeAlertaExito() {
        return Question.about("Obtener mensaje de alerta de éxito")
                .answeredBy(actor -> {
                    actor.attemptsTo(
                            WaitUntil.the(GestionContratosPage.ALERTA_EXITO_CONTAINER, isVisible())
                                    .forNoMoreThan(10).seconds()
                    );

                    return Text.of(GestionContratosPage.TEXTO_EXITO)
                            .viewedBy(actor).asString().trim();
                });
    }

    public static Question<Boolean> alertaConfirmacionEsVisible(String tituloEsperado) {
        return Question.about("Verificar alerta de confirmación")
                .answeredBy(actor -> {
                    actor.attemptsTo(
                            WaitUntil.the(GestionContratosPage.ALERTA_CONFIRMACION, isVisible())
                                    .forNoMoreThan(5).seconds()
                    );
                    String tituloActual = Text.of(GestionContratosPage.ALERTA_CONFIRMACION).viewedBy(actor).asString();
                    return tituloActual.contains(tituloEsperado);
                });
    }

    public static Question<Integer> contarRegistrosEnTabla() {
        return Question.about("Contar registros en la tabla")
                .answeredBy(actor -> {
                    return GestionContratosPage.TABLA_RESULTADOS.resolveFor(actor)
                            .findElements(org.openqa.selenium.By.tagName("tr"))
                            .size();
                });
    }


}