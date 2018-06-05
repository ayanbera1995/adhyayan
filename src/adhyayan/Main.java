/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adhyayan;

import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Ayan Bera
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName()
            );
        } 
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
           // handle exception
           javax.swing.JOptionPane.showMessageDialog(null, "Error running software.\nContact administrator.",
                   "Error!", JOptionPane.ERROR_MESSAGE);
           System.exit(0);
        }
        
        adhyayan.view.Splash sp = new adhyayan.view.Splash();
        sp.setVisible(true);
        
        Timer t4 = new Timer( 500, (ActionEvent e) -> {
            sp.dispose();
            adhyayan.view.DesktopPane.main(args);
        });
        t4.setRepeats( false );
        
        Timer t3 = new Timer( 500, (ActionEvent e) -> {
            sp.addText("Opening Application...Please Wait");
            t4.start();
            
        });
        t3.setRepeats( false );
        
        Timer t2 = new Timer( 2000, (ActionEvent e) -> {
            try {
                Class.forName("java.sql.DriverManager");
                DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12241247",
                        "sql12241247", "lJBsAFYLUh");
                sp.addText("Connection Successfull.");
                t3.start();
            } catch (ClassNotFoundException | SQLException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Cannot connect to Database."
                        + "\nCheck your Internet Connection or Contact administrator.",
                   "Error!", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        });
        t2.setRepeats(false);
        
        Timer t1 = new Timer( 500, (ActionEvent e) -> {
            sp.addText("Connecting to Database...");
            t2.start();
        });
        t1.setRepeats( false );
        t1.start();
    }
}
