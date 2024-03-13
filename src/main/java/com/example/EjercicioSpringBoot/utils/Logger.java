package com.example.EjercicioSpringBoot.utils;

import com.example.EjercicioSpringBoot.controller.Controller;
import org.apache.logging.log4j.LogManager;

public class Logger {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Controller.class);

    public static Logger getLogger() {
        return (Logger) logger;
    }

    public void trace(String message){
        logger.trace(message);
    }

    public void debug(String message){
        logger.debug(message);
    }

    public void info(String message){
        logger.info(message);
    }

    public void warn(String message){
        logger.warn(message);
    }

    public void error(String message){
        logger.error(message);
    }

    public void fatal(String message){
        logger.fatal(message);
    }

}
