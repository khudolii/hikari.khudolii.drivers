package logic.dao;

import logic.entities.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverDAOImpl implements DriverDAO {
    private Connection connection;

    public DriverDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Driver> getDrivers() throws SQLException {
        try {
            List<Driver> result = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement("select * from driver.driver");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                result.add(new Driver(id, firstName, lastName, age));
            }
            result.stream().map(Driver::toString).forEach(System.out::println);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
