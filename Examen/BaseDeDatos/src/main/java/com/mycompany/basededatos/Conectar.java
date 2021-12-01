/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author laura
 */
public class Conectar {
        public static final String URL = "jdbc:mysql://servidorifc.iesch.org:8882/cine_di";
    public static final String USER = "pasAlumno";
    public static final String PASS= "Admin1234";
    
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
