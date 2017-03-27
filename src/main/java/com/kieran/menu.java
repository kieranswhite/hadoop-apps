package com.kieran;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

/**
 * Created by kiwhite on 19/02/2017.
 */
public class Menu {



    public void menuMethod() throws SQLException, ClassNotFoundException, IOException {


        // Set the driver name for HIVE
        String driverName = "org.apache.hive.jdbc.HiveDriver";

        Class.forName(driverName);

        // Set connection string details (IP and database name)
        Connection con = DriverManager.getConnection("jdbc:hive2://127.0.0.1:10000/default", "cloudera", "");

        // Initialise new HDFS configuration

        Configuration conf = new Configuration();

        // Add the HDFS and CORE SITE XML's for configuration
        conf.addResource(new Path("src/cfg/core-site.xml"));
        conf.addResource(new Path("src/cfg/hdfs-site.xml"));


        // Create new scanner to collect options
        Scanner menu = new Scanner(System.in);

        // Set menu choice integer to 0
        int menuChoice = 0;

        // While loop that loops as long as the menu choice not equal to 4 and exits

        while (menuChoice != 4) {

            // Print of each of the options
            System.out.println("Please pick from one of the following options below!");
            System.out.println("1 - Hive Data Explorer");
            System.out.println("2 - Create a table from a CSV");
            System.out.println("3 - Run a customer query");
            System.out.println("4 - Quit");

            // Setting the menu choice made by the user equal to an int
            menuChoice = menu.nextInt();

            // Switch case which calls the class chosen by the user based on the value of the choice integer
            switch (menuChoice) {
                case 1:
                    System.out.println(1);
                    HiveDataExplorer hDE = new HiveDataExplorer(con);
                    hDE.explorer();
                    break;
                case 2:
                    System.out.println(2);
                    CreateTableFromCSV cRFS = new CreateTableFromCSV(con,conf);
                    cRFS.create();
                    break;
                case 3:
                    System.out.println(3);
                    RunCustomQuery rCQ = new RunCustomQuery(con);
                    rCQ.query();
                    break;
                case 4:
                    System.out.println(4);
                    break;
            }
        }
    }
}
