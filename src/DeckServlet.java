import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;





@WebServlet(name = "DeckServlet", urlPatterns = "/deckServ")
@MultipartConfig
public class DeckServlet extends HttpServlet {
    private String serverPath = System.getProperty("catalina.base");
    private String filePath = serverPath + "/webapps/data";
    private File file;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        file = new File(filePath);
        if(!file.exists())
        {
            file.mkdirs();
        }

        //final PrintWriter writer = new PrintWriter();
        Part filePart = request.getPart("inputCSVParam");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fContent = filePart.getInputStream();
        OutputStream oStream = new FileOutputStream(new File(filePath + File.separator + fileName));


        int read = 0;
        final byte[] bytes = new byte[1024];

        while((read = fContent.read(bytes)) != -1)
        {
            oStream.write(bytes, 0, read);
        }
        //writer.println("New file " + fileName + " created at " + filePath);

        if(oStream != null)
        {
            oStream.close();
        }
        if(fContent != null)
        {
            fContent.close();
        }
//        if(writer != null)
//        {
//            writer.close();
//        }

        response.sendRedirect(request.getContextPath() + "/DeckList.html");


//        RequestDispatcher rd = request.getRequestDispatcher("DeckOrganizer2/web/DeckList.html");
//        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
