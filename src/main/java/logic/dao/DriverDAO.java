package logic.dao;

import logic.entities.Driver;

import java.sql.SQLException;
import java.util.List;

public interface DriverDAO {
    List<Driver> getDrivers() throws SQLException;
}
