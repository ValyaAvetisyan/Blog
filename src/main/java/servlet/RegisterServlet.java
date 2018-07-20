package servlet;

import manager.UserManager;
import model.User;
import util.Validator;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String type= req.getParameter("type");
        String errMessage = "";
        UserManager userManager = new UserManager();

        if (Validator.isEmpty(name)) {
            errMessage += "Name is empty <br>";
        }
        if (Validator.isEmpty(surname)) {
            errMessage += "Surname is empty<br>";

        }

        if (Validator.isEmpty(email)) {
            errMessage += "Email is empty <br>";
        } else if (userManager.isEmailExists(email)) {
            errMessage += "Email is already existed<br>";
        }
        if (Validator.isEmpty(password)) {
            errMessage += "Password is empty <br>";
        }
        if (Validator.isEmpty(type)) {
            errMessage += "Type is empty <br>";
        }


        if (errMessage.equals("")) {
            User user = new User();
            user.setName(name);
            user.setSurname(surname);
            user.setEmail(email);
            user.setPassword(password);
            try {
                user.setType("USER");
                userManager.addUser(user);
            ((HttpServletRequest)  req).getSession().setAttribute("user", user);
            ((HttpServletResponse) res).sendRedirect("/home");
            } catch (SQLException e) {
                req.setAttribute("errMessage", "Can't insert user into DB, please try again");
                req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, res);
            }
        } else {
            req.setAttribute("errMessage", errMessage);
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, res);
        }
    }
}
