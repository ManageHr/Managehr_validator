package co.com.Managehr.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CrearUsuarioPage extends PageObject {
    public static final Target PRIMER_NOMBRE_INPUT = Target.the("primer nombre")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[1]/input"));
    public static final Target SEGUNDO_NOMBRE_INPUT = Target.the("segundo nombre")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[2]/input"));
    public static final Target PRIMER_APELLIDO_INPUT = Target.the("primer apellido")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[3]/input"));
    public static final Target SEGUNDO_APELLIDO_INPUT = Target.the("segundo apellido")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[4]/input"));
    public static final Target TIPO_DOCUMENTO_SELECT = Target.the("tipo de documento")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[5]/select"));
    public static final Target NUMERO_DOCUMENTO_INPUT = Target.the("número de documento")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[6]/input"));
    public static final Target FECHA_NACIMIENTO_INPUT = Target.the("fecha de nacimiento")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[7]/input"));
    public static final Target EMAIL_INPUT = Target.the("email")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[8]/input[1]"));
    public static final Target TELEFONO_INPUT = Target.the("teléfono")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[10]/input"));
    public static final Target DIRECCION_INPUT = Target.the("dirección")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[9]/input"));
    public static final Target NACIONALIDAD_SELECT = Target.the("nacionalidad")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[11]/select"));
    public static final Target EPS_SELECT = Target.the("EPS")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[12]/select"));
    public static final Target FONDO_PENSION_SELECT = Target.the("fondo de pensiones")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[13]/select"));
    public static final Target GENERO_SELECT = Target.the("género")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[14]/select"));
    public static final Target ESTADO_CIVIL_SELECT = Target.the("estado civil")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[15]/select"));
    public static final Target ROL_SELECT = Target.the("rol")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[18]/select"));
    public static final Target PASSWORD_INPUT = Target.the("contraseña")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[16]/input"));
    public static final Target REPETIR_PASSWORD_INPUT = Target.the("repetir contraseña")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[1]/div/div[17]/input"));
    public static final Target BTN_GUARDAR = Target.the("botón guardar")
            .located(By.xpath("//*[@id=\"agregarusuariosModal\"]/div/div/form/div[2]/button"));
    public static final Target BTN_AGREGAR_USUARIO = Target.the("botón agregar usuario")
            .located(By.xpath("//*[@id=\"tituloTargetas1\"]/div/button[2]")); // Eliminé el carácter extra ')]
    public static final Target FORMULARIO_MODAL = Target.the("formulario modal")
            .located(By.id("agregarusuariosModal"));
    public static final Target ALERTA_EXITO = Target.the("alerta de éxito")
            .located(By.xpath("//div[contains(@class,'alert-success')]"));
    public static final Target FILTRO_USUARIOS_INPUT = Target.the("campo de filtro de usuarios")
            .located(By.id("tituloTargetasfiltro2"));
    public static final Target TABLA_USUARIOS = Target.the("tabla de usuarios")
            .located(By.xpath("/html/body/app-root/app-usuarios/div/div/div[2]/div[4]/table"));
    public static final Target ALERTA_EXITO_ALTERNATIVA = Target.the("alerta de éxito alternativa")
            .located(By.xpath("//div[contains(@class,'alert') and contains(@class,'success')]"));
}
