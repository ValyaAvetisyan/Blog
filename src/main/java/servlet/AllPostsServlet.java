package servlet;

import manager.PostManager;
import model.Post;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/allPosts")
public class AllPostsServlet  extends HttpServlet{
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        PostManager postManager= new PostManager();
        try {
            List<Post> allPosts = postManager.getAllPosts();
            req.setAttribute("posts",allPosts);
            req.getRequestDispatcher("WEB_INF/post.jsp");
        } catch (SQLException e){
            e.printStackTrace();

        }
    }
}
