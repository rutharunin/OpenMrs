package utils.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static ResultSetMetaData resultSetMetaData;

    public static void establishConnection() {

        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@codefishdatabase-1.cfxmtijfjb4b.us-east-2.rds.amazonaws.com:1521/ORCL",
                    "student",
                    "codefish385"
            );

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, Object>> executeQuery (String query) {

        List<Map<String, Object>> listOfData = new ArrayList<>();
        try {
            resultSet = statement.executeQuery(query);
            resultSetMetaData = resultSet.getMetaData();

            resultSet.beforeFirst();
            while(resultSet.next()) {

                Map<String, Object> singleRecord = new LinkedHashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    singleRecord.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
                }

                listOfData.add(singleRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  listOfData;
    }

    // get total number of rows returned per result set
    public static int getRowCount() {
        int count = 0;

        try {
            resultSet.last();
            count = resultSet.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    // close connection for security purposes
    public static void closeConnection () {
        try {
            if (connection!=null) {
                connection.close();
            }
            if (statement!=null) {
                statement.close();
            }
            if (resultSet!=null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
