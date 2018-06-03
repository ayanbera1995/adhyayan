/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adhyayan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ayan Bera
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Class.forName("java.sql.DriverManager");
            Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12241247",
                    "sql12241247", "lJBsAFYLUh");
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM login;");
            
            while(rs.next()) {
                System.out.println(rs.getString("user")+" "+rs.getString("pwd"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
