/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lauramollon.proyectosegundaeva_lmb;

import baseDatos.Conectar;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.mysql.cj.xdevapi.Result;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.commons.codec.digest.DigestUtils;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;

/**
 *
 * @author damA
 */
public class Autenticacion_pantalla extends javax.swing.JFrame {

    public static Scanner sn = new Scanner(System.in);
    Conectar contectar = null;

    /**
     * Creates new form Autenticacion_pantalla
     */
    public Autenticacion_pantalla() {
        initComponents(); 

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordFieldPassAutenticacion = new javax.swing.JPasswordField();
        jTextFieldUsuarioAutenticacion = new javax.swing.JTextField();
        jButtonEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 3, 18)); // NOI18N
        jLabel1.setText(" IES SEGUNDO DE CHOMON");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("Mantenimientos informaticos");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel3.setText("Usuario ");

        jLabel4.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel4.setText("Contraseña");

        jPasswordFieldPassAutenticacion.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jPasswordFieldPassAutenticacion.setText("1234");
        jPasswordFieldPassAutenticacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPasswordFieldPassAutenticacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldPassAutenticacionActionPerformed(evt);
            }
        });

        jTextFieldUsuarioAutenticacion.setFont(new java.awt.Font("Lucida Sans", 2, 14)); // NOI18N
        jTextFieldUsuarioAutenticacion.setText("pp");
        jTextFieldUsuarioAutenticacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioAutenticacionActionPerformed(evt);
            }
        });

        jButtonEntrar.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonEntrar)
                        .addGap(18, 18, 18)))
                .addGap(79, 79, 79))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordFieldPassAutenticacion)
                            .addComponent(jTextFieldUsuarioAutenticacion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(228, 228, 228))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldUsuarioAutenticacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordFieldPassAutenticacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButtonEntrar)
                .addGap(33, 33, 33))
        );

        setSize(new java.awt.Dimension(717, 362));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUsuarioAutenticacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioAutenticacionActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldUsuarioAutenticacionActionPerformed

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        //Guardo en varibles, lo escrito por el usuario
        String usu = jTextFieldUsuarioAutenticacion.getText();

        String arr = jPasswordFieldPassAutenticacion.getText();
        //Encripto las contraseñas
        String pass = DigestUtils.md5Hex(arr);

        //Si lo campos no estan vacios 
        if (!usu.isBlank() && !pass.isBlank()) {
            try {
                comprabarLoginBaseDatos(usu, pass);
            } catch (HeadlessException ex) {
                Logger.getLogger(Autenticacion_pantalla.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Autenticacion_pantalla.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No puedes dejar campos vacios");
        }


    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jPasswordFieldPassAutenticacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldPassAutenticacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldPassAutenticacionActionPerformed

    public void comprabarLoginBaseDatos(String usu, String pass) throws HeadlessException, SQLException {
        //Llamo a la clase para conectar 
        contectar = new Conectar();
        Connection conexion = contectar.getConexion();
        //Si la conexion no es nula
        if (conexion != null) {
            try {
                Statement s = conexion.createStatement();
                //Guardo la consulta para ejecutar
                ResultSet rs_login = s.executeQuery("select p.login,p.password,p.activo, rol.rol from fp_profesor p inner join fp_rol rol on rol.id_rol= p.id_rol where login = '" + usu + "'");

                //Variables para guardar el resultado de los datos cojidos de la base de datos
                String resultadoUsuBase = "";
                String resultadoPassBase = "";
                int resultadoActivoBase = 0;
                String rol = "";

                //Mientras queden datos que extraer
                while (rs_login.next()) {
                    //Guardar en cada una de las variables creadas antes los datos que se estan extrallendo
                    resultadoUsuBase = rs_login.getString(1);
                    resultadoPassBase = rs_login.getString(2);
                    resultadoActivoBase = rs_login.getInt(3);
                    rol = rs_login.getString(4);
                }

                //Si la contraseña y el usuario metidos por el usuario son igual a la de la base de datos
                if (usu.equals(resultadoUsuBase) && pass.equals(resultadoPassBase)) {
                    //Comprobamos que el usuario esta activo
                    if (resultadoActivoBase == 1) {
                        //Habrimos la pantalla principal 
                        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(this, true, rol, usu);
                        pantallaPrincipal.setVisible(true);
                    } else {
                        //Si no esta activo mostramos un mensaje 
                        JOptionPane.showMessageDialog(this, "Ya no formas parte del instituto");
                    }
                } else {
                    //Si los datos no han sido metidos correctamente mostramos mensaje
                    JOptionPane.showMessageDialog(this, "Autenticacion incorrecta ");
                }
                //Cerramos la conexion
                conexion.close();

            } catch (SQLException ex) {
                Logger.getLogger(Autenticacion_pantalla.class.getName()).log(Level.SEVERE, null, ex);
                conexion.close();
            }
        } //Si la conxion no esta bien realizada
        else {
            JOptionPane.showMessageDialog(this, "Revisa tu conexion");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Autenticacion_pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Autenticacion_pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Autenticacion_pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Autenticacion_pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    UIManager.setLookAndFeel(new MintLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) { 
                    Logger.getLogger(Autenticacion_pantalla.class.getName()).log(Level.SEVERE, null, ex);
                }

                new Autenticacion_pantalla().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordFieldPassAutenticacion;
    private javax.swing.JTextField jTextFieldUsuarioAutenticacion;
    // End of variables declaration//GEN-END:variables

}
