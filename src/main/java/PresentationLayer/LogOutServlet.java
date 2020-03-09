package PresentationLayer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "PresentationLayer.LogOutServlet", urlPatterns = "/PresentationLayer.LogOutServlet")
public class LogOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
// Sletter navnet fra aktive brugere således at en ny bruger kan logeg ind:
        ServletContext servletContext = getServletContext();
        ((Set<String>)servletContext.getAttribute("aktiveBrugere")).remove(session.getAttribute("email"));

        session.invalidate();
        request.getRequestDispatcher("employeepage.jsp").forward(request,response);
        request.getRequestDispatcher("customerpage.jsp").forward(request,response);
        request.getRequestDispatcher("oversigt.jsp").forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
