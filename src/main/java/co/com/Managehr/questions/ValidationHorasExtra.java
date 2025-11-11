package co.com.Managehr.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static co.com.Managehr.userinterface.FormHorasExtra.MODAL_ERROR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidationHorasExtra implements Question<String> {

    private final String tipoValidacion;

    private ValidationHorasExtra(String tipoValidacion) {
        this.tipoValidacion = tipoValidacion;
    }
    public static Question<String> modalErrorCamposObligatorios() {
        return new ValidationHorasExtra("error_campos");
    }

    public static Question<String> modalError() {
        return new ValidationHorasExtra("error");
    }

    @Override
    public String answeredBy(Actor actor) {
        try {
            if (MODAL_ERROR.resolveFor(actor).isVisible()) {
                String mensaje = Text.of(MODAL_ERROR).viewedBy(actor).asString();
                System.out.println("Mensaje de error capturado: " + mensaje);
                Thread.sleep(3000);
                return mensaje;
            } else {

                System.out.println("No hay mensaje de error visible");
                Thread.sleep(3000);
                return "No se encontró mensaje de error";
            }

        } catch (Exception e) {

            return "Error";
        }
    }
}