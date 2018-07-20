package manager;

import db.DBConnectionProvider;
import model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostManager {
    private Connection connection;

    public PostManager() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void add(Post post) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO post(title,text,category_id,user_id,pic_url) values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, post.getTitle());
        preparedStatement.setString(2, post.getText());
        preparedStatement.setInt(3, post.getCategoryId());
        preparedStatement.setInt(4, post.getUserId());
        preparedStatement.setString(5, post.getPicUrl());
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int id = generatedKeys.getInt(1);
            post.setId(id);
        }
    }

    public List<Post> getAllPosts() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM post");
        List<Post> posts = new ArrayList<>();
        while (resultSet.next()) {
            Post post = new Post();
            post.setId(resultSet.getInt(1));
            post.setTitle(resultSet.getString(2));
            post.setText(resultSet.getString(3));
            post.setCategoryId(resultSet.getInt(4));
            post.setUserId(resultSet.getInt(5));
            post.setPicUrl(resultSet.getString(6));
            post.setTimestamp(resultSet.getString(7));
            posts.add(post);
        }
        return posts;
    }

}
