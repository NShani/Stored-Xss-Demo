import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    public static HashMap<String, String> credentials = new HashMap<String, String>();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("username");

            credentials.put(String.valueOf(credentials.size() + 1), username);

            try {
                /*
                // This code snippet for demonstrating a database persist stored xss //
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/webapp", "user", "password");

                Statement st = conn.createStatement();
                String sql = "INSERT INTO users (username,password) Values ('"+username+"','"+password+"')" ;

                //                String sql = "INSERT INTO users WHERE username='" + username + "' AND password='" + password + "'";
                System.out.println(sql);
                st.execute(sql);
                */

                if (credentials.size() != 0) {
                    response.sendRedirect("list.jsp");
                } else {
                    out.println("Invalid username");
                }
//                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            out.close();
        }
    }
}
