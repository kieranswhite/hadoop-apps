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
public class menu {






    public void menuMethod() throws SQLException, ClassNotFoundException, IOException {

        String driverName = "org.apache.hive.jdbc.HiveDriver";

        Class.forName(driverName);

        Connection con = DriverManager.getConnection("jdbc:hive2://127.0.0.1:10000/default", "cloudera", "");

        Configuration conf = new Configuration();

        conf.addResource(new Path("src/cfg/core-site.xml"));
        conf.addResource(new Path("src/cfg/hdfs-site.xml"));


        Scanner menu = new Scanner(System.in);

        int menuChoice = 0;

        while (menuChoice != 4) {

            System.out.println("Please pick from one of the following options below!");
            System.out.println("1 - Hive Data Explorer");
            System.out.println("2 - Create a table from a CSV");
            System.out.println("3 - Run a customer query");
            System.out.println("4- Quit");


            menuChoice = menu.nextInt();


            switch (menuChoice) {
                case 1:
                    System.out.println(1);
                    hiveDataExplorer hDE = new hiveDataExplorer(con);
                    hDE.explorer();
                    break;
                case 2:
                    System.out.println(2);
                    createTableFromCSV cRFS = new createTableFromCSV(con,conf);
                    cRFS.create();
                    break;
                case 3:
                    System.out.println(3);
                    runCustomQuery rCQ = new runCustomQuery(con);
                    rCQ.query();
                    break;
                case 4:
                    System.out.println(4);
                    break;
            }
        }
    }
}
