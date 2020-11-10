package logic.dao;

import logic.dbConnection.ConnectionPool;
import java.sql.Connection;

public class DAOFactoryImpl extends DAOFactory {
    private Connection connection = null;

    public DAOFactoryImpl() throws Exception {
        this.connection = getConnectionFromPool();
    }

    private Connection getConnectionFromPool() throws Exception {
        return ConnectionPool.getConnection();
    }

    @Override
    public DriverDAO getDriverDAO() {
        return new DriverDAOImpl(connection);
    }

}
