package utils.JDBC;

import org.junit.Assert;

import java.util.*;

public class JDBCPracticeUtils {
    public static void main(String[] args) {
        JDBCUtils.establishConnection();
        List<Map<String, Object>> regionsData = JDBCUtils.executeQuery("select * from regions");
        System.out.println(regionsData.get(2).get("REGION_NAME"));
        Assert.assertEquals("Asia", regionsData.get(2).get("REGION_NAME"));

        List<Map<String, Object>> countriesData = JDBCUtils.executeQuery("select * from countries");

        for (int i = 0; i < countriesData.size(); i++) {
            System.out.println(countriesData.get(i).get("COUNTRY_NAME"));
        }

        //test case: validate table "regions" has 2 columns
        //test case: validate those column names are : REGION_ID and REGION_NAME

        int expectedColumnCount = 2;
        String[] expectedColumnNames = {"REGION_ID", "REGION_NAME"};
        System.out.println("============================================");
        System.out.println("my test");

        List listOfExpectedColumnName=Arrays.asList("COUNTRY_ID","COUNTRY_NAME","REGION_ID");
        List listOfActualColumnName=new ArrayList(countriesData.get(0).keySet());
        for (int i=0;i<listOfExpectedColumnName.size();i++){
            Assert.assertEquals(listOfExpectedColumnName.get(i),listOfActualColumnName.get(i));

        }
        System.out.println("============================================");

        int actualColumnCount = regionsData.get(0).size();
        System.out.println(actualColumnCount);

        Set actualColumnNames1 = regionsData.get(0).keySet();
        System.out.println(actualColumnNames1);

        String[] actualColumnNames = regionsData.get(0).keySet().toArray(new String[0]);
        System.out.println(Arrays.toString(actualColumnNames));

        Assert.assertEquals("Column count is not matching", expectedColumnCount, actualColumnCount);
        for (int i = 0; i < expectedColumnNames.length; i++) {
            Assert.assertEquals("Column name is not matching", expectedColumnNames, actualColumnNames);
        }
        JDBCUtils.closeConnection();
    }
}