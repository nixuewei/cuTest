package com.cucumber.framework.config;

import com.cucumber.framework.utilities.LogUtil;
import com.cucumber.framework.base.BrowserType;

import java.sql.Connection;

public class Settings {
    public static Connection DBConnection;
    public static String DBConnectionString;

    public static String LogPath;
    public static String ExcelSheetPath;
    public static String DriverType;
    public static String AUT;


    public static BrowserType BrowserType;

    public static LogUtil Logs;


}
