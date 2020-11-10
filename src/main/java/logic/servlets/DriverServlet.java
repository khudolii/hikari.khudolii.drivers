package logic.servlets;

import logic.beans.DriverBean;
import logic.dao.DAOFactory;
import logic.entities.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DriverServlet", urlPatterns = {"*.html"})
public class DriverServlet extends HttpServlet {
    private DAOFactory daoFactory;
    private DriverBean driverBean = null;

    @Override
    public void init() throws ServletException {
        try {
            daoFactory = DAOFactory.getDAOFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (driverBean == null) {
            try {
                driverBean = new DriverBean();
                driverBean.setDrivers(daoFactory.getDriverDAO().getDrivers());
            } catch (SQLException e) {
                e.printStackTrace();
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        }
        request.setAttribute("driverBean", driverBean);
        request.getRequestDispatcher("/drivers.jsp").forward(request, response);
    }
}
