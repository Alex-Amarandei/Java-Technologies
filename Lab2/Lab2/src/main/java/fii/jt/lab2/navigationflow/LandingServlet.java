package fii.jt.lab2.navigationflow;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Represents the servlet responsible with handling the landing page (aka the input page).
 *
 * @author Amarandei Matei Alexandru
 */
@WebServlet(name = "landing", value = "/")
public class LandingServlet extends HttpServlet {
    /**
     * Handles the GET request by forwarding all requests to input.jsp.
     *
     * @param request  The HTTP POST request.
     * @param response The HTML page returned as a response to the request.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("input.jsp").forward(request, response);
    }
}
