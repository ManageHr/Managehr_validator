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
import org.openqa.selenium.Keys;
import java.io.File;

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


        String rutaArchivo = "";
        if (datos.getArchivo() != null && !datos.getArchivo().trim().isEmpty()) {
            rutaArchivo = Paths.get("src", "test", "resources", "files", datos.getArchivo())
                    .toAbsolutePath()
                    .toString();
        }


        actor.attemptsTo(
                Scroll.to(ContratosPage.MENU_CONTRATOS),
                WaitUntil.the(ContratosPage.MENU_CONTRATOS, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ContratosPage.MENU_CONTRATOS),

                WaitUntil.the(ContratosPage.BTN_AGREGAR_CONTRATO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ContratosPage.BTN_AGREGAR_CONTRATO),


                WaitUntil.the(ContratosPage.INPUT_NUMERO_DOCUMENTO, isVisible()).forNoMoreThan(10).seconds()
        );


        actor.attemptsTo(
                Scroll.to(ContratosPage.INPUT_NUMERO_DOCUMENTO),
                Click.on(ContratosPage.INPUT_NUMERO_DOCUMENTO),
                Enter.theValue(datos.getDocumento()).into(ContratosPage.INPUT_NUMERO_DOCUMENTO),
                Hit.the(Keys.TAB).into(ContratosPage.INPUT_NUMERO_DOCUMENTO)
        );


        actor.attemptsTo(
                Scroll.to(ContratosPage.SELECT_TIPO_CONTRATO),
                WaitUntil.the(ContratosPage.SELECT_TIPO_CONTRATO, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(datos.getTipoContrato()).from(ContratosPage.SELECT_TIPO_CONTRATO),
                Hit.the(Keys.TAB).into(ContratosPage.SELECT_TIPO_CONTRATO)
        );


        actor.attemptsTo(
                Scroll.to(ContratosPage.SELECT_ESTADO),
                WaitUntil.the(ContratosPage.SELECT_ESTADO, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(datos.getEstado()).from(ContratosPage.SELECT_ESTADO),
                Hit.the(Keys.TAB).into(ContratosPage.SELECT_ESTADO)
        );


        if (datos.getFechaIngreso() != null && !datos.getFechaIngreso().trim().isEmpty()) {
            actor.attemptsTo(
                    Scroll.to(ContratosPage.INPUT_FECHA_INGRESO),
                    WaitUntil.the(ContratosPage.INPUT_FECHA_INGRESO, isVisible()).forNoMoreThan(5).seconds(),
                    Click.on(ContratosPage.INPUT_FECHA_INGRESO),
                    Enter.theValue(datos.getFechaIngreso()).into(ContratosPage.INPUT_FECHA_INGRESO),
                    Hit.the(Keys.TAB).into(ContratosPage.INPUT_FECHA_INGRESO)
            );
        }


        if (datos.getFechaFinal() != null && !datos.getFechaFinal().trim().isEmpty()) {
            actor.attemptsTo(
                    Scroll.to(ContratosPage.INPUT_FECHA_FINAL),
                    WaitUntil.the(ContratosPage.INPUT_FECHA_FINAL, isVisible()).forNoMoreThan(5).seconds(),
                    Click.on(ContratosPage.INPUT_FECHA_FINAL),
                    Enter.theValue(datos.getFechaFinal()).into(ContratosPage.INPUT_FECHA_FINAL),
                    Hit.the(Keys.TAB).into(ContratosPage.INPUT_FECHA_FINAL)
            );
        }


        actor.attemptsTo(
                Scroll.to(ContratosPage.SELECT_AREA),
                WaitUntil.the(ContratosPage.SELECT_AREA, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(datos.getArea()).from(ContratosPage.SELECT_AREA),

                Scroll.to(ContratosPage.SELECT_CARGO),
                WaitUntil.the(ContratosPage.SELECT_CARGO, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(datos.getCargo()).from(ContratosPage.SELECT_CARGO)
        );


        if (!rutaArchivo.isEmpty()) {
            File archivo = new File(rutaArchivo);
            System.out.println("Ruta archivo adjunto: " + archivo.getAbsolutePath()
                    + " - existe? " + archivo.exists());

            if (archivo.exists()) {

                actor.attemptsTo(
                        Scroll.to(ContratosPage.INPUT_DOCUMENTO_ADJUNTO)
                );

                ContratosPage.INPUT_DOCUMENTO_ADJUNTO
                        .resolveFor(actor)
                        .sendKeys(archivo.getAbsolutePath());
            } else {
                System.out.println("⚠ NO EXISTE el archivo adjunto: " + archivo.getAbsolutePath());
            }
        }


        actor.attemptsTo(
                Scroll.to(ContratosPage.BTN_GUARDAR_CONTRATO),
                WaitUntil.the(ContratosPage.BTN_GUARDAR_CONTRATO, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(ContratosPage.BTN_GUARDAR_CONTRATO)
        );


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
