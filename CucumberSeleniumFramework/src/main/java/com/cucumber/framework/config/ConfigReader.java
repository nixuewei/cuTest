package com.cucumber.framework.config;

import com.cucumber.framework.base.BrowserType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static void PopulateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.ReadProperty();
    }

    private void ReadProperty() throws IOException {
        Properties props  = new Properties();
        InputStream inputStream = new FileInputStream("src/main/java/com/cucumber/framework/config/GlobalConfig.properties");
        props.load(inputStream);

        Settings.DBConnectionString = props.getProperty("DBConnectionString");
        Settings.DriverType = props.getProperty("DriverType");
        Settings.LogPath = props.getProperty("LogPath");
        Settings.ExcelSheetPath = props.getProperty("ExcelSheetPath");
        Settings.DBConnection = null;

        Settings.AUT = props.getProperty("AUT");

        Settings.BrowserType = BrowserType.valueOf(props.getProperty("BrowserType"));

    }
}
