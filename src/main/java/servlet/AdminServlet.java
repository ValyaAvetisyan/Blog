package servlet;

import manager.CategoryManager;
import manager.PostManager;
import manager.UserManager;
import model.Category;
import model.Post;
import util.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet( urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String email = req.getParameter("email");
            if(!Validator.isEmpty(email)){
                UserManager userManager= new UserManager();
                if (userManager.isEmailExists(email)){

                }
            }
           //get categories
            CategoryManager categoryManager = new CategoryManager();
            List<Category> allCategories = categoryManager.getAllCategories();
            req.setAttribute("categories", allCategories);
            //get users
            UserManager userManager = new UserManager();
            req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
