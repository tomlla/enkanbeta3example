package db.migration;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;
import java.sql.Connection;
import java.sql.Statement;

public class V20160704200359__CreateApplication implements JdbcMigration {

    @Override
    public void migrate(Connection connection) throws Exception {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE Application (id identity primary key, name varchar(255), repository_url text)");
        }
    }
}
