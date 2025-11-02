package co.com.Managehr.tasks;

import co.com.Managehr.models.HorasExtraUsuario;
import co.com.Managehr.userinterface.FormHorasExtra;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class CrearHoraExtra implements Task {

    private final HorasExtraUsuario data;

    public CrearHoraExtra(HorasExtraUsuario data) { this.data = data; }

    public static CrearHoraExtra con(HorasExtraUsuario data){
        return Tasks.instrumented(CrearHoraExtra.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(FormHorasExtra.MENU_HORAS_EXTRA, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(FormHorasExtra.MENU_HORAS_EXTRA),
                WaitUntil.the(FormHorasExtra.FORM_CONTENEDOR, isVisible()).forNoMoreThan(30).seconds()
        );


        WebElementFacade descripcion = FormHorasExtra.INPUT_DESCRIPCION.resolveFor(actor);
        actor.attemptsTo(Scroll.to(FormHorasExtra.INPUT_DESCRIPCION), Click.on(FormHorasExtra.INPUT_DESCRIPCION));
        jsSetValue(actor, descripcion, data.getDescripcion());
        actor.attemptsTo(
                Hit.the(Keys.TAB).into(FormHorasExtra.INPUT_DESCRIPCION),
                WaitUntil.the(FormHorasExtra.INPUT_DESCRIPCION, hasValue(data.getDescripcion())).forNoMoreThan(5).seconds()
        );

        WebElementFacade inputFecha = FormHorasExtra.INPUT_FECHA.resolveFor(actor);
        String tipoFecha = safeAttr(inputFecha, "type");
        String fechaRaw  = data.getFecha() == null ? "" : data.getFecha().trim();
        String yyyyMMdd = toYyyyMmDd(fechaRaw);
        String ddMMyyyy = toDdMmYyyy(fechaRaw);

        if ("date".equalsIgnoreCase(tipoFecha)) {
            setDateInputWithJS(actor, inputFecha, yyyyMMdd);
            actor.attemptsTo(Click.on(FormHorasExtra.INPUT_FECHA), Hit.the(Keys.TAB).into(FormHorasExtra.INPUT_FECHA));
            actor.attemptsTo(WaitUntil.the(FormHorasExtra.INPUT_FECHA, hasValue(yyyyMMdd)).forNoMoreThan(5).seconds());
        } else {
            actor.attemptsTo(
                    Scroll.to(FormHorasExtra.INPUT_FECHA),
                    Click.on(FormHorasExtra.INPUT_FECHA),
                    Clear.field(FormHorasExtra.INPUT_FECHA),
                    Enter.theValue(ddMMyyyy).into(FormHorasExtra.INPUT_FECHA).thenHit(Keys.TAB),
                    WaitUntil.the(FormHorasExtra.INPUT_FECHA, hasValue(ddMMyyyy)).forNoMoreThan(5).seconds()
            );
        }

        WebElementFacade tipo = FormHorasExtra.SELECT_TIPO.resolveFor(actor);
        if ("select".equalsIgnoreCase(tipo.getTagName())) {
            actor.attemptsTo(SelectFromOptions.byVisibleText(data.getTipo()).from(FormHorasExtra.SELECT_TIPO));
        } else {
            actor.attemptsTo(
                    Click.on(FormHorasExtra.SELECT_TIPO),
                    Enter.theValue(data.getTipo()).into(FormHorasExtra.SELECT_TIPO).thenHit(Keys.ENTER)
            );
        }

        String cantidad = (data.getCantidad() == null ? "" : data.getCantidad().trim().replace(",", "."));
        WebElementFacade cantidadEl = FormHorasExtra.INPUT_CANTIDAD.resolveFor(actor);
        actor.attemptsTo(Scroll.to(FormHorasExtra.INPUT_CANTIDAD), Click.on(FormHorasExtra.INPUT_CANTIDAD));
        jsSetValue(actor, cantidadEl, cantidad);
        actor.attemptsTo(
                Hit.the(Keys.TAB).into(FormHorasExtra.INPUT_CANTIDAD),
                WaitUntil.the(FormHorasExtra.INPUT_CANTIDAD, hasValue(cantidad)).forNoMoreThan(5).seconds()
        );

        WebElementFacade btn = FormHorasExtra.BTN_ENVIAR.resolveFor(actor);
        actor.attemptsTo(
                Scroll.to(FormHorasExtra.BTN_ENVIAR),
                MoveMouse.to(FormHorasExtra.BTN_ENVIAR),
                WaitUntil.the(FormHorasExtra.BTN_ENVIAR, isVisible()).forNoMoreThan(15).seconds()
        );
        centerAndFocus(actor, btn);

        boolean enviado = false;
        for (int i = 0; i < 3 && !enviado; i++) {
            try {
                actor.attemptsTo(Click.on(FormHorasExtra.BTN_ENVIAR));
                enviado = waitConfirmation(actor, 8000);
            } catch (Exception ignored) {
                jsClick(actor, btn);
                enviado = waitConfirmation(actor, 8000);
            }
        }
    }



    private static void jsSetValue(Actor actor, WebElementFacade el, String value){
        ((JavascriptExecutor) BrowseTheWeb.as(actor).getDriver())
                .executeScript(
                        "const e=arguments[0],v=arguments[1]; e.value=''; e.value=v;" +
                                "e.dispatchEvent(new Event('input',{bubbles:true}));" +
                                "e.dispatchEvent(new Event('change',{bubbles:true}));",
                        el, value == null ? "" : value
                );
    }

    private static void jsClick(Actor actor, WebElementFacade el){
        ((JavascriptExecutor) BrowseTheWeb.as(actor).getDriver())
                .executeScript("arguments[0].click();", el);
    }

    private static void centerAndFocus(Actor actor, WebElementFacade el){
        ((JavascriptExecutor) BrowseTheWeb.as(actor).getDriver())
                .executeScript("arguments[0].scrollIntoView({block:'center'}); arguments[0].focus();", el);
    }

    private static boolean waitConfirmation(Actor actor, long timeoutMs){
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        long end = System.currentTimeMillis() + timeoutMs;
        while (System.currentTimeMillis() < end) {
            boolean successModal = !driver.findElements(By.xpath(
                    "//*[contains(text(),'Éxito') or contains(text(),'enviada correctamente') or contains(text(),'Solicitud de horas extra enviada correctamente.')]"
            )).isEmpty();

            if (successModal) {
                try {
                    driver.findElement(By.cssSelector(".swal2-actions button.swal2-confirm")).click();
                } catch (Exception ignored) {}
                return true;
            }
            try { Thread.sleep(200); } catch (InterruptedException ignored) {}
        }
        return false;
    }

    private static String safeAttr(WebElementFacade el, String name) {
        try {
            String v = el.getAttribute(name);
            return v == null ? "" : v;
        } catch (Exception e) { return ""; }
    }

    private static String toYyyyMmDd(String anyFormat) {
        LocalDate d = parseFlexible(anyFormat);
        return d.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    private static String toDdMmYyyy(String anyFormat) {
        LocalDate d = parseFlexible(anyFormat);
        return d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private static LocalDate parseFlexible(String v) {
        if (v == null || v.isEmpty()) return LocalDate.now();
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter f2 = DateTimeFormatter.ISO_LOCAL_DATE;
        try { return LocalDate.parse(v, f1); } catch (DateTimeParseException ignore) {}
        try { return LocalDate.parse(v, f2); } catch (DateTimeParseException ignore) {}
        return LocalDate.now();
    }

    private static void setDateInputWithJS(Actor actor, WebElementFacade input, String yyyyMmDd) {
        ((JavascriptExecutor) BrowseTheWeb.as(actor).getDriver())
                .executeScript(
                        "const el=arguments[0],v=arguments[1];" +
                                "try{ el.valueAsDate=new Date(v); }catch(e){}" +
                                "el.value=v;" +
                                "el.dispatchEvent(new Event('input',{bubbles:true}));" +
                                "el.dispatchEvent(new Event('change',{bubbles:true}));",
                        input, yyyyMmDd
                );
    }
}
