package co.com.Managehr.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class ValidationHorasExtra implements Question<Boolean> {

    private final String descripcionEsperada;

    private ValidationHorasExtra(String descripcionEsperada) {
        this.descripcionEsperada = descripcionEsperada;
    }

    public static Question<Boolean> modalExito() {
        return new ValidationHorasExtra(null);
    }

    public static Question<Boolean> muestraConfirmacion(String descripcion) {
        return new ValidationHorasExtra(descripcion);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        List<By> successLocators = Arrays.asList(
                By.xpath("//*[contains(@class,'swal2-popup') and .//*[contains(@class,'swal2-success')]]"),
                By.xpath("//*[contains(@class,'swal2-title') and (contains(.,'Éxito') or contains(.,'Exito'))]"),
                By.xpath("//*[contains(@class,'toast-success') or contains(@class,'alert-success')]"),
                By.xpath("//*[contains(normalize-space(.),'Solicitud enviada') or " +
                        "contains(normalize-space(.),'guardada') or " +
                        "contains(normalize-space(.),'enviada correctamente')]")
        );

        long limit = System.currentTimeMillis() + 20000;
        while (System.currentTimeMillis() < limit) {
            for (By by : successLocators) {
                try {
                    WebElement el = driver.findElement(by);
                    if (el != null && el.isDisplayed()) {
                        if (descripcionEsperada != null && !descripcionEsperada.isEmpty()) {
                            String body = driver.findElement(By.tagName("body")).getText();
                            if (!body.toLowerCase().contains(descripcionEsperada.toLowerCase())) {
                                break;
                            }
                        }
                        return true;
                    }
                } catch (NoSuchElementException ignored) {}
            }
            try { Thread.sleep(250); } catch (InterruptedException ignored) {}
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successLocators.get(0)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
