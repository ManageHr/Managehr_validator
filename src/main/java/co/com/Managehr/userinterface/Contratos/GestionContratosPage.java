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
                .located(By.xpath("//table[@class='table table-striped table-bordered table-hover']//td[text()='" + documento + "']/parent::tr//button[contains(@class,'eliminar')]"));
    }

    public static final Target MENSAJE_TABLA_VACIA = Target.the("Mensaje cuando no hay resultados")
            .located(By.xpath("//table[@class='table table-striped table-bordered table-hover']/tbody//td[contains(text(),'No hay datos') or contains(text(),'vací')]"));

    public static final Target ALERTA_CONFIRMACION = Target.the("Alerta de confirmación de eliminación")
            .located(By.xpath("//div[@class='swal2-container']//div[@class='swal2-html-container']"));

    public static final Target BOTON_SI_CONFIRMAR = Target.the("Botón 'Sí' en alerta de confirmación")
            .located(By.xpath("//div[@class='swal2-container']//button[contains(text(),'Sí') or contains(text(),'Confirmar')]"));

    public static final Target ALERTA_EXITO = Target.the("Alerta de éxito después de eliminar")
            .located(By.xpath("//div[@class='swal2-container']//div[contains(@class,'swal2-success') or contains(text(),'éxito')]"));

    public static final Target BOTON_OK_EXITO = Target.the("Botón 'OK' en alerta de éxito")
            .located(By.xpath("//div[@class='swal2-container']//button[contains(text(),'OK') or contains(text(),'Aceptar')]"));

    public static final Target MENSAJE_EXITO = Target.the("Mensaje de éxito")
            .located(By.xpath("//div[@class='swal2-container']//h2[contains(text(),'Éxito') or contains(text(),'Success')]"));

    public static Target EXISTE_REGISTRO(String documento) {
        return Target.the("Registro con documento " + documento)
                .located(By.xpath("//table[@class='table table-striped table-bordered table-hover']//td[text()='" + documento + "']"));
    }

    public static final Target MENU_GESTION_CONTRATOS = Target.the("Menú Gestión de Contratos")
            .located(By.xpath("/html/body/app-root/app-contratos/app-menu/div/aside/nav/div[2]/a[2]"));
}