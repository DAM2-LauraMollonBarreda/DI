
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
public class Tematica extends javax.swing.JDialog {
Conectar conectar = null;
    /**
     * Creates new form Tematica
     */
    public Tematica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        refrescarTabla();
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
        jTableTema = new javax.swing.JTable();
        jButtonAddTematica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Tematica");

        jTableTema.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableTema);

        jButtonAddTematica.setBackground(new java.awt.Color(255, 204, 255));
        jButtonAddTematica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAddTematica.setText("A??adir");
        jButtonAddTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddTematicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddTematica, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonAddTematica)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddTematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddTematicaActionPerformed
        // TODO add your handling code here:
        A??adirTematica intrDatos = new A??adirTematica(null, true);
        intrDatos.setVisible(true);
        refrescarTabla();
    }//GEN-LAST:event_jButtonAddTematicaActionPerformed

    /**
     * @param args the command line arguments
     */

     private void refrescarTabla() {
     
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"idTematica","Nombre"});

        jTableTema.setModel(dtm);
        
        //ACCESO A BASE DE DATOS 
        //Conectamos con la base de datos
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        String[] temaBd = new String[2];
        if (conexion != null) {
            try {
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery ("select * from tematica");
                 
                while (rs.next()) {
                    //dtm.addRow(rs);
                    
                    temaBd[0]= rs.getString(1);
                    temaBd[1]= rs.getString(2);



                    
                    dtm.addRow(temaBd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
        else{
            JOptionPane.showMessageDialog(this, "Conoxion fallida");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddTematica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTema;
    // End of variables declaration//GEN-END:variables
}
