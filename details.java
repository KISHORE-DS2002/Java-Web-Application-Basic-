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
public class details extends HttpServlet {


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
                    String query1 = "select * from details WHERE userid = '"+uid+"'";
                    rs = st.executeQuery(query1);
                    out.println("_________________________________________________________________________________<br />");
                    while(rs.next())
                    {
                        out.println("<br />Registration Number: " + rs.getString(2) + "<br />Student Name: " + rs.getString(3) + "<br />Depatment: " + rs.getString(4) + "<br />Batch: " + rs.getString(5));
                    }
                    out.println("<br />_________________________________________________________________________________");
                    
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

