package co.com.Managehr.tasks.Contratos;

import co.com.Managehr.models.Contratos.DatosContrato;
import co.com.Managehr.userinterface.Contratos.ContratosPage;
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
import java.io.File;
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearContrato implements Task {

    private final DatosContrato datos;


    public static boolean usuarioNoExiste = false;

    public CrearContrato(DatosContrato datos) {
        this.datos = datos;
    }

    public static CrearContrato conDatos(DatosContrato datos) {
        return instrumented(CrearContrato.class, datos);
    }

    private void esperar() {
        try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String rutaArchivo = "";
        if (datos.getArchivo() != null && !datos.getArchivo().trim().isEmpty()) {
            rutaArchivo = Paths.get("src", "test", "resources", "files", datos.getArchivo()).toAbsolutePath().toString();
        }

        actor.attemptsTo(
                Scroll.to(ContratosPage.MENU_CONTRATOS),
                WaitUntil.the(ContratosPage.MENU_CONTRATOS, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ContratosPage.MENU_CONTRATOS)
        );
        esperar();

        actor.attemptsTo(
                WaitUntil.the(ContratosPage.BTN_AGREGAR_CONTRATO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ContratosPage.BTN_AGREGAR_CONTRATO)
        );
        esperar();

        actor.attemptsTo(
                WaitUntil.the(ContratosPage.INPUT_NUMERO_DOCUMENTO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(datos.getDocumento()).into(ContratosPage.INPUT_NUMERO_DOCUMENTO),
                Hit.the(Keys.TAB).into(ContratosPage.INPUT_NUMERO_DOCUMENTO)
        );
        esperar();

        actor.attemptsTo(
                WaitUntil.the(ContratosPage.SELECT_TIPO_CONTRATO, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(datos.getTipoContrato()).from(ContratosPage.SELECT_TIPO_CONTRATO)
        );
        esperar();

        actor.attemptsTo(
                WaitUntil.the(ContratosPage.SELECT_ESTADO, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(datos.getEstado()).from(ContratosPage.SELECT_ESTADO)
        );
        esperar();

        if (datos.getFechaIngreso() != null && !datos.getFechaIngreso().trim().isEmpty()) {
            actor.attemptsTo(
                    Enter.theValue(datos.getFechaIngreso()).into(ContratosPage.INPUT_FECHA_INGRESO),
                    Hit.the(Keys.TAB).into(ContratosPage.INPUT_FECHA_INGRESO)
            );
            esperar();
        }

        if (datos.getFechaFinal() != null && !datos.getFechaFinal().trim().isEmpty()) {
            actor.attemptsTo(
                    Enter.theValue(datos.getFechaFinal()).into(ContratosPage.INPUT_FECHA_FINAL),
                    Hit.the(Keys.TAB).into(ContratosPage.INPUT_FECHA_FINAL)
            );
            esperar();
        }

        actor.attemptsTo(
                SelectFromOptions.byVisibleText(datos.getArea()).from(ContratosPage.SELECT_AREA),
                SelectFromOptions.byVisibleText(datos.getCargo()).from(ContratosPage.SELECT_CARGO)
        );
        esperar();

        if (!rutaArchivo.isEmpty()) {
            File archivo = new File(rutaArchivo);
            if (archivo.exists()) {
                ContratosPage.INPUT_DOCUMENTO_ADJUNTO.resolveFor(actor).sendKeys(archivo.getAbsolutePath());
            }
            esperar();
        }

        actor.attemptsTo(
                Scroll.to(ContratosPage.BTN_GUARDAR_CONTRATO),
                WaitUntil.the(ContratosPage.BTN_GUARDAR_CONTRATO, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(ContratosPage.BTN_GUARDAR_CONTRATO)
        );
        esperar();

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        try {
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".swal2-popup")));
            String titulo = "";
            try {
                WebElement tituloEl = popup.findElement(By.cssSelector(".swal2-title"));
                if (tituloEl != null) titulo = tituloEl.getText().trim();
            } catch (NoSuchElementException ignored) { }

            WebElement btnConfirm = popup.findElement(By.cssSelector(".swal2-confirm"));
            if (titulo.toLowerCase().contains("error")) {

                usuarioNoExiste = true;
                btnConfirm.click();
                System.out.println("VALIDACIÓN CONTRATOS: No se creó el contrato. Es necesario que exista el usuario en el sistema.");
            } else {

                usuarioNoExiste = false;

                btnConfirm.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".swal2-container")));

                try {
                    WebElement botonCerrar = wait.until(
                            ExpectedConditions.elementToBeClickable(By.xpath(
                                    "//div[contains(@class,'modal') and contains(@class,'show')]//button[@type='button' and (contains(@class,'btn-close') or contains(@class,'close'))]"
                            ))
                    );
                    botonCerrar.click();
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'modal') and contains(@class,'show')]")));
                } catch (Exception e) {
                    System.out.println("No fue posible cerrar el modal Agregar Contrato: " + e.getMessage());
                }

                try {
                    By buscadorLocator = By.xpath("//input[contains(@placeholder,'Buscar por nombre')]");
                    WebElement buscador = wait.until(ExpectedConditions.elementToBeClickable(buscadorLocator));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buscador);
                    buscador.clear();
                    buscador.sendKeys(datos.getDocumento());
                    buscador.sendKeys(Keys.ENTER);
                } catch (Exception e) {
                    System.out.println("No fue posible buscar el contrato por documento: " + e.getMessage());
                }
            }

        } catch (TimeoutException e) {
            System.out.println("No se detectó SweetAlert.");
        }

        esperar();
    }
}
