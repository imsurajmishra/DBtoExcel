package dao;

import connection.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewsArticleDao {

    public ResultSet getNewsArticles(String sqlQuery) throws SQLException {
        Connection connection = JDBCConnection.connect();
        Statement statement = connection.createStatement();
        return statement.executeQuery(sqlQuery);
    }
}
