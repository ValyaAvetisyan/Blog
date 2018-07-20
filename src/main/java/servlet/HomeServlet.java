package servlet;


import manager.CategoryManager;
import manager.PostManager;
import model.Category;
import model.Post;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomeServlet  extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            PostManager postManager = new PostManager();
            List<Post> allPosts = postManager.getAllPosts();
            req.setAttribute("posts",allPosts);

            req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req,res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
