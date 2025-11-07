package co.com.Managehr.tasks;

import co.com.Managehr.models.DatosFormularioExterno;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static co.com.Managehr.userinterface.FormularioExterno.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompletarFormularioExterno implements Task {

    private final List<DatosFormularioExterno> datos;

    public CompletarFormularioExterno(List<DatosFormularioExterno> datos) {
        this.datos = datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        DatosFormularioExterno d = datos.get(0);

        System.out.println("=== INICIANDO LLENADO DE FORMULARIO ===");
        System.out.println("[Registro] Documento: " + d.getNumeroDocumento() + " | Correo: " + d.getCorreo());

        System.out.println("→ Haciendo clic en 'Ver ofertas laborales'");
        actor.attemptsTo(Click.on(BTN_VER_OFERTAS));

        System.out.println("Esperando 5 segundos para cargar el modal de postulación...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("→ Haciendo clic en 'Postularme'");
        actor.attemptsTo(
                WaitUntil.the(BTN_POSTULACION, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(BTN_POSTULACION)
        );

        System.out.println("Esperando que los campos del formulario sean visibles...");
        actor.attemptsTo(
                WaitUntil.the(INPUT_DOCUMENTO, isVisible()).forNoMoreThan(10).seconds()
        );

        System.out.println("→ Ingresando datos del formulario...");
        actor.attemptsTo(
                Enter.theValue(d.getNumeroDocumento()).into(INPUT_DOCUMENTO),
                Enter.theValue(d.getNombreCompleto()).into(INPUT_NOMBRE),
                Enter.theValue(d.getCorreo()).into(INPUT_CORREO),
                Enter.theValue(d.getConfirmarCorreo()).into(INPUT_CONFIRCORREO),
                Enter.theValue(d.getContrasenia()).into(INPUT_CONTRASENIA),
                Enter.theValue(d.getConfirmarContrasenia()).into(INPUT_CONFIRCONTRASENIA)
        );

        System.out.println("→ Haciendo clic en 'Registrarse'");
        actor.attemptsTo(Click.on(BTN_REGISTRARSE));

        System.out.println("Esperando respuesta de la alerta (SweetAlert o mensaje de validación)...");
        try {
            actor.attemptsTo(WaitUntil.the(SWEETALERT_TEXT, isVisible()).forNoMoreThan(6).seconds());
            String titulo = "", texto = "";

            try { titulo = Text.of(SWEETALERT_TITLE).viewedBy(actor).asString(); } catch (Exception ignored) {}
            try { texto = Text.of(SWEETALERT_TEXT).viewedBy(actor).asString(); }  catch (Exception ignored) {}

            if (!titulo.isBlank() || !texto.isBlank()) {
                System.out.println("=== RESULTADO DE ALERTA ===");
                System.out.println("Título: " + titulo);
                System.out.println("Mensaje: " + texto);
                if (titulo.toLowerCase().contains("éxito") || titulo.toLowerCase().contains("exito")) {
                    System.out.println("✔ Resultado: REGISTRO EXITOSO");
                } else if (titulo.toLowerCase().contains("error") || texto.toLowerCase().contains("error")) {
                    System.out.println("✖ Resultado: ERROR EN REGISTRO");
                } else {
                    System.out.println("ℹ Resultado: ALERTA MOSTRADA SIN ERROR NI ÉXITO EXPLÍCITO");
                }
            } else {
                System.out.println("No se pudo capturar texto de la alerta.");
            }

        } catch (Exception e) {
            System.out.println("⚠ No se encontró alerta visible: " + e.getMessage());
        }

        System.out.println("=== FIN DEL LLENADO DE FORMULARIO ===");
    }

    public static CompletarFormularioExterno con(List<DatosFormularioExterno> datos) {
        return instrumented(CompletarFormularioExterno.class, datos);
    }
}
