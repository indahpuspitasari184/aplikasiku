/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.*;
import com.mysql.jdbc.Driver;

/**
 *
 * @author indy
 */
public class konek {
    private static Connection konek;
    public static Connection getConnection() throws SQLException{
     if (konek == null){
         new Driver();
         konek = DriverManager.getConnection("jdbc:mysql://localhost:3306/depot","root","");
     }
     return konek;
    }
    public static void main(String args[]){
        try{
            getConnection();
            konek c = new konek();
            System.out.println("koneksi berhasil");
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("koneksi gagal");
        }
    }
}
