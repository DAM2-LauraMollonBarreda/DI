package baseDatos;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author damA
 */
public class Conectar {
    public static final String URL = "jdbc:mysql://servidorifc.iesch.org:3306/mantenimiento_mollon";
    public static final String USER = "2_mollon_l";
    public static final String PASS= "20e5w";
    
    public Connection getConexion(){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
               System.out.println("ERROR: " + ex.getMessage());
        } 
                
        
        return con;
    }
}
