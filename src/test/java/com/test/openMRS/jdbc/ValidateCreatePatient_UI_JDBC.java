package com.test.openMRS.jdbc;

import com.test.openMRS.api.RegisterPatientAPI;
import com.test.openMRS.pages.FindPatientRecordPage;
import org.junit.Assert;
import utils.JDBC.JDBCUtils;

import java.sql.*;

public class ValidateCreatePatient_UI_JDBC {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public void createResultSet(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://codefish.ninja:3306/openmrs","openmrs","Admin123");
            stmt=con.createStatement();
            rs=stmt.executeQuery("select identifier from patient_identifier");
        }catch(Exception e){ System.out.println(e);
        }
    }
    public void validateCreatePatientTest() {
        createResultSet();
        try {
            boolean patientCreated=false;
            while (rs.next()) {
                if (FindPatientRecordPage.getPatientID().contains(rs.getString("identifier"))) {
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
            PreparedStatement p=con.prepareStatement("delete from patient_identifier where identifier="+FindPatientRecordPage.getPatientID());
            p.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void closeDatabaseConnection(){
        JDBCUtils.closeConnection();
    }
}
