/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author damA
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        
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

        jButtonPeli = new javax.swing.JButton();
        jButtonTematica = new javax.swing.JButton();
        jButtonDirector = new javax.swing.JButton();
        jButtonSala = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));

        jButtonPeli.setBackground(new java.awt.Color(255, 204, 255));
        jButtonPeli.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jButtonPeli.setText("Pelicula");
        jButtonPeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPeliActionPerformed(evt);
            }
        });

        jButtonTematica.setBackground(new java.awt.Color(255, 204, 255));
        jButtonTematica.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jButtonTematica.setText("Tematica");
        jButtonTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTematicaActionPerformed(evt);
            }
        });

        jButtonDirector.setBackground(new java.awt.Color(255, 204, 255));
        jButtonDirector.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jButtonDirector.setText("Director");
        jButtonDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDirectorActionPerformed(evt);
            }
        });

        jButtonSala.setBackground(new java.awt.Color(255, 204, 255));
        jButtonSala.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jButtonSala.setText("Sala");
        jButtonSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPeli, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTematica, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDirector, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSala, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSala, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPeli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTematica, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPeliActionPerformed
        // TODO add your handling code here:
        Peliculas pelis = new Peliculas(this, true);
        pelis.setVisible(true);
    }//GEN-LAST:event_jButtonPeliActionPerformed

    private void jButtonSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalaActionPerformed
        // TODO add your handling code here:
        Sala sala = new Sala(this,true);
        sala.setVisible(true);
    }//GEN-LAST:event_jButtonSalaActionPerformed

    private void jButtonTematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTematicaActionPerformed
        // TODO add your handling code here:
        Tematica tema = new Tematica(this, true);
        tema.setVisible(true);
    }//GEN-LAST:event_jButtonTematicaActionPerformed

    private void jButtonDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDirectorActionPerformed
        // TODO add your handling code here:
        Director direc = new Director(this, true);
        direc.setVisible(true);
    }//GEN-LAST:event_jButtonDirectorActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDirector;
    private javax.swing.JButton jButtonPeli;
    private javax.swing.JButton jButtonSala;
    private javax.swing.JButton jButtonTematica;
    // End of variables declaration//GEN-END:variables
}
