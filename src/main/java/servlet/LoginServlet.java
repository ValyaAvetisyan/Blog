package servlet;

import manager.UserManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
           UserManager userManager = new UserManager();
            try {
                User user = userManager.getUserByUsernameAndPassword(email, password);
                if (user != null) {
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    if (user.getType().equalsIgnoreCase("ADMIN")){
                        resp.sendRedirect("/admin");
                    }else{
                        resp.sendRedirect("/home");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            req.setAttribute("error","Please fill username and password");
            getServletContext().getRequestDispatcher( "/WEB-INF/login.jsp" ).forward(req,resp);
        }


    }

}
