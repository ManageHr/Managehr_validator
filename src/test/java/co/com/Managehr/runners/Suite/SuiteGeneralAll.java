package co.com.Managehr.runners.Suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SuiteUsuarios.class,
        SuiteRcursosHumanos.class,
        SuiteExternoyReportes.class
})
public class SuiteGeneralAll {
}
