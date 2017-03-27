package com.kieran;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by KIWHITE on 21/03/2017.
 */
public class log4j

    {
        static Logger logger = Logger.getLogger(log4j.class);

        public static void main(String[] args)
        {
            //DOMConfigurator is used to configure logger from xml configuration file
            DOMConfigurator.configure("cfg/log4j-config.xml");

            //Log in console in and log file
            logger.debug("Log4j appender configuration is successful !!");
        }
    }

