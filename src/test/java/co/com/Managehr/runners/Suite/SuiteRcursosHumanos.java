package co.com.Managehr.runners.Suite;

import co.com.Managehr.runners.Contratos.ContratosRunner;
import co.com.Managehr.runners.HorasExtras.GestionHorasExtraAdminRunner;
import co.com.Managehr.runners.HorasExtras.HorasExtraRunner;
import co.com.Managehr.runners.Vacantes.CategoriasVacantesRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContratosRunner.class,
        HorasExtraRunner.class,
        GestionHorasExtraAdminRunner.class,
        CategoriasVacantesRunner.class

})
public class SuiteRcursosHumanos {
}
