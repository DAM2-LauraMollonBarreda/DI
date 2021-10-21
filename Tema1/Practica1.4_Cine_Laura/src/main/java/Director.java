
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author damA
 */
public class Director extends javax.swing.JDialog {
Conectar conectar = null;
    /**
     * Creates new form Director
     */
    public Director(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        refrescarTabla();
    }
    
     private void refrescarTabla() {
     
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"idDirector","Nombre", "Apellidos" , "fechaNac"});

        jTableDirector.setModel(dtm);
        
        //ACCESO A BASE DE DATOS 
        //Conectamos con la base de datos
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        String[] dircBd = new String[4];
        if (conexion != null) {
            try {
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery ("select * from director");
                 
                while (rs.next()) {
                    //dtm.addRow(rs);
                    
                    dircBd[0]= rs.getString(1);
                    dircBd[1]= rs.getString(2);
                    dircBd[2]= rs.getString(3);
                    dircBd[3]= rs.getString(4);


                    
                    dtm.addRow(dircBd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDirector = new javax.swing.JTable();
        jButtonAddDirector = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Director");

        jTableDirector.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableDirector);

        jButtonAddDirector.setBackground(new java.awt.Color(255, 204, 255));
        jButtonAddDirector.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAddDirector.setText("Añadir");
        jButtonAddDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddDirectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButtonAddDirector)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddDirectorActionPerformed
        // TODO add your handling code here:
        AñadirDirector intrDatos = new AñadirDirector(null, true);
        intrDatos.setVisible(true);
        refrescarTabla();
    }//GEN-LAST:event_jButtonAddDirectorActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddDirector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDirector;
    // End of variables declaration//GEN-END:variables
}
