package co.com.Managehr.userinterface.Contratos;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class GestionContratosPage extends PageObject {

    public static final Target CAMPO_BUSQUEDA = Target.the("Campo de búsqueda por documento")
            .located(By.xpath("//input[@placeholder='Buscar por nombre, documento, area o cargo...']"));

    public static final Target TABLA_RESULTADOS = Target.the("Tabla de resultados")
            .located(By.xpath("//table[@class='table table-striped table-bordered table-hover']/tbody"));

    public static Target FILA_POR_DOCUMENTO(String documento) {
        return Target.the("Fila del documento " + documento)
                .located(By.xpath("//table[@class='table table-striped table-bordered table-hover']//td[text()='" + documento + "']/parent::tr"));
    }

    public static Target BOTON_ELIMINAR_EN_FILA(String documento) {
        return Target.the("Botón eliminar para documento " + documento)
                .located(By.xpath("//td[text()='" + documento + "']/parent::tr/td[10]/button[2]"));
    }

    public static final Target MENSAJE_TABLA_VACIA = Target.the("Mensaje cuando no hay resultados")
            .located(By.xpath("//table[@class='table table-striped table-bordered table-hover']/tbody//td[contains(text(),'No hay datos') or contains(text(),'vací')]"));


    public static final Target BTN_CERRAR_ALERTA_EXITO = Target.the("Cerrar alerta de exito")
            .located(By.xpath("/html/body/div/div/div[6]/button[1]"));
    public static final Target BOTON_OK_EXITO = Target.the("Botón 'OK' en alerta de éxito")
            .located(By.xpath("//div[@class='swal2-container']//button[contains(text(),'OK') or contains(text(),'Aceptar')]"));


    public static Target EXISTE_REGISTRO(String documento) {
        return Target.the("Registro con documento " + documento)
                .located(By.xpath("//table[@class='table table-striped table-bordered table-hover']//td[text()='" + documento + "']"));
    }

    public static final Target MENU_GESTION_CONTRATOS = Target.the("Menú Gestión de Contratos")
            .located(By.xpath("/html/body/app-root/app-contratos/app-menu/div/aside/nav/div[2]/a[2]"));
    public static final Target ALERTA_CONFIRMACION = Target.the("Alerta de confirmación de eliminación")
            .located(By.cssSelector(".swal2-popup.swal2-modal.swal2-show"));

    public static final Target ALERTA_CONFIRMACION_TITULO = Target.the("Título de alerta de confirmación")
            .located(By.cssSelector(".swal2-title"));

    public static final Target ALERTA_CONFIRMACION_MENSAJE = Target.the("Mensaje de alerta de confirmación")
            .located(By.cssSelector(".swal2-html-container"));

    // CORREGIR ESTE SELECTOR (tenía error de sintaxis):
    public static final Target BOTON_SI_CONFIRMAR = Target.the("Botón 'Sí' en alerta de confirmación")
            .located(By.xpath("//button[contains(@class,'swal2-confirm') and contains(text(),'Sí') or contains(text(),'Confirmar')]"));
    // SELECTORES CORREGIDOS:
    public static final Target ALERTA_EXITO = Target.the("Alerta de éxito después de eliminar")
            .located(By.xpath("//div[contains(@class,'swal2-icon-success')]"));

    public static final Target ALERTA_EXITO_CONTAINER = Target.the("Contenedor de alerta de éxito")
            .located(By.xpath("//div[contains(@class,'swal2-container')]"));

    public static final Target MENSAJE_EXITO = Target.the("Mensaje de éxito")
            .located(By.xpath("//h2[@id='swal2-title' and contains(text(),'Eliminado')]"));

    public static final Target TEXTO_EXITO = Target.the("Texto del cuerpo de éxito")
            .located(By.xpath("//div[@id='swal2-html-container']"));

    public static final Target BOTON_ACEPTAR_EXITO = Target.the("Botón 'Aceptar' en alerta de éxito")
            .located(By.xpath("//button[contains(@class,'swal2-confirm') and contains(text(),'Aceptar')]"));
}