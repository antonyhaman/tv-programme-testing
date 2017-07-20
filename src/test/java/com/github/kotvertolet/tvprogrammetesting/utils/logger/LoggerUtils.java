package com.github.kotvertolet.tvprogrammetesting.utils.logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerUtils {

    private static boolean isConfigured = false;

    private static final String PATH_TO_RESOURCES = "src/test/resources/";
    private static final String PATH_TO_LOGGER_PROPERTIES = PATH_TO_RESOURCES + "properties/logging.properties";
    private static Logger LOG = LoggerUtils.getLogger(LoggerUtils.class.getName());

    public static Logger getLogger(String name) {
        if (!isConfigured) {
            configure();
        }
        return Logger.getLogger(name);
    }

    private static void configure() {
        try(InputStream is = new FileInputStream(PATH_TO_LOGGER_PROPERTIES)) {
            LogManager.getLogManager().readConfiguration(is);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        isConfigured = true;
    }
}
