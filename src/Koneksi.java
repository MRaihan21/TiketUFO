package Aplikasi.Ufo;

import java.sql.*;

public class Koneksi {

    public static Connection getKoneksi(){
        
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_tiketufo", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
     
        return con;
    }
    
}

