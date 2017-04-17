/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * version local
 */
public class MysqlConnection {


    private static String url = "jdbc:mysql://localhost/gsb_ppe";
    private static String user = "root";
    private static String passwd = "";
    Connection conn = null;

    public static Connection ConnectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            return null;
        }

    }
}
