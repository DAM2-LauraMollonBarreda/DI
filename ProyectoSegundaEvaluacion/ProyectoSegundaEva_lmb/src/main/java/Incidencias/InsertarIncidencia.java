/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Incidencias;

import Email.EnviarCorreo;
import Profesores.ProfesoresPrincipal;
import baseDatos.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author damA
 */
public class InsertarIncidencia extends javax.swing.JDialog {

    Conectar contectar = null;
    String usu = "";
    String id = "";

    /**
     * Creates new form InsertarIncidencia
     */
    public InsertarIncidencia(javax.swing.JDialog parent, boolean modal, String usuario) throws SQLException {

        super(parent, modal);
        initComponents();
        usu = usuario;

        //Metodo para meter en los combo box
        consultarUbicacion(jComboBoxUbicacion);
        consultarEstado(jComboBoxEstado);
        consultarUrgencia(jComboBoxUrgencia);
        consultarId();

    }

    public void consultarUbicacion(JComboBox comboBox) throws SQLException {
        //Creamos la consulta y la conexion para obtener la ubicacion
        PreparedStatement ps = null;
        contectar = new Conectar();
        Connection conexion = contectar.getConexion();
        String sql = "SELECT id_ubicacion,ubicacion FROM mantenimiento_mollon.man_ubicacion;";
        try {
            ps = conexion.prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                //Metemos los datos extraidos a un combo box
                comboBox.addItem(result.getString("id_ubicacion") + "-" + result.getString("ubicacion"));
            }

            //Cerramos la conexion
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion.close();
        }
    }

    public void consultarUrgencia(JComboBox comboBox) throws SQLException {
        //Creamos la consulta y la conexion para obtener la urgencia
        PreparedStatement ps = null;
        contectar = new Conectar();
        Connection conexion = contectar.getConexion();
        String sql = "SELECT id_urgencia,urgencia FROM mantenimiento_mollon.man_urgencia;";
        try {
            ps = conexion.prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                //Metemos los datos extraidos en un combo box
                comboBox.addItem(result.getString("id_urgencia") + "-" + result.getString("urgencia"));
            }

            //Cerramos la conexion
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion.close();
        }
    }

    public void consultarEstado(JComboBox comboBox) throws SQLException {
        //Creamos la consulta y la conexion para constar los estados
        PreparedStatement ps = null;
        contectar = new Conectar();
        Connection conexion = contectar.getConexion();
        String sql = "SELECT id_estado,estado FROM mantenimiento_mollon.man_estado;";
        try {
            ps = conexion.prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                //Metemos los datos extraidos en un combo box
                comboBox.addItem(result.getString("id_estado") + "-" + result.getString("estado"));
            }

            //Cerramos la conexion
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion.close();
        }
    }

    public void consultarId() throws SQLException {
        //Metodo para saber el id del profesor que esta insertando la incidencia
        contectar = new Conectar();
        Connection conexion = contectar.getConexion();
        String[] idArray = new String[1];
        if (conexion != null) {

            try {
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery("SELECT id_profesor FROM mantenimiento_mollon.fp_profesor where login='" + usu + "';");

                while (rs.next()) {
                    idArray[0] = rs.getString(1);
                }
                id = idArray[0];

            } catch (SQLException sQLException) {
                JOptionPane.showMessageDialog(this, "Datos no cargados");

            }

            conexion.close();

        } else {
            JOptionPane.showMessageDialog(this, "Conoxion fallida");
            conexion.close();
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
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jComboBoxUbicacion = new javax.swing.JComboBox<>();
        jComboBoxUrgencia = new javax.swing.JComboBox<>();
        jButtonInsertarIncidencia = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextFieldDescripcion = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextFieldObservaciones = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel2.setText("Descripcion");

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel3.setText("Estado");

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel5.setText("Urgencia");

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel6.setText("Ubicacion");

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel7.setText("Observaciones");

        jComboBoxEstado.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N

        jComboBoxUbicacion.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N

        jComboBoxUrgencia.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N

        jButtonInsertarIncidencia.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonInsertarIncidencia.setText("Insertar incidencia");
        jButtonInsertarIncidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarIncidenciaActionPerformed(evt);
            }
        });

        jTextFieldDescripcion.setColumns(20);
        jTextFieldDescripcion.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jTextFieldDescripcion.setLineWrap(true);
        jTextFieldDescripcion.setRows(5);
        jScrollPane2.setViewportView(jTextFieldDescripcion);

        jTextFieldObservaciones.setColumns(20);
        jTextFieldObservaciones.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jTextFieldObservaciones.setLineWrap(true);
        jTextFieldObservaciones.setRows(5);
        jScrollPane3.setViewportView(jTextFieldObservaciones);

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText("Nueva incidencia...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButtonInsertarIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxUbicacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxUrgencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(73, 73, 73)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxUrgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jButtonInsertarIncidencia)
                .addGap(28, 28, 28))
        );

        setSize(new java.awt.Dimension(517, 561));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInsertarIncidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarIncidenciaActionPerformed

        //Cojemos los datos y los guardamos en variables
        String descripcion = jTextFieldDescripcion.getText();

        Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate 
        String strDateFormat = "YYYY-MM-dd hh:mm:ss"; // El formato de fecha est?? especificado  
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 

        String fechaCreacion = objSDF.format(objDate);

        String observaciones = jTextFieldObservaciones.getText();

        String est = jComboBoxEstado.getSelectedItem().toString();
        String[] estado = est.split("-");
        String idEstado = estado[0];

        String ubi = jComboBoxUbicacion.getSelectedItem().toString();
        String[] ubicacion = ubi.split("-");
        String idUbicacion = ubicacion[0];

        String urg = jComboBoxUrgencia.getSelectedItem().toString();
        String[] urgencia = urg.split("-");
        String idUrgencia = urgencia[0];


        try {
            //Creamos la conexion
            PreparedStatement ps = null;
            contectar = new Conectar();
            Connection conexion = contectar.getConexion();
            
            //Insertamos en la base de datos los datos que hemos recojido
            String sql = "INSERT INTO mantenimiento_mollon.man_incidencias (id_profesor_crea, descripcion, id_estado, fecha, nivel_urgencia, id_ubicacion, observaciones)"
                    + " VALUES ('" + id + "', '" + descripcion + "',  '" + idEstado + "', '" + fechaCreacion + "', '" + idUbicacion + "', '" + idUbicacion + "', '" + observaciones + "');";

            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Incidencia creada con el usuario " + usu);

            //Cerramos la conexion
            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se han podido insertar los datos");
            System.out.println(ex);
        }

        //Preguntamos si el usuario quiere enviar un correo en caso de que quiera enviarlo, se llama a la pantalla de enviar correo
        int resp = JOptionPane.showConfirmDialog(null, "??Quieres enviar un correo para avisar a los tecnico?", "??DESEAS ENVIAR UN CORREO?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        //Si la respuesta es s??(YES_OPTION)   
        if (resp == JOptionPane.YES_OPTION) {
            EnviarCorreo enviarCorreo;
            try {
                enviarCorreo = new EnviarCorreo(this, true);
                enviarCorreo.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(InsertarIncidencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        } else {
            dispose();
        }


    }//GEN-LAST:event_jButtonInsertarIncidenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInsertarIncidencia;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JComboBox<String> jComboBoxUbicacion;
    private javax.swing.JComboBox<String> jComboBoxUrgencia;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextFieldDescripcion;
    private javax.swing.JTextArea jTextFieldObservaciones;
    // End of variables declaration//GEN-END:variables

}
