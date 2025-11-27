package co.com.Managehr.questions.HorasExtra;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

import java.util.List;

public class CantidadSolicitudesHorasExtra implements Question<Integer> {

    public static CantidadSolicitudesHorasExtra actual() {
        return new CantidadSolicitudesHorasExtra();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        List<WebElementFacade> filas = BrowseTheWeb.as(actor)
                .findAll(By.xpath("//table//tbody/tr"));
        int total = filas.size();
        System.out.println("Cantidad actual de solicitudes de horas extra: " + total);
        return total;
    }
}
