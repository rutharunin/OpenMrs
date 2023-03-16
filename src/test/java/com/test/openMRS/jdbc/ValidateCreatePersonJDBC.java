package com.test.openMRS.jdbc;

import com.test.openMRS.api.RegisterPatientAPI;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import utils.JDBC.JDBCUtils;

import java.sql.*;

public class ValidateCreatePersonJDBC {


    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private String uuid;
    private String person_id;

    public void createResultSet(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://codefish.ninja:3306/openmrs","openmrs","Admin123");
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from person\n" +
                    "join person_name on person.person_id = person_name.person_id;");
        }catch(Exception e){ System.out.println(e);
        }
    }
    public void createPersonTest(String f_name) {
        createResultSet();
        System.out.println("API UUID "+RegisterPatientAPI.getPersonID());
        try {
            boolean personCreated=false;
            while (rs.next()) {
                if (rs.getString("person.uuid").equalsIgnoreCase(RegisterPatientAPI.getPersonID())) {
                    person_id=rs.getString("person.person_id");
                    uuid=RegisterPatientAPI.getPersonID();
                    personCreated=true;
                    break;
                }
            }
            Assert.assertTrue(personCreated);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deletePersonTest(String firstName, String lastName){
        createResultSet();
        try {
            PreparedStatement p=con.prepareStatement("delete from person_name where given_name='"+firstName+"' and family_name='"+lastName+"'");
            p.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void validateDeletePerson(String firstName,String lastName){
        createResultSet();
        try {
            Boolean personGone=false;
            while (rs.next()) {
                if (!rs.getString("person_name.given_name").equalsIgnoreCase(firstName)&&
                        !rs.getString("person_name.family_name").equalsIgnoreCase(lastName)) {
                    personGone=true;
                }else {personGone=false;
                }
            } Assert.assertTrue(personGone);
            JDBCUtils .closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
