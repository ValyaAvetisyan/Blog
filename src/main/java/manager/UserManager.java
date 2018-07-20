package manager;

import db.DBConnectionProvider;
import model.User;

import java.sql.*;

public class UserManager {
    private Connection connection;
    private DBConnectionProvider provider;

    public UserManager() {
        provider = DBConnectionProvider.getInstance();
        connection = provider.getConnection();
    }
    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO user (name, surname, email, password, type)" + " VALUE(?,?,?,?,?)";
        PreparedStatement preparedStatement;

        preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5,user.getType());
        preparedStatement.executeUpdate();
        ResultSet resultSet= preparedStatement.getGeneratedKeys();
        if (resultSet.next()){
            user.setId(resultSet.getInt(1));
        }

    }

//    public void add(User user) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement
//                ("INSERT  INTO  user (name, surname, email, password, type) VALUE (? ? ? ? ? )",
//                        Statement.RETURN_GENERATED_KEYS);
//        preparedStatement.setString(1, user.getName());
//        preparedStatement.setString(2,user.getSurname());
//        preparedStatement.setString(3,user.getEmail());
//        preparedStatement.setString(4,user.getPassword());
//        preparedStatement.setString(5,user.getType());
//        preparedStatement.executeUpdate();
//        ResultSet resultSet= preparedStatement.getGeneratedKeys();
//        if (resultSet.next()){
//            user.setId(resultSet.getInt(1));
//        }
//    }
    public User getUserByUsernameAndPassword(String email, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where email = ? and password = ?");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setSurname(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));
            user.setPassword(resultSet.getString(5));
            user.setType(resultSet.getString(6));
            return user;
        }
        return null;
    }

    public boolean isEmailExists(String email) {
        String query = "SELECT count(*) FROM user WHERE email='" + email + "'";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to check email on db");
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
