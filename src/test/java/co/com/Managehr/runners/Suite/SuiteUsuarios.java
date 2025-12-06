package co.com.Managehr.runners.Suite;

import co.com.Managehr.runners.Contratos.ContratosRunner;
import co.com.Managehr.runners.Contratos.EliminarContratoRunner;
import co.com.Managehr.runners.Postulaciones.GestionPostulacionesRunner;
import co.com.Managehr.runners.Usuarios.CambioExternoEmpleadoRunner;
import co.com.Managehr.runners.Usuarios.EliminarUsuarioInternoRunner;
import co.com.Managehr.runners.Usuarios.FormularioExternoRunner;
import co.com.Managehr.runners.Usuarios.RegistrarUsuarioRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        RegistrarUsuarioRunner.class,
        CambioExternoEmpleadoRunner.class,
        ContratosRunner.class,
        EliminarContratoRunner.class,
        EliminarUsuarioInternoRunner.class


})
public class SuiteUsuarios {
}
