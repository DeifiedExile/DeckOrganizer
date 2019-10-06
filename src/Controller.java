import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@WebServlet(name = "Controller", urlPatterns = "/controller")
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String page = request.getParameter("page");
        page += ".jsp";


        URL url = sc.getResource(page);


        if(url != null){
            request.getRequestDispatcher(page).forward(request, response);
        }
        else{
            //response.getWriter().print("Cant find " +  page);
            request.getRequestDispatcher("notfound.jsp").forward(request, response);
        }


    }
}
