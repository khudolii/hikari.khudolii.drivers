package logic.beans;

import logic.entities.Driver;

import java.util.List;

public class DriverBean {
    private List<Driver> drivers;

    private Driver driver;

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
