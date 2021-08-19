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
public class grades extends HttpServlet {


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
                String query = "select * from grades WHERE Semester = '"+sem+"'";
                rs = st.executeQuery(query);
                while(rs.next())
                {
                   out.println("Semester: " + rs.getString(1) + "<br />Overall grade: " + rs.getString(2) + "<br />cgpa: " + rs.getString(3));
                }
                
            }
            
            catch(Exception e)
            {
                out.println(e);
            }
        }
    }
}

   