package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.MyList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/editItem.html")
public class EditItemServlet  extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String id = request.getParameter("id");
        String val = request.getParameter("val");

        request.setAttribute("id", id);
        request.setAttribute("val", val);
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/editItem.jsp");
        dispatch.forward(request, response);
    }

}
