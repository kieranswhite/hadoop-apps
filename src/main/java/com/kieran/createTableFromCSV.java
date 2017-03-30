package com.kieran;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * Created by kiwhite on 19/02/2017.
 */
public class CreateTableFromCSV {


    // Constructor to obtain connection details and HDFS configuration
    private Connection con;
    private Configuration conf;

    public CreateTableFromCSV(Connection con, Configuration conf){
        this.conf= conf;
        this.con = con;

    }



    public void create() throws SQLException, ClassNotFoundException, IOException {
        System.out.println("create");

        // Create the statement that will be used to query in HIVE.
        Statement stmt = con.createStatement();

        System.out.println("Please enter your table name below!");

        // Scanner to take the table name for the user
        Scanner tableInput = new Scanner(System.in);

        // Setting the table name variable to the next string entered by the user
        String tableName = tableInput.nextLine();

        System.out.println("Please enter the different fields for your CSV in the following format: Name STRING, Age INT, Wage Double");

        // Setting the fields string variable to the next string entered by the user
        String fieldsString = tableInput.nextLine();

        System.out.println("Please now enter the path to the CSV on this machine which you would like to use");
        System.out.println("E.G: C:/Users/Kieran/test.csv");

        // Setting the local file path variable to the next string entered by the user
        String csvPath = tableInput.nextLine();

        System.out.println("Please enter the different path for your CSV in HDFS ! Eg: /user/kieran/CSV");

        // Setting the HDFS folder variable to the next string entered by the user
        String newFolderPath = tableInput.nextLine();

        System.out.println("Please enter the filename for your file in HDFS. E.g: test.csv");

        // Setting the HDFS file name variable to the next string entered by the user
        String dataFile = tableInput.nextLine();

        // Creating a local path from the entered variable
        Path localFilePath = new Path (csvPath);

        // Creating a HDFS file path from the entered variables
        Path hdfsFilePath = new Path (newFolderPath + dataFile);


        // Excecute the  create statement.
        stmt.executeUpdate("CREATE EXTERNAL TABLE " + tableName + "(" + fieldsString + ") ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' STORED AS TEXTFILE LOCATION '" + newFolderPath +"'");

        // Print out that confirms the table that has been created
        System.out.println("Table " + tableName + " created.");

        // Closing the connection to prevent a memory leak.
        con.close();

        // Load the HDFS configuration
        FileSystem fs = FileSystem.get(conf);

        // Copy the local file to the specified HDFS location
        fs.copyFromLocalFile(localFilePath,hdfsFilePath);

    }

    }

