package manager;

import db.DBConnectionProvider;
import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryManager {
    private Connection connection;

    public CategoryManager() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void addCategory(Category category) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT  INTO  category (name) VALUE (?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, category.getName());
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int id = generatedKeys.getInt(1);
            category.setId(id);
        }
    }

    public List<Category> getAllCategories() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from category");
        List<Category> categories = new ArrayList<Category>();
        while (resultSet.next()) {
            Category category = new Category();
            category.setId(resultSet.getInt(1));
            category.setName(resultSet.getString(2));
            categories.add(category);
        }
        return categories;
    }

    public boolean isCategoryExists(String category) {
//implementation  here

        return true;
    }
}
