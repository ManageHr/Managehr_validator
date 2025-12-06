package co.com.Managehr.userinterface.Menu;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class MenuPage extends PageObject {

    public static final Target MENU_CONTRATOS = Target.the("Menú Contratos")
            .located(By.xpath("//span[text()='Contratos']"));


    public static final Target LINK_CONTRATOS = Target.the("Enlace Contratos")
            .located(By.xpath("//a[contains(@class,'nav-link')]//span[text()='Contratos']"));


    public static final Target A_CONTRATOS = Target.the("Elemento 'a' Contratos")
            .located(By.xpath("//a[.//span[text()='Contratos']]"));


    public static final Target CONTRATOS_CSS = Target.the("Contratos CSS Selector")
            .located(By.cssSelector("a.nav-link span"));
}