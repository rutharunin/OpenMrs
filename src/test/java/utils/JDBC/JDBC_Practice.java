package utils.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBC_Practice {
    public static void main(String[] args) throws SQLException {


    /*
    Connection >> helps to provide BD credentials and connects to DB
    Statement >> to define our connections to get the result from database
    resultSet >> we execute the SQL query and store the output
     */

        Connection connection= DriverManager.getConnection(
                "jdbc:oracle:thin:@codefishdatabase-1.cfxmtijfjb4b.us-east-2.rds.amazonaws.com:1521/ORCL",
                "student",
                "codefish385"
        );
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("select * from employees");

        resultSet.next(); // it will go to the next row in the result set and it will return true and go to the next row

        System.out.println(resultSet.getString(3));//providing the index for getString() will take the column value on that index
        System.out.println(resultSet.getString("first_name"));//getString() can also accept column name

        resultSet.next();
        System.out.println(resultSet.getString("first_name"));

        resultSet.last(); // it will give the last row from result set
        //resultSet.first(); goes to the first row
        //resultSet.beforeFirst(); goes to the header/column name rows

        System.out.println(resultSet.getString("last_name"));

        System.out.println(resultSet.getRow());//it will return the row number in which resultSet is pointing to

        resultSet.beforeFirst();

        ResultSetMetaData resultSetMetaData= resultSet.getMetaData();
        //METADATA= data about data
        System.out.println(resultSetMetaData.getColumnCount());

        System.out.println(resultSetMetaData.getColumnName(1));


        System.out.println("=======================================");
        for (int i=1; i<=resultSetMetaData.getColumnCount();i++){
            System.out.println(resultSetMetaData.getColumnName(i));
        }
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("The below is to transfer data from resultSet to a list of map");

        List<Map<String,Object>> employeeData=new ArrayList<>();
        resultSet.beforeFirst();//to make sure it goes to the header row b4 iteration
        while(resultSet.next()){
            Map<String, Object> employee = new LinkedHashMap<>();
            for(int i=1;i<resultSetMetaData.getColumnCount();i++){
                employee.put(resultSetMetaData.getColumnName(i),resultSet.getObject(i));

            }

            employeeData.add(employee);

        }
        System.out.println(employeeData.get(2).get("EMAIL"));
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("The below is to show how to extract data from the list of map");
        for (int i=0;i<employeeData.size();i++){
            System.out.println(employeeData.get(i).get("FIRST_NAME").toString()+" "+employeeData.get(i).get("LAST_NAME"));

        }

    }
}