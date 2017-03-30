package com.kieran;

import java.sql.*;
import java.util.Scanner;




/**
 * Created by kiwhite on 19/02/2017.
 */
public class HiveDataExplorer {


    // Constructor to obtain connection details
    private Connection con;

    public HiveDataExplorer(Connection con){

        this.con = con;

    }


    public void explorer () throws ClassNotFoundException, SQLException{

        // Print lines showing the 5 options
        System.out.println("Explorer");


        System.out.println("Please Enter from the following options!");
        System.out.println("1 - Show databases");
        System.out.println("2 - Show tables");
        System.out.println("3 - Desc table");
        System.out.println("4 - Desc formatted table");
        System.out.println("Other - Quit");

        // New scanner to store tbe option picked by the user
        Scanner dEOption = new Scanner(System.in);

        // Setting the choice int equal to the next integer entered into the scanner
        int deOptionInt = dEOption.nextInt();

        // Switch case selecting the method chosen by the user
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

        // Print out the result of the show
        ResultSetOutput.printResultSet(res);

        // Closing the connection to prevent a memory leak.
        con.close();

    }

    public void showTables ()throws SQLException,ClassNotFoundException{

        // Create the statement that will be used to query in HIVE.
        Statement stmt = con.createStatement();

        // Execute the statement.
       ResultSet res =  stmt.executeQuery("show tables");

        // Print out the result of the show
        ResultSetOutput.printResultSet(res);

        // Closing the connection to prevent a memory leak.
        con.close();

    }



    public void descTables ()throws SQLException,ClassNotFoundException{

        // Create the statement that will be used to query in HIVE.
        Statement stmt = con.createStatement();

        System.out.println("Please enter your table name below!");

        // Scanner to take the table name for the user
        Scanner tableInput = new Scanner(System.in);

        // Setting the table name variable to the next string entered by the user
        String tableName = tableInput.nextLine();

        // Execute the statement.
        ResultSet res = stmt.executeQuery("desc  " + tableName);

        // Print out the result of the show
        ResultSetOutput.printResultSet(res);

        // Closing the connection to prevent a memory leak.
        con.close();

    }


    public void descTablesFormatted ()throws SQLException,ClassNotFoundException{

        // Create the statement that will be used to query in HIVE.
        Statement stmt = con.createStatement();

        System.out.println("Please enter your table name below!");

        // Scanner to take the table name for the user
        Scanner tableInput = new Scanner(System.in);
        // Setting the table name variable to the next string entered by the user
        String tableName = tableInput.nextLine();

        // Execute the statement.
        ResultSet res = stmt.executeQuery("desc formatted " + tableName);

        // Print out the result of the show
       ResultSetOutput.printResultSet(res);
        

        // Closing the connection to prevent a memory leak.
        con.close();

    }



}
