package com.alibaba.aliyun.crazyacking.spider.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    private static final Logger logger = LoggerFactory.getLogger(DBConnector.class.getName());
    public static String CONN_URL;
    public static String USERNAME;
    public static String PASSWORD;
    public static String DB_NAME;

    private DBConnector() {

    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String DBUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=" + DB_NAME + ";user=" + USERNAME + ";password=" + PASSWORD;
            conn = DriverManager.getConnection(DBUrl);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return conn;
    }
}
