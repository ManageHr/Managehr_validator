package co.com.Managehr.userinterface.Vacantes;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class CategoriasVacantesPage extends PageObject {


    public static final Target BTN_VACANTES = Target.the("Menú Vacantes")
            .located(By.xpath("//span[contains(normalize-space(.),'Vacantes')]"));

    public static final Target BTN_CATEGORIA = Target.the("Submenú Categoría de vacantes")
            .located(By.xpath("//span[contains(normalize-space(.),'Categoría')]"));


    public static final Target BTN_AGREGAR_CATEGORIA = Target.the("Botón Agregar Categoría")
            .located(By.xpath("//button[contains(normalize-space(.),'Agregar Categoría')]"));


    public static final Target INPUT_BUSCAR = Target.the("Campo de búsqueda por nombre de categoría")
            .located(By.xpath("//input[contains(@placeholder,'Buscar por Nombre')]"));


    public static final Target INPUT_NOMBRE = Target.the("Input nombre de categoría en el modal")
            .located(By.xpath("//input[@name='nomCategoria']"));


    public static final Target BTN_CONFIRMAR_AGREGAR = Target.the("Botón confirmar agregar categoría")
            .located(By.xpath("//div[@id='agregarCategoriaModal']//button[@type='submit']"));


    public static final Target BTN_GUARDAR_CAMBIOS = Target.the("Botón guardar cambios de categoría")
            .located(By.xpath("//div[@id='editarCategoriaModal']//button[@type='submit']"));


    public static final Target FILA_CATEGORIA = Target.the("Fila por nombre de categoría")
            .locatedBy("//table//tr[td[normalize-space()='{0}']]");

    public static final Target BTN_EDITAR = Target.the("Botón editar por nombre de categoría")
            .locatedBy("//table//tr[td[normalize-space()='{0}']]//button[contains(@class,'editar')]");


    public static final Target INPUT_NOMBRE_AGREGAR = Target.the("Input nombre de categoría en el modal Agregar")
            .located(By.xpath("//div[@id='agregarCategoriaModal']//input[contains(@class,'form-control')]"));


    public static final Target INPUT_NOMBRE_EDITAR = Target.the("Input nombre de categoría en el modal Editar")
            .located(By.xpath("//div[@id='editarCategoriaModal']//input[contains(@class,'form-control')]"));

    public static final Target BTN_ELIMINAR = Target.the("Botón eliminar por nombre de categoría")
            .locatedBy("//table//tr[td[normalize-space()='{0}']]//button[contains(@class,'eliminar')]");


    public static final Target ALERTA_SWEET = Target.the("Contenedor de SweetAlert")
            .located(By.cssSelector("div.swal2-container"));


    public static final Target BTN_ALERTA_OK = Target.the("Botón OK de SweetAlert")
            .located(By.cssSelector("button.swal2-confirm"));

    public static final Target BTN_CONFIRMAR_ELIMINAR = Target.the("Confirmar eliminar categoría")
            .located(By.cssSelector("button.swal2-confirm"));
}
