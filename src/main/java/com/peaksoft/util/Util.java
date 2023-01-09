package com.peaksoft.util;

import com.peaksoft.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "postgres";

    public static Connection connection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Connected to the SQL");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    public  static SessionFactory getSessionFactory(){
            try {
                Properties prop = new Properties();
                prop.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/postgres");
                prop.setProperty("hibernate.connection.username", "postgres");
                prop.setProperty("hibernate.connection.password", "postgres");
                prop.setProperty("dialect", "org.hibernate.dialect.PostgreSQL10Dialect");

                prop.setProperty("hibernate.hbm2ddl.auto", "update");

                return new Configuration()
                        .addProperties(prop)
                        //.addPackage("com.kat")
                        .addAnnotatedClass(User.class)
                        .buildSessionFactory();
            }
            catch (Exception ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }
}


