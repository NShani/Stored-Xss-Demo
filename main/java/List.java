import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "List", urlPatterns = {"/list"})
public class List extends HttpServlet {

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

            try {

                /*
                // This code snippet for demonstrating a database persist stored xss //
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp", "user", "password");
                Statement st = conn.createStatement();
                String sql = "SELECT * FROM users";
                System.out.println(sql);
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");

                out.println(username);
                out.println(password);
                out.println("<br/>");
                }
                conn.close();
                */

                for (int i = 1; i < Login.credentials.size() + 1; i++) {
                    out.println("User name :");
                    out.println(Login.credentials.get(String.valueOf(i)));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            out.close();
        }
    }
}
