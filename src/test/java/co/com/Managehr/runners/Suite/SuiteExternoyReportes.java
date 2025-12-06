package co.com.Managehr.runners.Suite;

import co.com.Managehr.runners.HorasExtras.GestionHorasExtraAdminRunner;
import co.com.Managehr.runners.HorasExtras.HorasExtraRunner;
import co.com.Managehr.runners.Postulaciones.GestionPostulacionesRunner;
import co.com.Managehr.runners.Usuarios.FormularioExternoRunner;
import co.com.Managehr.runners.Vacaciones.SolicitudVacacionesRunner;
import co.com.Managehr.runners.Vacantes.CategoriasVacantesRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FormularioExternoRunner.class
})
public class SuiteExternoyReportes {
}
