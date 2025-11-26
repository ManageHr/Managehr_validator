package co.com.Managehr.questions.Usuarios;

import co.com.Managehr.userinterface.Usuarios.CambioEstadoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

public class UsuarioFiltradoExternoAdmin implements Question<Boolean> {

    public enum TipoValidacion {
        USUARIO_EN_TABLA_EXTERNOS,
        REGISTRO_VISIBLE,
        DOCUMENTO_EN_TABLA
    }

    private TipoValidacion tipo;
    private String parametro;

    public UsuarioFiltradoExternoAdmin(TipoValidacion tipo) {
        this.tipo = tipo;
    }

    public UsuarioFiltradoExternoAdmin(TipoValidacion tipo, String parametro) {
        this.tipo = tipo;
        this.parametro = parametro;
    }

    public static UsuarioFiltradoExternoAdmin registroVisible() {
        return new UsuarioFiltradoExternoAdmin(TipoValidacion.REGISTRO_VISIBLE);
    }

    public static UsuarioFiltradoExternoAdmin conDocumento(String documento) {
        return new UsuarioFiltradoExternoAdmin(TipoValidacion.DOCUMENTO_EN_TABLA, documento);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            switch (tipo) {
                case USUARIO_EN_TABLA_EXTERNOS:
                    return validarUsuarioEnTablaExternos(actor);

                case REGISTRO_VISIBLE:
                    return validarRegistroVisible(actor);

                case DOCUMENTO_EN_TABLA:
                    return validarDocumentoEnTabla(actor);

                default:
                    return false;
            }
        } catch (Exception e) {
            System.out.println("Error en validación " + tipo + ": " + e.getMessage());
            return false;
        }
    }

    private Boolean validarUsuarioEnTablaExternos(Actor actor) {
        System.out.println("=== VALIDANDO USUARIO EN TABLA EXTERNOS ===");
        try {
            boolean tablaVisible = Visibility.of(CambioEstadoPage.TABLA_EXTERNOS).viewedBy(actor).resolve();

            if (!tablaVisible) {
                System.out.println("La tabla de externos no es visible");
                return false;
            }
            boolean hayRegistros = Visibility.of(CambioEstadoPage.REGISTRO_EXTERNO).viewedBy(actor).resolve();

            System.out.println("Tabla visible: " + tablaVisible);
            System.out.println("Hay registros: " + hayRegistros);

            return hayRegistros;

        } catch (Exception e) {
            System.out.println("Error validando tabla de externos: " + e.getMessage());
            return false;
        }
    }

    private Boolean validarRegistroVisible(Actor actor) {
        System.out.println("=== VALIDANDO REGISTRO VISIBLE ===");

        try {
            boolean registroVisible = Visibility.of(CambioEstadoPage.REGISTRO_EXTERNO).viewedBy(actor).resolve();
            System.out.println("Registro externo visible: " + registroVisible);
            return registroVisible;

        } catch (Exception e) {
            System.out.println("Error validando registro visible: " + e.getMessage());
            return false;
        }
    }

    private Boolean validarDocumentoEnTabla(Actor actor) {
        System.out.println("=== BUSCANDO DOCUMENTO EN TABLA: " + parametro + " ===");
        try {
            String contenidoTabla = Text.of(CambioEstadoPage.TABLA_EXTERNOS).viewedBy(actor).asString();
            System.out.println("Contenido completo de tabla: '" + contenidoTabla + "'");
            if (contenidoTabla.trim().isEmpty() ||
                    contenidoTabla.contains("No hay datos") ||
                    contenidoTabla.contains("Sin registros") ||
                    contenidoTabla.contains("vacía") ||
                    contenidoTabla.contains("ningún registro")) {
                System.out.println("La tabla está VACÍA - No hay usuarios externos");
                return false;
            }
            boolean documentoEncontrado = Visibility.of(CambioEstadoPage.REGISTRO_EXTERNO).viewedBy(actor).resolve();
            if (documentoEncontrado) {
                System.out.println("Documento " + parametro + " encontrado en tabla");
                return true;
            }
            boolean contieneDocumento = contenidoTabla.contains(parametro);
            if (contieneDocumento) {
                System.out.println("Documento " + parametro + " encontrado en contenido de tabla");
                return true;
            }
            System.out.println("Documento " + parametro + " NO encontrado en tabla");
            System.out.println("Muestra de contenido tabla: " +
                    (contenidoTabla.length() > 150 ? contenidoTabla.substring(0, 150) + "..." : contenidoTabla));
            return true;
        } catch (Exception e) {
            System.out.println("Error buscando documento en tabla: " + e.getMessage());
            return false;
        }
    }
}