import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DSK
 */
public class leaveprocess extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            String regno = request.getParameter("regno");
            String name = request.getParameter("name");
            String reason = request.getParameter("reason");
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
            
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/student","root","");
                st = con.createStatement();
                String query = ("insert into leavereq values('"+regno+"','"+name+"','"+reason+"','"+from+"','"+to+"')");
                st.executeUpdate(query);
                RequestDispatcher req = request.getRequestDispatcher("generateleavereq.jsp");
                req.forward(request, response);
            }
            
            catch(Exception e)
            {
                out.println(e);
            }
        }
    }
}

   