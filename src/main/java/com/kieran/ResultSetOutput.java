package com.kieran;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by KIWHITE on 22/03/2017.
 */
public class ResultSetOutput {


    public static void printResultSet (ResultSet res)throws SQLException {


        // Retrieving the result set metadata
        ResultSetMetaData resSetMeta = res.getMetaData();

        // Obtaining the number of columns returned
        int numberOfColumns = resSetMeta.getColumnCount();

        // While loop for each row returned from the query
        while (res.next()) {

            // For loop printing the column name and value for each column
            for (int i = 1; i <= numberOfColumns; i++) {
                if (i > 1) System.out.print("| ");
                String dataValue = res.getString(i);
                //System.out.print(resSetMeta.getColumnName(i) + " " + dataValue);
                System.out.println("+------------------------+");
                System.out.println(resSetMeta.getColumnName(i));
                System.out.println("+------------------------+");
                System.out.println(dataValue);
                System.out.println("+------------------------+");

            }
            System.out.println("");
        }


    }
}