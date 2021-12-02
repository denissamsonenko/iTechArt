package by.itech.app.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainServlet extends HttpServlet {
    private static final String RESOURCE_NAME = "input.txt";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", getListNumber());
        req.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", getListNumber());

        ArrayList<String> sortedList = (ArrayList<String>) getListNumber();
        Collections.sort(sortedList);

        req.setAttribute("sortList", sortedList);
        req.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);
    }

    private List<String> getListNumber() {
        Stream<String> lines = null;
        List<String> collect = null;

        try {
            Path path = Paths.get((Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource(RESOURCE_NAME)))
                    .toURI());

            lines = Files.lines(path);
            collect = lines.collect(Collectors.toList());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        } finally {
            if (lines != null) {
                lines.close();
            }
        }
        return collect;
    }
}
