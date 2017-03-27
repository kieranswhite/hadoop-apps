package com.kieran;

import java.sql.*;
import java.util.Scanner;


/**
 * Created by kiwhite on 19/02/2017.
 */
public class runCustomQuery {


    private Connection con;


    public runCustomQuery(Connection con){

        this.con = con;

    }


    public void query() throws SQLException,ClassNotFoundException {
        System.out.println("query");

        // Create the statement that will be used to query in HIVE.
        Statement stmt = con.createStatement();


        System.out.println("Please type your query below!");

        Scanner queryInput = new Scanner(System.in);

        String queryString = queryInput.nextLine();

        // Execute the statement.


        ResultSet res = stmt.executeQuery(queryString);
        // Print out that confirms the table that has been dropped

        ResultSetOutput.printResultSet(res);

        // Closing the connection to prevent a memory leak.
        con.close();

    }
}
