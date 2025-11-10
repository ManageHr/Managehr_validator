package co.com.Managehr.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidacionLogin implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        try {

            String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();

            System.out.println("=== VALIDACIÓN RÁPIDA ===");
            System.out.println("URL: " + currentUrl);
            System.out.println("=== FIN VALIDACIÓN ===");

            if (currentUrl.contains("login")) {
                return "FAILED - Sigue en página de login";
            } else {
                return "SUCCESS - Redirigido correctamente";
            }

        } catch (Exception e) {
            return "ERROR - " + e.getMessage();
        }
    }

    public static ValidacionLogin validacionLogin() {
        return new ValidacionLogin();
    }
}