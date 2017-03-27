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

    // Initialise logger for the application

    //static Logger logger = Logger.getLogger(HiveTest.class);


    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, URISyntaxException {

        log4J.createLogger();

        // Initialise new instance of the main menu
        Menu men = new Menu();

        // Call the main menu method
        men.menuMethod();


    }



}





