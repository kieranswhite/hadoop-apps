package com.kieran;

import java.sql.*;
import java.util.Scanner;


/**
 * Created by kiwhite on 19/02/2017.
 */
public class RunCustomQuery {

    // Constructor to obtain connection details
    private Connection con;


    public RunCustomQuery(Connection con){

        this.con = con;

    }


    public void query() throws SQLException,ClassNotFoundException {
        System.out.println("query");

        // Create the statement that will be used to query in HIVE.
        Statement stmt = con.createStatement();

        System.out.println("Please type your query below!");

        // Scanner to take the custom query input
        Scanner queryInput = new Scanner(System.in);

        // Setting the query string variable to the next line entered by the user
        String queryString = queryInput.nextLine();

        // Execute the statement
        ResultSet res = stmt.executeQuery(queryString);

        // Print out that confirms the table that has been dropped
        ResultSetOutput.printResultSet(res);

        // Closing the connection to prevent a memory leak.
        con.close();

    }
}
