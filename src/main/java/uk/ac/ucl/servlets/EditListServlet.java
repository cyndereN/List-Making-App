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

@WebServlet("/editList.html")
public class EditListServlet  extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String id = request.getParameter("id");
        Model model = ModelFactory.getModel();
        MyList list = new MyList();
        for(MyList aList : model.getLists()) {
            if (aList.getName().equals(id))  list = aList;
        }
        request.setAttribute("list", list);
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/editList.jsp");
        dispatch.forward(request, response);
    }


}
