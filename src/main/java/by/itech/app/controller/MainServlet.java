package by.itech.app.controller;

import by.itech.app.service.MainService;
import by.itech.app.service.ServiceProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MainService ms = ServiceProvider.getInstance().getMainService();

        req.setAttribute("list", ms.getListNumber());

        req.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MainService ms = ServiceProvider.getInstance().getMainService();

        List<String> sortedList = ms.getListNumber();
        Collections.sort(sortedList);

        req.setAttribute("list", ms.getListNumber());
        req.setAttribute("sortList", sortedList);

        req.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);
    }
}
