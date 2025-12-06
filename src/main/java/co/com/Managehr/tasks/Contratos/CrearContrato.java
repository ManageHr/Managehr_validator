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


        actor.attemptsTo(
                WaitUntil.the(ContratosPage.BTN_AGREGAR_CONTRATO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ContratosPage.BTN_AGREGAR_CONTRATO)
        );


        actor.attemptsTo(
                WaitUntil.the(ContratosPage.INPUT_NUMERO_DOCUMENTO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(datos.getDocumento()).into(ContratosPage.INPUT_NUMERO_DOCUMENTO),
                Hit.the(Keys.TAB).into(ContratosPage.INPUT_NUMERO_DOCUMENTO)
        );


        actor.attemptsTo(
                WaitUntil.the(ContratosPage.SELECT_TIPO_CONTRATO, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(datos.getTipoContrato()).from(ContratosPage.SELECT_TIPO_CONTRATO)
        );


        actor.attemptsTo(
                WaitUntil.the(ContratosPage.SELECT_ESTADO, isVisible()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText(datos.getEstado()).from(ContratosPage.SELECT_ESTADO)
        );


        if (datos.getFechaIngreso() != null && !datos.getFechaIngreso().trim().isEmpty()) {
            actor.attemptsTo(
                    Enter.theValue(datos.getFechaIngreso()).into(ContratosPage.INPUT_FECHA_INGRESO),
                    Hit.the(Keys.TAB).into(ContratosPage.INPUT_FECHA_INGRESO)
            );

        }

        if (datos.getFechaFinal() != null && !datos.getFechaFinal().trim().isEmpty()) {
            actor.attemptsTo(
                    Enter.theValue(datos.getFechaFinal()).into(ContratosPage.INPUT_FECHA_FINAL),
                    Hit.the(Keys.TAB).into(ContratosPage.INPUT_FECHA_FINAL)
            );

        }

        actor.attemptsTo(
                SelectFromOptions.byVisibleText(datos.getArea()).from(ContratosPage.SELECT_AREA),
                SelectFromOptions.byVisibleText(datos.getCargo()).from(ContratosPage.SELECT_CARGO)
        );


        if (!rutaArchivo.isEmpty()) {
            File archivo = new File(rutaArchivo);
            if (archivo.exists()) {
                ContratosPage.INPUT_DOCUMENTO_ADJUNTO.resolveFor(actor).sendKeys(archivo.getAbsolutePath());
            }

        }

        actor.attemptsTo(
                Scroll.to(ContratosPage.BTN_GUARDAR_CONTRATO),
                WaitUntil.the(ContratosPage.BTN_GUARDAR_CONTRATO, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(ContratosPage.BTN_GUARDAR_CONTRATO)
        );
        /*esperar();*/

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

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
                cerrarModalAgregarContrato(driver, wait);
               /* try {
                    By buscadorLocator = By.xpath("//input[contains(@placeholder,'Buscar por nombre')]");
                    WebElement buscador = wait.until(ExpectedConditions.elementToBeClickable(buscadorLocator));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buscador);
                    buscador.clear();
                    buscador.sendKeys(datos.getDocumento());
                    buscador.sendKeys(Keys.ENTER);
                } catch (Exception e) {
                    System.out.println("No fue posible buscar el contrato por documento: " + e.getMessage());
                }*/
            }

        } catch (TimeoutException e) {
            System.out.println("No se detectó SweetAlert.");
        }


    }
    private void cerrarModalAgregarContrato(WebDriver driver, WebDriverWait wait) {
        try {
            // Intentar método 1: Botón cerrar (X)
            try {
                WebElement botonCerrar = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//div[@id='agregarContratoModal']//button[@data-bs-dismiss='modal']")
                        )
                );
                botonCerrar.click();
                System.out.println("Modal cerrado con botón X");
                return;
            } catch (Exception e1) {
                // Continuar con siguiente método
            }

            // Intentar método 2: Botón Cancelar
            try {
                WebElement botonCancelar = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//div[@id='agregarContratoModal']//button[contains(text(),'Cancelar')]")
                        )
                );
                botonCancelar.click();
                System.out.println("Modal cerrado con botón Cancelar");
                return;
            } catch (Exception e2) {
                // Continuar con siguiente método
            }

            // Intentar método 3: Cerrar con JavaScript
            try {
                WebElement modal = driver.findElement(By.id("agregarContratoModal"));
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].classList.remove('show');" +
                                "arguments[0].style.display = 'none';" +
                                "document.body.classList.remove('modal-open');" +
                                "document.querySelector('.modal-backdrop')?.remove();",
                        modal
                );
                System.out.println("Modal cerrado con JavaScript");
                return;
            } catch (Exception e3) {
                // Continuar con siguiente método
            }

            // Intentar método 4: Presionar ESC
            try {
                WebElement modal = driver.findElement(By.id("agregarContratoModal"));
                modal.sendKeys(Keys.ESCAPE);
                System.out.println("Modal cerrado con ESC");
                return;
            } catch (Exception e4) {
                // Continuar con siguiente método
            }

            // Intentar método 5: Clic fuera del modal (en backdrop)
            try {
                WebElement backdrop = driver.findElement(By.cssSelector(".modal-backdrop.fade.show"));
                backdrop.click();
                System.out.println("Modal cerrado con clic en backdrop");
            } catch (Exception e5) {
                System.out.println("No se pudo cerrar el modal con ningún método");
            }

        } catch (Exception e) {
            System.out.println("Error al intentar cerrar modal: " + e.getMessage());
        }
    }
}
