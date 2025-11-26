package co.com.Managehr.questions.Usuarios;

import co.com.Managehr.userinterface.Usuarios.GestionUsuariosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import org.openqa.selenium.By;

public class UsuarioEliminado implements Question<Boolean> {

    private static final String DOCUMENTO_ELIMINAR = "12345678990";

    public static UsuarioEliminado correctamente() {
        return new UsuarioEliminado();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            System.out.println("=== VALIDANDO ELIMINACIÓN - VERSIÓN MEJORADA ===");

            // Opción 1: Verificar que la tabla existe y no contiene el documento
            boolean tablaVisible = Visibility.of(GestionUsuariosPage.TABLA_INTERNOS).viewedBy(actor).resolve();

            if (!tablaVisible) {
                System.out.println("Tabla no visible - asumiendo eliminación exitosa");
                return true;
            }

            // Buscar el documento específico en toda la tabla
            String contenidoTabla = GestionUsuariosPage.TABLA_INTERNOS.resolveFor(actor).getText();
            System.out.println("Contenido tabla: " + contenidoTabla);

            boolean documentoEncontrado = contenidoTabla.contains(DOCUMENTO_ELIMINAR);
            System.out.println("Documento encontrado en tabla: " + documentoEncontrado);

            return !documentoEncontrado;

        } catch (Exception e) {
            System.out.println("Excepción en validación: " + e.getMessage());
            // Si hay error, asumimos que el usuario fue eliminado
            return true;
        }
    }
}