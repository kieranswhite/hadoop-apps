package com.kieran;

/**
 * Created by Kieran White on 08/04/16.
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HiveTest {

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static String tableName = "nameage";

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, URISyntaxException {

        // Register driver and create driver instance
        Class.forName(driverName);


        dropIfExists();
        createTable();
        queryTable();
        //modifyResults();
        writeResultsToCSV(modifyResults());


    }


    private static void dropIfExists() throws SQLException {

        // get connection
        Connection con = DriverManager.getConnection("jdbc:hive2://127.0.0.1:10000/kierandb", "kieran", "");

        // create statement
        Statement stmt = con.createStatement();

        // Table Name


        // execute statement
        stmt.executeUpdate("DROP TABLE IF EXISTS " + tableName + "");


        System.out.println("Table " + tableName + " dropped if it existed.");
        con.close();

    }

    private static void createTable() throws SQLException {

        // get connection
        Connection con = DriverManager.getConnection("jdbc:hive2://127.0.0.1:10000/kierandb", "kieran", "");

        // create statement
        Statement stmt = con.createStatement();

        // Table Name


        // execute statement
        stmt.executeUpdate("CREATE EXTERNAL TABLE " + tableName + "(Name STRING, Age INT) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' STORED AS TEXTFILE LOCATION '/user/kieran/CSV'");


        System.out.println("Table " + tableName + " created.");
        con.close();

    }


    public static void queryTable() throws SQLException {


        Connection con = DriverManager.getConnection("jdbc:hive2://127.0.0.1:10000/kierandb", "kieran", "");

        Statement stmt = con.createStatement();

        ResultSet res = stmt.executeQuery("select * from " + tableName + "");

        while (res.next()) {
            System.out.println(String.valueOf(res.getString(1)) + "\t" + res.getInt(2));
        }

        con.close();


    }

    public static List modifyResults() throws ClassNotFoundException, SQLException, IOException, URISyntaxException {

        List<Record> records = new ArrayList<>();


        Connection con = DriverManager.getConnection("jdbc:hive2://127.0.0.1:10000/kierandb", "kieran", "");

        Statement stmt = con.createStatement();

        ResultSet res = stmt.executeQuery("select * from " + tableName + "");

        while (res.next()) {

            Record rc = new Record();

            String name = String.valueOf(res.getString(1));

            int age = res.getInt(2);

            rc.setNameAndAge(" " + name + " is " + age + " years old");
            System.out.println(rc.getNameAndAge());

            records.add(rc);
        }
        return records;


    }

    public static void writeResultsToCSV(List<Record> records) throws IOException, ClassNotFoundException, SQLException, URISyntaxException {

        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();

        conf.addResource(new Path("/home/kieran/IdeaProjects/hivejdbc-master-xps/hdfs-site.xml"));

        conf.set("fs.hdfs.impl",
                org.apache.hadoop.hdfs.DistributedFileSystem.class.getName()
        );
        conf.set("fs.file.impl",
                org.apache.hadoop.fs.LocalFileSystem.class.getName()
        );

        FileSystem fs = FileSystem.get(new URI("hdfs://127.0.0.1:8020"), conf);

        Path pt = new Path("hdfs://127.0.0.1:8020/user/kieran/test.csv");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fs.create(pt, true)));

        for (Record rc : records) {
        bw.write(
                rc.getNameAndAge()
        );
        bw.newLine();
    }
    bw.close();

            //System.out.println(rc.getNameAndAge());
        }

    }





