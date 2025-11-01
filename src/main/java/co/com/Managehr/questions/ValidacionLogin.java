package co.com.Managehr.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static co.com.Managehr.userinterface.Autenticacion.*;

public class ValidacionLogin implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        try {
            String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
            String pageTitle = BrowseTheWeb.as(actor).getDriver().getTitle();
            String pageSource = BrowseTheWeb.as(actor).getDriver().getPageSource();

            boolean hasErrorMessage = pageSource.contains("alert-danger") ||
                    pageSource.contains("error") ||
                    pageSource.contains("incorrect");

            System.out.println("=== DEBUG INFO ===");
            System.out.println("URL: " + currentUrl);
            System.out.println("Title: " + pageTitle);
            System.out.println("Tiene mensaje error: " + hasErrorMessage);
            System.out.println("=== FIN DEBUG ===");

            if (hasErrorMessage) {
                return "FAILED - Se encontró mensaje de error";
            } else if (currentUrl.contains("login")) {
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