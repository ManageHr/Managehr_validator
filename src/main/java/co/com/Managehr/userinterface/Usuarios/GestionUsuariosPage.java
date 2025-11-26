package co.com.Managehr.userinterface.Usuarios;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GestionUsuariosPage extends PageObject {
    public static final Target INPUT_FILTRO_INTERNO = Target.the("filtro por documento de usuario interno")
            .located(By.xpath("//input[@placeholder='Buscar por nombre o Numero de documento...']"));

    public static final Target REGISTRO_INTERNO = Target.the("primer registro de tabla interna")
            .located(By.xpath("//table[.//th[contains(text(),'Nombre')]]/tbody/tr[1]"));

    public static final Target TABLA_INTERNOS = Target.the("Tabla internos")
            .located(By.xpath("//table[.//th[contains(text(),'Nombre')]]/tbody"));
    public static final Target BTN_DETALLES = Target.the("botón de detalles del usuario")
            .located(By.xpath("//button[contains(@class,'btn-acciones')]//i[contains(@class,'fa-user-shield')]"));
    public static final Target BTN_ELIMINAR = Target.the("botón eliminar usuario")
            .located(By.xpath("//button[contains(@class,'btn-acciones') and contains(@class,'eliminar')]"));
    public static final Target MODAL_DETALLES = Target.the("modal de detalles del usuario")
            .located(By.xpath("//div[contains(@class,'modal')]//h5[contains(text(),'Detalles del Usuario')]"));

    public static final Target TEXTO_ROL_DETALLES = Target.the("texto del rol en detalles")
            .located(By.xpath("//div[contains(@class,'modal-body')]//p[contains(.,'Rol:')]"));

    public static final Target BTN_CERRAR_DETALLES = Target.the("botón cerrar modal detalles")
            .located(By.xpath("//div[contains(@class,'modal')]//button[contains(@class,'btn-close')]"));
    public static final Target MODAL_CONFIRMAR_ELIMINACION = Target.the("modal de confirmación eliminación")
            .located(By.xpath("//div[contains(@class,'swal2-popup') and contains(.,'eliminar')]"));

    public static final Target BTN_CONFIRMAR_ELIMINAR = Target.the("botón confirmar eliminación")
            .located(By.xpath("//div[contains(@class,'swal2-popup')]//button[contains(.,'Sí') or contains(.,'Confirmar') or contains(.,'Eliminar')]"));

    public static final Target SWEETALERT_EXITO = Target.the("SweetAlert de éxito")
            .located(By.xpath("//div[contains(@class,'swal2-popup') and contains(.,'éxito') or contains(.,'exito') or contains(.,'success') or contains(.,'eliminado')]"));

    public static final Target BTN_CERRAR_SWEETALERT = Target.the("botón cerrar SweetAlert")
            .located(By.xpath("//div[contains(@class,'swal2-popup')]//button[contains(@class,'swal2-confirm') or contains(.,'OK') or contains(.,'Aceptar') or contains(.,'Cerrar')]"));
}