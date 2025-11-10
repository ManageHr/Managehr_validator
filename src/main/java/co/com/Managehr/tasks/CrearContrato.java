package co.com.Managehr.tasks;

import co.com.Managehr.models.DatosContrato;
import co.com.Managehr.userinterface.ContratosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearContrato implements Task {

    private final DatosContrato datos;

    public CrearContrato(DatosContrato datos) {
        this.datos = datos;
    }

    public static CrearContrato conDatos(DatosContrato datos) {
        return instrumented(CrearContrato.class, datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Ruta del archivo adjunto (si viene en el feature)
        String rutaArchivo = "";
        if (datos.getArchivo() != null && !datos.getArchivo().trim().isEmpty()) {
            rutaArchivo = Paths.get("src", "test", "resources", "files", datos.getArchivo())
                    .toAbsolutePath().toString();
        }

        actor.attemptsTo(
                // Ir al módulo de contratos
                Click.on(ContratosPage.MENU_CONTRATOS),

                // Abrir modal "Agregar Contrato"
                WaitUntil.the(ContratosPage.BTN_AGREGAR_CONTRATO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ContratosPage.BTN_AGREGAR_CONTRATO),

                // Esperar que el modal esté visible
                WaitUntil.the(ContratosPage.BTN_GUARDAR_CONTRATO, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(ContratosPage.INPUT_NUMERO_DOCUMENTO),

                // Número de documento
                Enter.theValue(datos.getDocumento()).into(ContratosPage.INPUT_NUMERO_DOCUMENTO),
                // Disparar blur/onchange
                Hit.the(Keys.TAB).into(ContratosPage.INPUT_NUMERO_DOCUMENTO),

                // Tipo de contrato
                Scroll.to(ContratosPage.SELECT_TIPO_CONTRATO),
                WaitUntil.the(ContratosPage.SELECT_TIPO_CONTRATO, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(datos.getTipoContrato()).from(ContratosPage.SELECT_TIPO_CONTRATO),
                // Salir del combo
                Hit.the(Keys.TAB).into(ContratosPage.SELECT_TIPO_CONTRATO),

                // Estado
                Scroll.to(ContratosPage.SELECT_ESTADO),
                WaitUntil.the(ContratosPage.SELECT_ESTADO, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(datos.getEstado()).from(ContratosPage.SELECT_ESTADO),
                Hit.the(Keys.TAB).into(ContratosPage.SELECT_ESTADO)
        );

        // ==============
        // FECHA INGRESO
        // ==============
        if (datos.getFechaIngreso() != null && !datos.getFechaIngreso().trim().isEmpty()) {
            actor.attemptsTo(
                    Scroll.to(ContratosPage.INPUT_FECHA_INGRESO),
                    WaitUntil.the(ContratosPage.INPUT_FECHA_INGRESO, isVisible()).forNoMoreThan(5).seconds()
            );

            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            WebElement inputFechaIngreso = ContratosPage.INPUT_FECHA_INGRESO.resolveFor(actor);

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].value = arguments[1];" +
                            "arguments[0].dispatchEvent(new Event('input', {bubbles:true}));" +
                            "arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
                    inputFechaIngreso,
                    datos.getFechaIngreso()
            );
        }

        // =====================
        // FECHA FINALIZACIÓN
        // =====================
        if (datos.getFechaFinal() != null && !datos.getFechaFinal().trim().isEmpty()) {
            actor.attemptsTo(
                    Scroll.to(ContratosPage.INPUT_FECHA_FINAL),
                    WaitUntil.the(ContratosPage.INPUT_FECHA_FINAL, isVisible()).forNoMoreThan(5).seconds()
            );

            WebDriver driver = BrowseTheWeb.as(actor).getDriver();
            WebElement inputFechaFinal = ContratosPage.INPUT_FECHA_FINAL.resolveFor(actor);

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].value = arguments[1];" +
                            "arguments[0].dispatchEvent(new Event('input', {bubbles:true}));" +
                            "arguments[0].dispatchEvent(new Event('change', {bubbles:true}));",
                    inputFechaFinal,
                    datos.getFechaFinal()
            );
        }

        // Área
        actor.attemptsTo(
                Scroll.to(ContratosPage.SELECT_AREA),
                WaitUntil.the(ContratosPage.SELECT_AREA, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(datos.getArea()).from(ContratosPage.SELECT_AREA),

                // Cargo
                Scroll.to(ContratosPage.SELECT_CARGO),
                WaitUntil.the(ContratosPage.SELECT_CARGO, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(datos.getCargo()).from(ContratosPage.SELECT_CARGO)
        );

        // Documento adjunto (solo si se configuró)
        if (!rutaArchivo.isEmpty()) {
            actor.attemptsTo(
                    Scroll.to(ContratosPage.INPUT_DOCUMENTO_ADJUNTO),
                    Enter.theValue(rutaArchivo).into(ContratosPage.INPUT_DOCUMENTO_ADJUNTO)
            );
        }

        // Guardar contrato
        actor.attemptsTo(
                Scroll.to(ContratosPage.BTN_GUARDAR_CONTRATO),
                WaitUntil.the(ContratosPage.BTN_GUARDAR_CONTRATO, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(ContratosPage.BTN_GUARDAR_CONTRATO)
        );

        // Pequeña espera para que se actualice la tabla
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
