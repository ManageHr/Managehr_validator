package co.com.Managehr.userinterface.Usuarios;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;

public class CambioEstadoPage extends PageObject {
    public static final Target TITULO_EXTERNO = Target.the("titulo de la tabla externo")
            .located(By.xpath("//*[@id=\"tituloTargetas2\"]/h3"));
    public static final Target INPUT_FILTRO_EXTERNO = Target.the("filtro por documento del usuario").
            located(By.xpath("//*[@id=\"tituloTargetasfiltro2\"]"));
    public static final Target BTN_EDITAR_ESTADO = Target.the("modal para editar el estado").
            located(By.xpath("/html/body/app-root/app-usuarios/div/div/div[2]/div[4]/table/tbody/tr/td[6]/button[2]"));
    public static final Target SELECT_ROL = Target.the("Select para seleccionar el rol").
            located(By.xpath("//*[@id=\"editarusuariosModal\"]/div/div/div[2]/form/div[4]/select"));
    public static final Target BTN_GUARDAR_CAMBIOS = Target.the("boton para guardar el usuario").
            located(By.xpath("//*[@id=\"editarusuariosModal\"]/div/div/div[2]/form/button[1]"));
    public static final Target REGISTRO_EXTERNO = Target.the("modal para editar el estado").
            located(By.xpath("/html/body/app-root/app-usuarios/div/div/div[2]/div[4]/table/tbody/tr[1]"));
    public static final Target INPUT_FILTRO_USUARIO = Target.the("modal para editar el estado").
            located(By.xpath("//*[@id=\"tituloTargetasfiltro1\"]/input"));
    public static final Target REGISTRO_INTERNO = Target.the("modal para editar el estado").
            located(By.xpath("/html/body/app-root/app-usuarios/div/div/div[2]/div[2]/table/tbody/tr[1]"));
    public static final Target TABLA_EXTERNOS = Target.the("Tabla externos").
            located(By.xpath("/html/body/app-root/app-usuarios/div/div/div[2]/div[4]/table/tbody"));
    public static final Target MODAL_ESTADO = Target.the("Modal estado").
            located(By.xpath("//*[@id=\"editarusuariosModal\"]/div/div"));
    public static final Target MODAL_CONFIRMACION = Target.the("modal de confirmacion").
            located(By.xpath("/html/body/div/div"));
    public static final Target BOTON_CERRAR_MODAL = Target.the("modal de confirmacion").
            located(By.xpath("/html/body/div/div/div[6]/button[1]"));
}
