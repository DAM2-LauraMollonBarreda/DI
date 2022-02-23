/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import baseDatos.Conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author laura
 */
public class EnviarCorreo extends javax.swing.JDialog {

    String contraseña = "";
    TableRowSorter<TableModel> elQueOrdena;
    Conectar conectar = null;
    Address[] destinatario;

    /**
     * Creates new form EnviarCorreo
     */
    public EnviarCorreo(javax.swing.JDialog parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        rellenoTabla();

    }

    public void extraerEmailSeleccionados() throws AddressException {
        int cuentaFilasSeccionadas = jTableDestinatarios.getSelectedRowCount();
        int[] filas = jTableDestinatarios.getSelectedRows();
        ArrayList<String> destinatarioArray = new ArrayList<String>();
        for (int i = 0; i < filas.length; i++) {
            destinatarioArray.add(jTableDestinatarios.getModel().getValueAt(filas[i], 1).toString());
        }

        String[] destinatarioString = new String[destinatarioArray.size()];
        destinatarioString = destinatarioArray.toArray(destinatarioString);
        destinatario = new Address[destinatarioString.length];

        for (int i = 0; i < destinatarioString.length; i++) {
            destinatario[i] = new InternetAddress(destinatarioString[i]);
        }
    }

    public void rellenoTabla() throws SQLException {
        DefaultTableModel dtm = new DefaultTableModel();
        //Creamos las columnas que tendra la tabla
        dtm.setColumnIdentifiers(new String[]{"Nombre completo", "Email"});
        //Elemento para ordenar la tabla
        elQueOrdena = new TableRowSorter<TableModel>(dtm);
        //Ordenamos la tabla segun las columnas
        jTableDestinatarios.setRowSorter(elQueOrdena);

        //Añadimos las columnas a la tabla
        jTableDestinatarios.setModel(dtm);

        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        String[] profes = new String[2];
        if (conexion != null) {

            try {
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery("SELECT nombre_completo, email FROM mantenimiento_mollon.fp_profesor where id_rol=1 or id_rol=2;");

                while (rs.next()) {
                    //dtm.addRow(rs);
                    profes[0] = rs.getString(1);
                    profes[1] = rs.getString(2);

                    dtm.addRow(profes);

                }
            } catch (SQLException sQLException) {
                JOptionPane.showMessageDialog(this, "Datos no cargados");

            }

            conexion.close();

        } else {
            JOptionPane.showMessageDialog(this, "Conoxion fallida");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldRemitente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldAsunto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMensaje = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDestinatarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tu correo:");

        jLabel2.setText("@gmail.com");

        jLabel3.setText("Destinatario:");

        jLabel4.setText("Asunto");

        jTextFieldAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAsuntoActionPerformed(evt);
            }
        });

        jTextAreaMensaje.setColumns(20);
        jTextAreaMensaje.setLineWrap(true);
        jTextAreaMensaje.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMensaje);

        jLabel5.setText("Mensaje");

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jTableDestinatarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableDestinatarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jTextFieldAsunto)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAceptar)))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(49, 49, 49)
                        .addComponent(jLabel4))
                    .addComponent(jTextFieldAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAsuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAsuntoActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed

        String remitente = jTextFieldRemitente.getText();
        try {
            extraerEmailSeleccionados();
        } catch (AddressException ex) {
            
        }
        String asunto = jTextFieldAsunto.getText();
        String cuerpo = jTextAreaMensaje.getText();

        crearJOptionContraseña();

        if (contraseña.equals("")) {
            JOptionPane.showMessageDialog(null, "La contraseña esta vacia", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            enviarConGMail(remitente, destinatario, asunto, cuerpo, contraseña);
        }
        
        dispose();


    }//GEN-LAST:event_jButtonAceptarActionPerformed

    public void crearJOptionContraseña() throws HeadlessException {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Escribe la contraseña de tu correo:");
        JPasswordField pass = new JPasswordField(20);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "Introduce la contraseña", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
        contraseña = pass.getText();

    }

    public static void enviarConGMail(String remitente, Address[] destinatarioArray, String asunto, String cuerpo, String clave) {

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", "miClaveDeGMail");    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            for (Address dest : destinatarioArray) {
                message.addRecipient(Message.RecipientType.TO, dest);
            }
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            JOptionPane.showMessageDialog(null, "A sido enviado el correo", "CORREO ENVIADO", JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException me) {
            JOptionPane.showMessageDialog(null, "El envio del correo a fallado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDestinatarios;
    private javax.swing.JTextArea jTextAreaMensaje;
    private javax.swing.JTextField jTextFieldAsunto;
    private javax.swing.JTextField jTextFieldRemitente;
    // End of variables declaration//GEN-END:variables
}
