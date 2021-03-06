/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.basededatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author laura
 */
public class Peliculas extends javax.swing.JFrame {
    //Creamos la variable para todo el programa donde guardaremos la conexcion con la base de datos
    Conectar conectar = null;

    /**
     * Creates new form Peliculas
     */
    public Peliculas() {
        initComponents();
        //Cargamos la tabla
        tablaPantalla();
    }
    
    
    
    private void tablaPantalla(){
        //Crear el default table model
        DefaultTableModel dtm = new DefaultTableModel();
        //Añadir a las columnas de la tabla
        dtm.setColumnIdentifiers(new String[]{"id","First name","Last name","Job"});
        //Añadimos la tabla el dtm creado
        jTable.setModel(dtm); 
        
        //ACCESO A BASE DE DATOS 
        //Conectamos con la base de datos
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        //Creamos una array donde guardamos todo lo leido de la base de datos
        // le pasamos 8 por que ahora leemos 8 columnas
        String[] examen = new String[4];
        //Si la conexion esta bien echa
        if (conexion != null) {
            try {
                //Creamos el statement
                Statement s = conexion.createStatement();
                //Hacemos la consulta
                ResultSet rs = s.executeQuery ("select * from examen;");
                 
                //Mientras hayan datos 
                while (rs.next()) {
                    //dtm.addRow(rs);
                    //Los metemos en el array que hemos creado antes segun la posicion de la columna
                    examen[0]= rs.getString(1);
                    examen[1]= rs.getString(2);
                    examen[2]= rs.getString(3);
                    examen[3]= rs.getString(4);

                   
                    // Y los vamos añadiendo a las filas de la tabla
                    dtm.addRow(examen);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Datos no encontrados");
            }           
        }
        //Si la conexion es fallida saltara mensaje
        else{
            JOptionPane.showMessageDialog(this, "Conoxion fallida");
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
