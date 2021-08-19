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
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            String uid = request.getParameter("userid");
            String pwd = request.getParameter("password");
            
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
            
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/student","root","");
                st = con.createStatement();
                String query = "select * from login WHERE userid = '"+uid+"' AND password = '"+pwd+"'";
                rs = st.executeQuery(query);
                if(rs.next())
                {
                    response.sendRedirect("mainmenu.html");
                }
                else
                {
                    out.println("Check User Id and Password You Have Entered!");
                }
                
            }
            catch(Exception e)
            {
                out.println(e);
            }
        }
    }
}
