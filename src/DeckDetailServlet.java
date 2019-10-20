import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DeckDetailServlet", urlPatterns = "/detailDeck")
public class DeckDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            String sql = "select card_name, quantity from cards join deck_card on cards.card_id = deck_card.card_id join decks on decks.deck_id = deck_card.deck_id where deck_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, request.getParameter("deckName"));
            //Run select query and get result set
            rset = pstmt.executeQuery();
            output.append("<table class=\"table-dark table-striped\">");
            output.append("<tr><th>Card Name</th><th>Quantity</th></tr>");
            while(rset.next())
            {
                output.append("<tr><td>");
                output.append(rset.getString(1) + "</td><td>"+rset.getString(2)+"</td></tr>");
            }
            output.append("</table>");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            DatabaseUtils.closeAll(conn, stmt, rset);
            DatabaseUtils.closePstmt(pstmt);
        }

        session.setAttribute("cardList", output);

        request.getRequestDispatcher("WEB-INF/view/Detail.jsp").forward(request, response);

    }
}
