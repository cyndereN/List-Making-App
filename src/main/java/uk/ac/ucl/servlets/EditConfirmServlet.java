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

@WebServlet("/editConfirm.html")
public class EditConfirmServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String id = request.getParameter("id");
        String val = request.getParameter("val");
        int index = Integer.parseInt(val);
        String newItem = request.getParameter("newItem");
        Model model = ModelFactory.getModel();
        if (index==0)  { model.changeListName(id, newItem); id = newItem; }
        else model.changeItem(id, newItem, index);

        request.setAttribute("id", id);
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/editConfirm.jsp");
        dispatch.forward(request, response);
    }
}
