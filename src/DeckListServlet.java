import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;


@WebServlet(name = "DeckListServlet", urlPatterns = "/listDecks")
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
            rset = stmt.executeQuery("select deck_name, user_name from decks join users on decks.user_id = users.user_id");
             output.append("<table class=\"table-dark table-striped\">");
            output.append("<tr><th>Deck Name</th><th>User</th></tr>");
            while(rset.next())
            {
                output.append("<tr><td><div class = \"selectDeckCard card card-body shadow-sm text-center\"><a href=\"detailDeck?deckName="+ rset.getString(1) +"\" class=\"selectDeck\">");
                output.append(rset.getString(1) + "</a></div></td><td>"+rset.getString(2)+"</td></tr>");
            }
            output.append("</table>");


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            DatabaseUtils.closeAll(conn, stmt, rset);

        }
        HttpSession session = request.getSession();
        session.setAttribute("deckList", output);
        System.out.println(session.getId());

        request.getRequestDispatcher("WEB-INF/view/list-decks.jsp").forward(request, response);



    }
}
