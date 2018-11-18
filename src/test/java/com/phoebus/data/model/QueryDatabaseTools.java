package com.phoebus.data.model;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 */
public class QueryDatabaseTools {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:fsb;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    private static final String SelectAllTemplate = "select * from %s";

    public static <T> List<T> tableContent(String tableName, Class<T> type) {

        try {
            QueryRunner runner = new QueryRunner();
            Connection connection = getDBConnection();

            ResultSetHandler<List<T>> h = new BeanListHandler<T>(type);

            return runner.query(connection, String.format(SelectAllTemplate, tableName), h);
        }
        catch (SQLException e) {
            return null;
        }
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
