package com.kieran;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;


//import org.apache.hadoop.fs.FileSystem;
//import org.apache.hadoop.fs.Path;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.shell.FsCommand;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


import org.apache.hadoop.hdfs.*;



/**
 * Created by kiwhite on 19/02/2017.
 */
public class createTableFromCSV {

    private Connection con;
    private Configuration conf;

    public createTableFromCSV(Connection con, Configuration conf){
        this.conf= conf;
        this.con = con;

    }



    public void create() throws SQLException, ClassNotFoundException, IOException {
        System.out.println("create");


        // This method will create the table nameage with 2 fields: Name and AGE.

            // Get the connection using the specified parameters.

            // Create the statement that will be used to query in HIVE.
            Statement stmt = con.createStatement();


        System.out.println("Please enter your table name below!");

        Scanner tableInput = new Scanner(System.in);

        String tableName = tableInput.nextLine();

        System.out.println("Please enter the different fields for your CSV in the following format: Name STRING, Age INT, Wage Double");

        String fieldsString = tableInput.nextLine();







        System.out.println("Please now enter the path to the CSV on this machine which you would like to use");
        System.out.println("E.G: C:/Users/Kieran/test.csv");

        String csvPath = tableInput.nextLine();


        System.out.println("Please enter the different path for your CSV in HDFS ! Eg: /user/kieran/CSV");

        String newFolderPath = tableInput.nextLine();

        System.out.println("Please enter the filename for your file in HDFS. E.g: test.csv");

        String dataFile = tableInput.nextLine();

        Path localFilePath = new Path (csvPath);

        Path hdfsFilePath = new Path (newFolderPath + dataFile);



        // Excecute the statement.
        stmt.executeUpdate("CREATE EXTERNAL TABLE " + tableName + "(" + fieldsString + ") ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' STORED AS TEXTFILE LOCATION '" + newFolderPath +"'");

        // Print out that confirms the table that has been created
        System.out.println("Table " + tableName + " created.");

        // Closing the connection to prevent a memory leak.
        con.close();


        FileSystem fs = FileSystem.get(conf);

        fs.copyFromLocalFile(localFilePath,hdfsFilePath);




    }













    }

