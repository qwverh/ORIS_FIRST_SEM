package dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConnection {
    private static DataSource dataSource;

    public static void init() throws ClassNotFoundException {
        if (dataSource != null) return;
        Class.forName("org.postgresql.Driver");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5433/oris_first_sem");
        config.setUsername("postgres");
        config.setPassword("artem_2006");
        config.setConnectionTimeout(50_000);
        config.setMaximumPoolSize(10);

        dataSource = new HikariDataSource(config);

    }

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            try {
                init();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return dataSource.getConnection();
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void destroy() {
        if (dataSource != null) {
            ((HikariDataSource) dataSource).close();
            dataSource = null;
        }
    }
}
