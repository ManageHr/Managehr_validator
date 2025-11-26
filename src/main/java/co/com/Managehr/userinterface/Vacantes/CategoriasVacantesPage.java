package co.com.Managehr.userinterface.Vacantes;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class CategoriasVacantesPage extends PageObject {

    // Menú lateral
    public static final Target BTN_VACANTES = Target.the("Menú Vacantes")
            .located(By.xpath("//span[contains(normalize-space(.),'Vacantes')]"));

    public static final Target BTN_CATEGORIA = Target.the("Submenú Categoría de vacantes")
            .located(By.xpath("//span[contains(normalize-space(.),'Categoría')]"));

    // Botón principal "Agregar Categoría"
    public static final Target BTN_AGREGAR_CATEGORIA = Target.the("Botón Agregar Categoría")
            .located(By.xpath("//button[contains(normalize-space(.),'Agregar Categoría')]"));

    // Buscador por nombre
    public static final Target INPUT_BUSCAR = Target.the("Campo de búsqueda por nombre de categoría")
            .located(By.xpath("//input[contains(@placeholder,'Buscar por Nombre')]"));

    // Input del modal (Agregar / Editar usan el mismo template)
    public static final Target INPUT_NOMBRE = Target.the("Input nombre de categoría en el modal")
            .located(By.xpath("//input[@name='nomCategoria']"));

    // Botón submit en modal Agregar
    public static final Target BTN_CONFIRMAR_AGREGAR = Target.the("Botón confirmar agregar categoría")
            .located(By.xpath("//div[@id='agregarCategoriaModal']//button[@type='submit']"));

    // Botón submit en modal Editar
    public static final Target BTN_GUARDAR_CAMBIOS = Target.the("Botón guardar cambios de categoría")
            .located(By.xpath("//div[@id='editarCategoriaModal']//button[@type='submit']"));

    // Tabla y acciones por fila
    public static final Target FILA_CATEGORIA = Target.the("Fila por nombre de categoría")
            .locatedBy("//table//tr[td[normalize-space()='{0}']]");

    public static final Target BTN_EDITAR = Target.the("Botón editar por nombre de categoría")
            .locatedBy("//table//tr[td[normalize-space()='{0}']]//button[contains(@class,'editar')]");

    // Input del modal AGREGAR
    public static final Target INPUT_NOMBRE_AGREGAR = Target.the("Input nombre de categoría en el modal Agregar")
            .located(By.xpath("//div[@id='agregarCategoriaModal']//input[contains(@class,'form-control')]"));

    // Input del modal EDITAR
    public static final Target INPUT_NOMBRE_EDITAR = Target.the("Input nombre de categoría en el modal Editar")
            .located(By.xpath("//div[@id='editarCategoriaModal']//input[contains(@class,'form-control')]"));

    public static final Target BTN_ELIMINAR = Target.the("Botón eliminar por nombre de categoría")
            .locatedBy("//table//tr[td[normalize-space()='{0}']]//button[contains(@class,'eliminar')]");

    // SweetAlert genérico (creación / edición / eliminación)
    public static final Target ALERTA_SWEET = Target.the("Contenedor de SweetAlert")
            .located(By.cssSelector("div.swal2-container"));

    // ✅ Solo UNA definición de BTN_ALERTA_OK
    public static final Target BTN_ALERTA_OK = Target.the("Botón OK de SweetAlert")
            .located(By.cssSelector("button.swal2-confirm"));

    // Confirmar eliminar (primer SweetAlert)
    public static final Target BTN_CONFIRMAR_ELIMINAR = Target.the("Confirmar eliminar categoría")
            .located(By.cssSelector("button.swal2-confirm"));
}
