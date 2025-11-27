package co.com.Managehr.userinterface.HorasExtras;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormHorasExtra {

    public static final Target MENU_HORAS_EXTRA = Target.the("Menú Horas extra")
            .located(By.xpath("//nav//a[.//span[contains(normalize-space(.),'Horas extra')] or contains(@routerlink,'horas')]"));

    public static final Target FORM_CONTENEDOR = Target.the("Contenedor formulario horas extra")
            .located(By.xpath("//*[contains(.,'Formulario de Solicitud de Horas Extra')]/ancestor::*[self::section or self::div][1]"));

    public static final Target INPUT_DESCRIPCION = Target.the("Descripción")
            .located(By.xpath("//label[contains(normalize-space(.),'Descripción')]/following::textarea[1] | //textarea[@placeholder='Descripción' or @name='descripcion' or @id='descripcion' or @formcontrolname='descripcion']"));

    public static final Target INPUT_FECHA = Target.the("Fecha")
            .located(By.xpath("//input[@placeholder='dd/mm/aaaa' or @type='date' or @name='fecha' or @id='fecha' or @formcontrolname='fecha']"));

    public static final Target SELECT_TIPO = Target.the("Tipo de Hora Extra")
            .located(By.xpath("//label[contains(.,'Tipo de Hora Extra')]/following::select[1] | //select[@name='tipo' or @id='tipo' or @formcontrolname='tipo'] | //div[contains(@class,'ng-select')]"));

    public static final Target INPUT_CANTIDAD = Target.the("Cantidad de Horas")
            .located(By.xpath(
                    "//label[contains(.,'Cantidad de Horas')]/following::input[1] | " +
                            "//input[@type='number' or @name='cantidad' or @id='cantidad' or @formcontrolname='cantidad' or contains(@placeholder,'Cantidad')]"
            ));

    public static final Target BTN_ENVIAR = Target.the("Enviar Solicitud")
            .located(By.xpath("//button[@type='submit' or contains(normalize-space(.),'Enviar Solicitud')]"));

    public static final Target PANEL_SOLICITUDES = Target.the("Panel Solicitudes Enviadas")
            .located(By.xpath("//*[contains(normalize-space(.),'Solicitudes Enviadas')]/ancestor::*[self::aside or self::div][1]"));

    public static final Target ALERTA_EXITO = Target.the("Alerta/Toast éxito")
            .located(By.xpath("//*[@id=\"swal2-title\"]"));
    public static final Target BTN_EXITO = Target.the("Alerta/Toast éxito")
            .located(By.xpath("/html/body/div/div/div[6]/button[1]"));

    public static final Target MODAL_ERROR = Target.the("Modal de error de campos obligatorios")
            .located(By.xpath(
                    "//*[@id=\"swal2-title\"]"
            ));
    public static final Target BTN_ERROR = Target.the("Boton cerrar alerta de error ").
            located(By.xpath("/html/body/div/div/div[6]/button[1]"));























    public static final Target LISTADO_HORAS_EXTRA_ADMIN = Target.the("Listado de solicitudes de horas extra (vista admin)")
            .located(By.xpath("//table//thead//th[contains(normalize-space(.),'Nombre')]"));


    public static final Target BTN_CAMBIAR_ESTADO_PRIMERA_FILA_ADMIN = Target.the("Botón cambiar estado de la primera solicitud (admin)")
            .located(By.xpath("//table//tbody/tr[1]//button[contains(@class,'btn-warning') or contains(@title,'Estado')]"));




    public static final Target SELECT_ESTADO_MODAL_ADMIN = Target.the("Select 'Nuevo Estado' en el modal de horas extra (admin)")
            .located(By.xpath("//label[contains(normalize-space(.),'Nuevo Estado')]/following::select[1]"));


    public static final Target BTN_GUARDAR_CAMBIO_ESTADO_ADMIN = Target.the("Botón Guardar Cambios en el modal de horas extra (admin)")
            .located(By.xpath("//button[contains(normalize-space(.),'Guardar Cambios')]"));


    public static final Target BTN_ELIMINAR_PRIMERA_FILA_ADMIN = Target.the("Botón eliminar de la primera solicitud (admin)")
            .located(By.xpath("//table//tbody/tr[1]//button[contains(@class,'btn-danger') or contains(@title,'Eliminar')]"));


    public static final Target ALERTA_CONFIRM_ELIMINAR_ADMIN = Target.the("Alerta de confirmación de eliminación (admin)")
            .located(By.xpath("//*[contains(@class,'swal2-popup')]//*[contains(normalize-space(.),'¿Estás seguro?')]"));

    public static final Target BTN_CONFIRMAR_ELIMINAR_ADMIN = Target.the("Botón 'Sí, eliminar' en la alerta (admin)")
            .located(By.xpath("//button[contains(normalize-space(.),'Sí, eliminar')]"));


    public static final Target DOCUMENTO_PRIMERA_FILA_ADMIN = Target.the("Documento de la primera solicitud de horas extra (admin)")
            .located(By.xpath("//table//tbody/tr[1]/td[2]"));


    public static final Target ESTADO_SOLICITUD_POR_DOCUMENTO_ADMIN = Target.the("Estado de la solicitud de horas extra por documento (admin)")
            .locatedBy("//table//tbody/tr[td[2][normalize-space(text())='{0}']]/td[10]");

    public static final Target BTN_ELIMINAR_SOLICITUD_POR_DOCUMENTO_ADMIN = Target.the("Botón eliminar de la solicitud de horas extra por documento (admin)")
            .locatedBy("//table//tbody/tr[td[2][normalize-space(text())='{0}']]//button[contains(@class,'btn-danger') or .//i[contains(@class,'fa-trash')]]");





}
