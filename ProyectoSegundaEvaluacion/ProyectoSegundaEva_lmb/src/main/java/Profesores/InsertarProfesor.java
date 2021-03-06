/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profesores;

import baseDatos.Conectar;
import com.opencsv.CSVReader;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author laura
 */
public class InsertarProfesor extends javax.swing.JDialog {

    Conectar contectar = null;

    /**
     * Creates new form InsertarProfesor
     */
    public InsertarProfesor(javax.swing.JDialog parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();

        consultarDepartamento(jComboBoxDepartamento);
        consultarRol(jComboBoxRol);
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
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldContraseña = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNombreCompleto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jComboBoxDepartamento = new javax.swing.JComboBox<>();
        jCheckBoxActivo = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxRol = new javax.swing.JComboBox<>();
        jButtonInsertar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonInsertarCsv = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel1.setText("Usuario");

        jTextFieldUsuario.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel5.setText("Contraseña");

        jTextFieldContraseña.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel2.setText("Nombre completo");

        jTextFieldNombreCompleto.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel3.setText("Email");

        jTextFieldEmail.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N

        jComboBoxDepartamento.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jComboBoxDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartamentoActionPerformed(evt);
            }
        });

        jCheckBoxActivo.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jCheckBoxActivo.setText("Activo");

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel4.setText("Rol");

        jComboBoxRol.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jComboBoxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRolActionPerformed(evt);
            }
        });

        jButtonInsertar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonInsertar.setText("Insertar profesor");
        jButtonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel6.setText("Departamento");

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 0));
        jLabel7.setText("Nuevo profesor");

        jButtonInsertarCsv.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonInsertarCsv.setText("Insertar desde archivo");
        jButtonInsertarCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarCsvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jCheckBoxActivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldNombreCompleto)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jTextFieldContraseña)
                            .addComponent(jComboBoxDepartamento, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45))))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 124, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonInsertar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInsertarCsv, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxActivo)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jButtonInsertar)
                .addGap(31, 31, 31)
                .addComponent(jButtonInsertarCsv)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(624, 522));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentoActionPerformed

    }//GEN-LAST:event_jComboBoxDepartamentoActionPerformed

    private void jButtonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarActionPerformed
        String usurio = jTextFieldUsuario.getText();
        String nombreCompleto = jTextFieldNombreCompleto.getText();
        String email = jTextFieldEmail.getText();
        //Guardo la contraseña metida por el usuario
        String passReco = jTextFieldContraseña.getText();
        //La encripto
        String pass = DigestUtils.md5Hex(passReco);

        boolean activo = jCheckBoxActivo.isSelected();
        int activoNum = 0;
        if (activo == true) {
            activoNum = 1;
        } else {
            activoNum = 0;
        }

        String depar = jComboBoxDepartamento.getSelectedItem().toString();
        String[] departamento = depar.split("-");
        String idDepartamento = departamento[0];

        String permiso = jComboBoxRol.getSelectedItem().toString();
        String[] rol = permiso.split("-");
        String idRol = rol[0];

        //INSERTAR PROFESOR
        try {
            PreparedStatement ps = null;
            contectar = new Conectar();
            Connection conexion = contectar.getConexion();

            String sql = "INSERT INTO fp_profesor (login, password, nombre_completo, email, activo, id_rol, id_departamento) "
                    + "values ('" + usurio + "','" + pass + "','" + nombreCompleto + "','" + email + "','" + activoNum + "','" + idRol + "','" + idDepartamento + "')";

            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Datos insertados");

            conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se han podido insertar los datos");
        }

        dispose();

    }//GEN-LAST:event_jButtonInsertarActionPerformed

    private void jComboBoxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRolActionPerformed

    private void jButtonInsertarCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarCsvActionPerformed

        try {

            // Conexion
            contectar = new Conectar();
            Connection conexion = contectar.getConexion();

            JFileChooser fileChooser = new JFileChooser();
            //Para que solo de deje escojer archivos csv
            fileChooser.setAcceptAllFileFilterUsed(false);
            //Ponemos la opcion de csv en el file chooser 
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.csv", "csv");
            fileChooser.setFileFilter(filtro);
            fileChooser.showOpenDialog(fileChooser);
          
            if (fileChooser.getSelectedFile() != null) {
                String ruta = fileChooser.getSelectedFile().getAbsolutePath();
                CSVReader csvReader = new CSVReader(new FileReader(ruta));

                List<String[]> datos = csvReader.readAll();
                for (int i = 1; i < datos.size(); i++) {
                    String[] get = datos.get(i);
                    String sql = "insert into fp_profesor (login,password,nombre_completo,email,activo,id_rol,id_departamento)\n"
                            + "values (?,?,?,?,?,?,?);";

                    PreparedStatement ps = null;
                    ps = conexion.prepareStatement(sql);

                    ps.setString(1, get[0]);
                    ps.setString(2, get[1]);
                    ps.setString(3, get[2]);
                    ps.setString(4, get[3]);
                    ps.setString(5, get[4]);
                    ps.setString(6, get[5]);
                    ps.setString(7, get[6]);

                    // Ejecutamos la consulta
                    ps.executeUpdate();

                }

                csvReader.close();


                conexion.close();
                JOptionPane.showMessageDialog(this, "Profesores insertados");
                dispose();
            }else{
                dispose();
                conexion.close();

            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Archivo no encontrado, error al insertar");
            dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se han podido insertar los datos");
            dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se han podido insertar los datos, hay algun dato duplicado");
            dispose();
        }

    }//GEN-LAST:event_jButtonInsertarCsvActionPerformed

    public void consultarDepartamento(JComboBox comboBox) {
        PreparedStatement ps = null;
        contectar = new Conectar();
        Connection conexion = contectar.getConexion();
        String sql = "SELECT id_departamento,departamento FROM mantenimiento_mollon.fp_departamento;";
        try {
            ps = conexion.prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                comboBox.addItem(result.getString("id_departamento") + "-" + result.getString("departamento"));
            }

            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void consultarRol(JComboBox comboBox) throws SQLException {
        PreparedStatement ps = null;
        contectar = new Conectar();
        Connection conexion = contectar.getConexion();
        String sql = "SELECT id_rol,rol FROM mantenimiento_mollon.fp_rol;";
        try {
            ps = conexion.prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                comboBox.addItem(result.getString("id_rol") + "-" + result.getString("rol"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        conexion.close();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInsertar;
    private javax.swing.JButton jButtonInsertarCsv;
    private javax.swing.JCheckBox jCheckBoxActivo;
    private javax.swing.JComboBox<String> jComboBoxDepartamento;
    private javax.swing.JComboBox<String> jComboBoxRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextFieldContraseña;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombreCompleto;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
