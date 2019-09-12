import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(name = "DeckListServlet", urlPatterns = "/list")
public class DeckListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        StringBuilder output = new StringBuilder();


        try {
            //load derby driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //get absolute path of db
            String absPath = getServletContext().getRealPath(DatabaseUtils.DATABASE_PATH);
            //Create connection
            conn = DriverManager.getConnection(DatabaseUtils.DRIVER_NAME + absPath,DatabaseUtils.USERNAME, DatabaseUtils.PASSWORD);
            //Create Statement
            stmt = conn.createStatement();
            //Run select query and get result set
            rset = stmt.executeQuery("select deck_name, user_name from decks" +
                    "join users on decks.user_id = users.user_id");
             output.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>DeckOrganizer - DeckList</title>\n" +
                    "    <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n" +
                    "    <link rel=\"stylesheet\" href=\"css/styles.css\">\n" +
                    "    <script src=\"http://code.jquery.com/jquery-3.4.1.js\"></script>\n" +
                    "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n" +
                    "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-csv/1.0.5/jquery.csv.js\"></script>\n" +
                    "    <script src=\"scripts.js\"></script>\n" +
                    "    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n" +
                    "\n" +
                    "</head>\n" +
                    "<body id=\"bodyDeckList\">\n" +
                    "    <div class=\"container text-center\" id=\"divDeckList\">" +
                    "<table class=\"table-dark table-striped\">");
            output.append("<tr><th>Deck Name</th><th>User</th></tr>");
            while(rset.next())
            {
                output.append("<tr><td><div class = \"selectDeckCard card card-body  shadow-sm text-center\"><a href=\"DeckDetail.html\" class=\"selectDeck\">");
                output.append(rset.getString(1) + "</a></div></td><td>"+rset.getString(2)+"</td></tr>");
            }
            output.append("</table>" +
                    "</div>\n" +
                    "    <div class=\"container\">\n" +
                    "        <div class=\"row\">\n" +
                    "            <div class=\"col-md-6 offset-md-3\">\n" +
                    "                <a href=\"NewDeck.html\" class=\"btn-secondary border rounded p-2\" name=\"btnAddDeck\">New Deck</a>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>");

            //response.getWriter().print(output.toString());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            DatabaseUtils.closeAll(conn, stmt, rset);

        }

        request.setAttribute("deckList", output.toString());
        request.getRequestDispatcher("Decks.jsp").forward(request, response);




    }
}
