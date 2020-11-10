package logic.dao;

public abstract class DAOFactory {
    public abstract DriverDAO getDriverDAO();

    public static DAOFactory getDAOFactory() throws Exception {
        return new DAOFactoryImpl();
    }
}