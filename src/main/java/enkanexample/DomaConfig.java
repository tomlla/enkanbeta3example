package enkanexample;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;

public class DomaConfig implements Config {
    @Override
    public javax.sql.DataSource getDataSource() {
        return null;
    }

    @Override
    public Dialect getDialect() {
        return new H2Dialect();
    }
}
