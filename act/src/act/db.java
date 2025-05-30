/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author USER
 */
public class db{
     private static Connection Myconnection;

    public static void init() {
        try {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {

                System.out.println("Class not found");
            }
            Myconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store3?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false", "root", "ulysses3412");
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public static Connection getConnection() {
        if (Myconnection != null) {
            return Myconnection;
        } else {
            try {

                Myconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false", "root", "");

            } catch (Exception ex) {

            }
        }
        return Myconnection;

    }

    public static void close(ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }
}


