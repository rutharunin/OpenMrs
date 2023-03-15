package com.test.openMRS.jdbc;

import com.test.openMRS.api.RegisterPatientAPI;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import utils.JDBC.JDBCUtils;

import java.sql.*;

public class ValidateCreatePersonJDBC {


    private Connection con;
    private ResultSet rs;
    private Statement stmt;

    public void createResultSet(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://codefish.ninja:3306/openmrs","openmrs","Admin123");
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from person_name");
        }catch(Exception e){ System.out.println(e);
        }
    }
    public void createPersonTest(String first_name) {
        createResultSet();
        try {
            while (rs.next()) {
                if (rs.getString("uuid").equalsIgnoreCase(RegisterPatientAPI.personID)) {
                    Assert.assertEquals(first_name, rs.getString(first_name));
                    break;
                }
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deletePersonTest(){
        createResultSet();
        try {
            PreparedStatement p=con.prepareStatement("delete from person_name where given_name='Baks'");
            p.execute();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void validateDeletePerson(){
        createResultSet();
        try {
            Boolean personGone=false;
            while (rs.next()) {
                if (!rs.getString("uuid").equalsIgnoreCase(RegisterPatientAPI.personID)) {
                    personGone=true;
                }else personGone=false;
            } Assert.assertTrue(personGone);
            JDBCUtils.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
