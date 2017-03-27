package com.kieran;

/**
 * Created by Kieran White on 08/04/16.
 */


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;


public class HiveTest {


         static Logger logger = Logger.getLogger(HiveTest.class);


    // Set the driver name and table name variables for use later on.
   // public static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, URISyntaxException {


        //DOMConfigurator is used to configure logger from xml configuration file
        DOMConfigurator.configure("src/cfg/log4j-config.xml");

                //Log in console in and log file
        logger.debug("Log4j appender configuration is successful !!");

    menu men = new menu();
        men.menuMethod();


    }

    }





