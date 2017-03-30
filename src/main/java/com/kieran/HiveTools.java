package com.kieran;

/**
 * Created by Kieran White on 08/04/16.
 */


import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;


public class HiveTools {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, URISyntaxException {

        Log4J.createLogger();

        // Initialise new instance of the main menu
        Menu men = new Menu();

        // Call the main menu method
        men.menuMethod();


    }



}





