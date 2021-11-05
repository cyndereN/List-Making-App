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

// The servlet invoked to display a list of lists.
// The url http://localhost:8080/lists.html is mapped to calling doGet on the servlet object.
// The servlet object is created automatically
@WebServlet("/lists.html")
public class ViewListsServlet extends HttpServlet
{

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    Model model = ModelFactory.getModel();
    var listNames = model.getListNames();
    request.setAttribute("lists", listNames);
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/lists.jsp");
    dispatch.forward(request, response);
  }

}
