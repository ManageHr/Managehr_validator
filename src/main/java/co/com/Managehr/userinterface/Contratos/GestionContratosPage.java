package co.com.Managehr.userinterface.Contratos;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class GestionContratosPage extends PageObject {

    public static final Target CAMPO_BUSQUEDA = Target.the("Campo de búsqueda por documento")
            .located(By.xpath("//input[@placeholder='Buscar por nombre, documento, area o cargo...']"));

    public static final Target TABLA_RESULTADOS = Target.the("Tabla de resultados")
            .located(By.xpath("//table[@class='table table-striped table-bordered table-hover']/tbody"));


    public static Target EXISTE_REGISTRO(String documento) {
        return Target.the("Registro con documento " + documento)
                .located(By.xpath("//table[@class='table table-striped table-bordered table-hover']//td[text()='" + documento + "']"));
    }
    public static final Target ALERTA_CONFIRMACION = Target.the("Alerta de confirmación de eliminación")
            .located(By.cssSelector(".swal2-popup.swal2-modal.swal2-show"));
    public static final Target BOTON_SI_CONFIRMAR = Target.the("Botón 'Sí' en alerta de confirmación")
            .located(By.xpath("//button[contains(@class,'swal2-confirm') and contains(text(),'Sí') or contains(text(),'Confirmar')]"));

    public static final Target ALERTA_EXITO_CONTAINER = Target.the("Contenedor de alerta de éxito")
            .located(By.xpath("//div[contains(@class,'swal2-container')]"));
    public static final Target TEXTO_EXITO = Target.the("Texto del cuerpo de éxito")
            .located(By.xpath("//div[@id='swal2-html-container']"));

    public static final Target BOTON_ACEPTAR_EXITO = Target.the("Botón 'Aceptar' en alerta de éxito")
            .located(By.xpath("//button[contains(@class,'swal2-confirm') and contains(text(),'Aceptar')]"));
}