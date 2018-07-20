package servlet;

import manager.CategoryManager;
import model.Category;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/addCategory")
public class AddCategoryServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {


        String name = req.getParameter("name");
        Category category = new Category();
        category.setName(name);
        CategoryManager categoryManager = new CategoryManager();
        try

        {
            categoryManager.addCategory(category);
            ((HttpServletResponse) res).sendRedirect("/admin");
        } catch (SQLException e){

            e.printStackTrace();
    }
}}