package com.test.openMRS.jdbc;

import com.test.openMRS.api.RegisterPatientAPI;
import org.junit.Assert;
import utils.JDBC.JDBCUtils;

import java.sql.*;

public class ValidateCreatePatient_API_JDBC {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public void createResultSet(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://codefish.ninja:3306/openmrs","openmrs","Admin123");
            stmt=con.createStatement();
            rs=stmt.executeQuery("select uuid from patient_identifier");
        }catch(Exception e){ System.out.println(e);
        }
    }
    public void validateCreatePatientTest() {
        createResultSet();
        try {
            boolean patientCreated=false;
            while (rs.next()) {
                if (rs.getString("uuid").equalsIgnoreCase(RegisterPatientAPI.getPatientUUID())) {
                    patientCreated=true;
                    break;
                }
            }
            Assert.assertTrue(patientCreated);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deletePatientTest(){
        createResultSet();
        try {
            PreparedStatement p=con.prepareStatement("delete from patient_identifier where uuid="+RegisterPatientAPI.getPatientUUID());
            p.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void validateDeletePatient(){
        createResultSet();
        try {
            Boolean personGone=false;
            while (rs.next()) {
                if (!rs.getString("uuid").equalsIgnoreCase(RegisterPatientAPI.getPatientUUID())) {
                    personGone=true;
                }else {personGone=false;
                }
            } Assert.assertTrue(personGone);
            JDBCUtils.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
