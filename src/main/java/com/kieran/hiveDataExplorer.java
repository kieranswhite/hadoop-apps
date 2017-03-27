package com.kieran;

import java.sql.*;
import java.util.Scanner;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;



/**
 * Created by kiwhite on 19/02/2017.
 */
public class hiveDataExplorer {

    private Connection con;

    public hiveDataExplorer(Connection con){

        this.con = con;

    }




    public void explorer () throws ClassNotFoundException, SQLException{
        System.out.println("Explorer");


        System.out.println("Please Enter from the following options!");
        System.out.println("1 - Show databases");
        System.out.println("2 - Show tables");
        System.out.println("3 - Desc table");
        System.out.println("4 - Desc formatted table");
        System.out.println("Other - Quit");


        Scanner dEOption = new Scanner(System.in);

        int deOptionInt = dEOption.nextInt();


        switch (deOptionInt) {
            case 1:
                System.out.println(1);
                showDatabases();
                break;
            case 2:
                System.out.println(2);
                showTables();
                break;
            case 3:
                System.out.println(3);
                descTables();
                break;
            case 4:
                System.out.println(4);
                descTablesFormatted();
                break;
        }




    }

    public void showDatabases()throws SQLException,ClassNotFoundException{


        // Create the statement that will be used to query in HIVE.
        Statement stmt = con.createStatement();


        // Execute the statement.
        ResultSet res = stmt.executeQuery("show databases");

        ResultSetOutput.printResultSet(res);

        // Print out that confirms the table that has been dropped

        // Closing the connection to prevent a memory leak.
        con.close();

    }

    public void showTables ()throws SQLException,ClassNotFoundException{

        // Create the statement that will be used to query in HIVE.
        Statement stmt = con.createStatement();


        // Execute the statement.
       ResultSet res =  stmt.executeQuery("show tables");

        ResultSetOutput.printResultSet(res);



        // Print out that confirms the table that has been dropped

        // Closing the connection to prevent a memory leak.
        con.close();

    }



    public void descTables ()throws SQLException,ClassNotFoundException{

        // Create the statement that will be used to query in HIVE.
        Statement stmt = con.createStatement();

        System.out.println("Please enter your table name below!");

        Scanner tableInput = new Scanner(System.in);

        String tableName = tableInput.nextLine();

        // Execute the statement.

        // Print out that confirms the table that has been dropped
        // Execute the statement.
        ResultSet res = stmt.executeQuery("desc  " + tableName);

        ResultSetOutput.printResultSet(res);


        // Closing the connection to prevent a memory leak.
        con.close();

    }


    public void descTablesFormatted ()throws SQLException,ClassNotFoundException{

        // Create the statement that will be used to query in HIVE.
        Statement stmt = con.createStatement();

        System.out.println("Please enter your table name below!");

        Scanner tableInput = new Scanner(System.in);

        String tableName = tableInput.nextLine();

        // Execute the statement.
       ResultSet res = stmt.executeQuery("desc formatted " + tableName);

       ResultSetOutput.printResultSet(res);
        

        // Closing the connection to prevent a memory leak.
        con.close();

    }



}
