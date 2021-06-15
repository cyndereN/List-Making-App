package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteList.html")
public class DeleteListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String id = request.getParameter("id");
        Model model = ModelFactory.getModel();
        model.deleteList(id);

        var listNames = model.getListNames();
        request.setAttribute("lists", listNames);
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/deleteList.jsp");
        dispatch.forward(request, response);
    }
}
