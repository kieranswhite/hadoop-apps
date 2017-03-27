package com.kieran;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by KIWHITE on 21/03/2017.
 */
public class log4J {

    public static void createLogger() {

        Logger logger = Logger.getLogger(log4J.class);

        //DOMConfigurator is used to configure logger from xml configuration file
        DOMConfigurator.configure("src/cfg/log4j-config.xml");

        //LDebug to confirm logger is working
        logger.debug("Log4j  configuration is correct !");


    }

}