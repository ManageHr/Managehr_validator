package co.com.Managehr.userinterface.Postulaciones;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class GestionPostulacionesPage extends PageObject {
    public static final Target TABLA_POSTULACIONES =Target.the("tabla postulaciones").
            located(By.xpath("/html/body/app-root/app-postulaciones/div/div/div[3]/table"));
    public static final Target INPUT_FILTRO = Target.the("campo de filtro").
            located(By.xpath("/html/body/app-root/app-postulaciones/div/div/div[2]/input"));
    public static final Target BTN_DETALLES = Target.the("boton de ver detalles").
            located(By.xpath("/html/body/app-root/app-postulaciones/div/div/div[3]/table/tbody/tr[3]/td[6]/button[1]"));
    public static final Target BTN_EDITAR_ESTADO = Target.the("botn de editar estado").
            located(By.xpath("/html/body/app-root/app-postulaciones/div/div/div[3]/table/tbody/tr[3]/td[6]/button[2]"));
    public static final Target BTN_PAGINATOR_SIGUIENTE = Target.the("boton de paginacion siguiente").
            located(By.xpath("/html/body/app-root/app-postulaciones/div/div/div[3]/nav/ul/li[3]/a"));
    public static final Target BTN_PAGINATOR_ANTERIOR = Target.the("boton de paginacion anterior").
            located(By.xpath("/html/body/app-root/app-postulaciones/div/div/div[3]/nav/ul/li[1]/a"));
    public static final Target BTN_CERRAR_DETALLES = Target.the("boton de cerrar modal de detalles").
            located(By.xpath("//*[@id=\"verDetallesModal\"]/div/div/div[1]/button"));
    public static final Target BTN_GUARDAR_ESTADO = Target.the("boton de guardar estado").
            located(By.xpath("//*[@id=\"editarEstadoModal\"]/div/div/div[2]/form/button"));
    public static final Target BTN_VACANTES = Target.the("botón vacantes")
            .located(By.xpath("//div[contains(@class,'nav-link')]//span[text()='Vacantes']"));
    public static final Target BTN_POSTULACIONES = Target.the("botón postulaciones")
            .located(By.xpath("//div[contains(@class,'submenu')]//a//span[text()='Postulaciones']"));
    public static final Target MODAL_EDITAR = Target.the("Modal editar estado").
            located(By.xpath("//*[@id=\"editarEstadoModal\"]/div/div"));
    public static final Target SELECT_ESTADO = Target.the("Estado para seleccionar").
            located(By.xpath("//*[@id=\"editarEstadoModal\"]/div/div/div[2]/form/select"));
}
