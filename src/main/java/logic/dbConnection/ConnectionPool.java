package logic.dbConnection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static HikariDataSource ds = null;

    public static Connection getConnection() throws SQLException {
        if (ds != null) return ds.getConnection();
        return initDataSource().getConnection();
    }

    public static HikariDataSource initDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(DBConstant.DB_URL);
        config.setUsername(DBConstant.USER_DB);
        config.setPassword(DBConstant.PASS_DB);
        config.setPoolName("NewPoolTest");
        config.setRegisterMbeans(true);
        config.setMaximumPoolSize(250);
        config.setLeakDetectionThreshold(5000);
        return ds = new HikariDataSource(config);
    }
}
