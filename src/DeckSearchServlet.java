import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

@WebServlet(name = "DeckSearchServlet", urlPatterns = "/search")
public class DeckSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        PreparedStatement pstmt = null;
        HttpSession session = request.getSession();

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
            String sql = "select deck_name, user_name from decks join users on decks.user_id = users.user_id where upper(decks.deck_name) like ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, request.getParameter("searchTerm").toUpperCase());

            //Run select query and get result set
            rset = pstmt.executeQuery();
            output.append("<table class=\"table-dark table-striped\">");
            output.append("<tr><th>Deck Name</th><th>User</th></tr>");
            while(rset.next())
            {
                output.append("<tr><td><div class = \"selectDeckCard card card-body shadow-sm text-center\"><a href=\"detailDeck?deckName=").append(rset.getString(1)).append("\" class=\"selectDeck\">");
                output.append(rset.getString(1)).append("</a></div></td><td>").append(rset.getString(2)).append("</td></tr>");
            }
            output.append("</table>");


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            DatabaseUtils.closeAll(conn, stmt, rset);
            DatabaseUtils.closePstmt(pstmt);
        }

        session.setAttribute("deckList", output);
        System.out.println(output);

        //session.setAttribute("cardList", output);

        request.getRequestDispatcher("list-decks.jsp").forward(request, response);

    }
}
