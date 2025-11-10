package co.com.Managehr.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ContratosPage extends PageObject {

    public static final Target MENU_CONTRATOS = Target.the("Opción del menú Contratos")
            .located(By.xpath("//a[contains(.,'Contratos') or .//span[contains(.,'Contratos')]]"));

    public static final Target BTN_AGREGAR_CONTRATO = Target.the("Botón Agregar contrato")
            .located(By.xpath("//button[contains(.,'Agregar') and not(contains(.,'Filtro'))]"));

    public static final Target INPUT_NUMERO_DOCUMENTO = Target.the("Número de Documento")
            .located(By.xpath(
                    "//label[normalize-space()='Número de Documento']/following::input[1]"
            ));

    public static final Target SELECT_TIPO_CONTRATO = Target.the("Tipo de Contrato")
            .located(By.xpath(
                    "//label[normalize-space()='Tipo de Contrato']/following::select[1]"
            ));

    public static final Target SELECT_ESTADO = Target.the("Estado del contrato")
            .located(By.xpath(
                    "//label[normalize-space()='Estado']/following::select[1]"
            ));

    // === AQUÍ EL CAMBIO IMPORTANTE ===
    // NO usamos @placeholder porque en <input type='date'> el texto dd/mm/aaaa no es placeholder.
    public static final Target INPUT_FECHA_INGRESO = Target.the("Fecha de Ingreso")
            .located(By.xpath(
                    "//label[contains(normalize-space(),'Fecha Ingreso')]/following::input[1]"
            ));

    public static final Target INPUT_FECHA_FINAL = Target.the("Fecha de Finalización")
            .located(By.xpath(
                    "//label[contains(normalize-space(),'Fecha Finalización')]/following::input[1]"
            ));

    public static final Target SELECT_AREA = Target.the("Área")
            .located(By.xpath(
                    "//label[normalize-space()='Área']/following::select[1]"
            ));

    public static final Target SELECT_CARGO = Target.the("Cargo")
            .located(By.xpath(
                    "//label[normalize-space()='Cargo']/following::select[1]"
            ));

    public static final Target INPUT_DOCUMENTO_ADJUNTO = Target.the("Documento Adjunto")
            .located(By.xpath(
                    "//label[contains(.,'Documento Adjunto')]/following::input[@type='file'][1]"
            ));

    public static final Target BTN_GUARDAR_CONTRATO = Target.the("Botón Guardar Contrato")
            .located(By.xpath("//button[contains(.,'Guardar Contrato')]"));

    public static final Target FILA_CONTRATO_POR_DOCUMENTO = Target.the("Fila de contrato por documento")
            .locatedBy("//table//tr[td[2][normalize-space()='{0}']]");
}
