import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author DSK
 */
public class marks extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            String sem = request.getParameter("semester");
            
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
            
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/student","root","");
                st = con.createStatement();
                String query = "select * from marks WHERE Semester = '"+sem+"'";
                rs = st.executeQuery(query);
                while(rs.next())
                {
                   out.println("Semester: " + rs.getString(1) + "<br />A1: " + rs.getInt(2) + "<br />B1: " + rs.getInt(3) + "<br />C1: " + rs.getInt(4));
                }
                
            }
            
            catch(Exception e)
            {
                out.println(e);
            }
        }
    }
}

   