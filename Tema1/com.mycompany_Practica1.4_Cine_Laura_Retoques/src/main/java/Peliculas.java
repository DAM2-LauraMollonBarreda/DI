
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
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
public class Peliculas extends javax.swing.JDialog {
Conectar conectar = null;
    /**
     * Creates new form Peliculas
     */
    public Peliculas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        crearpopupmenu();
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
        jTablePelis = new javax.swing.JTable();
        jButtonAddPeliculas = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuDirector = new javax.swing.JButton();
        jButtonBuTematica = new javax.swing.JButton();
        jButtonBuSala = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Peliculas");

        jTablePelis.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablePelis);

        jButtonAddPeliculas.setBackground(new java.awt.Color(255, 204, 255));
        jButtonAddPeliculas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAddPeliculas.setText("A??adir");
        jButtonAddPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPeliculasActionPerformed(evt);
            }
        });

        jButtonBuDirector.setBackground(new java.awt.Color(255, 204, 255));
        jButtonBuDirector.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonBuDirector.setText("Por director");
        jButtonBuDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuDirectorActionPerformed(evt);
            }
        });

        jButtonBuTematica.setBackground(new java.awt.Color(255, 204, 255));
        jButtonBuTematica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonBuTematica.setText("Por tematica");
        jButtonBuTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuTematicaActionPerformed(evt);
            }
        });

        jButtonBuSala.setBackground(new java.awt.Color(255, 204, 255));
        jButtonBuSala.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonBuSala.setText("Por sala");
        jButtonBuSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuSalaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonBuDirector)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonBuTematica))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jButtonAddPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuSala, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonAddPeliculas)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuDirector)
                    .addComponent(jButtonBuTematica)
                    .addComponent(jButtonBuSala))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPeliculasActionPerformed
        // TODO add your handling code here:
        A??adirPelicula intrDatos = new A??adirPelicula(null, true);
        intrDatos.setVisible(true);
        refrescarTabla();
    }//GEN-LAST:event_jButtonAddPeliculasActionPerformed
 
    private void jButtonBuDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuDirectorActionPerformed
        // TODO add your handling code here:
        String buscar= jTextFieldBuscar.getText();
        
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"idPelicula","Titulo","Director","Fecha proyeccion","A??o de estreno", "Tematica","Precio de entrada","Sala"});

        jTablePelis.setModel(dtm);
        
        buscarDirector(buscar, dtm);
        
    }//GEN-LAST:event_jButtonBuDirectorActionPerformed

    public void buscarDirector(String buscar, DefaultTableModel dtm) throws HeadlessException {
        //ACCESO A BASE DE DATOS
        //Conectamos con la base de datos
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        String[] peliBD = new String[8];
        if (conexion != null) {
            try {
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery ("SELECT p.idPelicula,p.titulo,d.nombre as director,p.fechaProyeccion,p.a??oEstreno,t.nombre as tematica,p.precioEntrada,s.nombre as sala FROM pelicula as p inner join director as d on p.director = d.idDirector inner join tematica as t on p.tematica=t.idTematica inner join sala as s on p.sala=s.idSala where d.nombre= '"+buscar+"'");
                
                while (rs.next()) {
                    //dtm.addRow(rs);
                    
                    peliBD[0]= rs.getString(1);
                    peliBD[1]= rs.getString(2);
                    peliBD[2]= rs.getString(3);
                    peliBD[3]= rs.getString(4);
                    peliBD[4]= rs.getString(5);
                    peliBD[5]= rs.getString(6);
                    peliBD[6]= rs.getString(7);
                    peliBD[7]= rs.getString(8);
                    
                    
                    
                    
                    dtm.addRow(peliBD);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Conoxion fallida");
        }
    }

    private void jButtonBuTematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuTematicaActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String buscar= jTextFieldBuscar.getText();
        
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"idPelicula","Titulo","Director","Fecha proyeccion","A??o de estreno", "Tematica","Precio de entrada","Sala"});

        jTablePelis.setModel(dtm);
        
        buscarTematica(buscar, dtm);
        
    }//GEN-LAST:event_jButtonBuTematicaActionPerformed

    public void buscarTematica(String buscar, DefaultTableModel dtm) throws HeadlessException {
        //ACCESO A BASE DE DATOS
        //Conectamos con la base de datos
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        String[] peliBD = new String[8];
        if (conexion != null) {
            try {
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery ("SELECT p.idPelicula,p.titulo,d.nombre as director,p.fechaProyeccion,p.a??oEstreno,t.nombre as tematica,p.precioEntrada,s.nombre as sala FROM pelicula as p inner join director as d on p.director = d.idDirector inner join tematica as t on p.tematica=t.idTematica inner join sala as s on p.sala=s.idSala where t.nombre= '"+buscar+"'");
                
                while (rs.next()) {
                    //dtm.addRow(rs);
                    
                    peliBD[0]= rs.getString(1);
                    peliBD[1]= rs.getString(2);
                    peliBD[2]= rs.getString(3);
                    peliBD[3]= rs.getString(4);
                    peliBD[4]= rs.getString(5);
                    peliBD[5]= rs.getString(6);
                    peliBD[6]= rs.getString(7);
                    peliBD[7]= rs.getString(8);
                    
                    
                    
                    
                    dtm.addRow(peliBD);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Conoxion fallida");
        }
    }

    private void jButtonBuSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuSalaActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String buscar= jTextFieldBuscar.getText();
        
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"idPelicula","Titulo","Director","Fecha proyeccion","A??o de estreno", "Tematica","Precio de entrada","Sala"});

        jTablePelis.setModel(dtm);
        
        buscarSala(buscar, dtm);
    }//GEN-LAST:event_jButtonBuSalaActionPerformed

    public void buscarSala(String buscar, DefaultTableModel dtm) throws HeadlessException {
        //ACCESO A BASE DE DATOS
        //Conectamos con la base de datos
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        String[] peliBD = new String[8];
        if (conexion != null) {
            try {
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery ("SELECT p.idPelicula,p.titulo,d.nombre as director,p.fechaProyeccion,p.a??oEstreno,t.nombre as tematica,p.precioEntrada,s.nombre as sala FROM pelicula as p inner join director as d on p.director = d.idDirector inner join tematica as t on p.tematica=t.idTematica inner join sala as s on p.sala=s.idSala where s.nombre= '"+buscar+"'");
                
                while (rs.next()) {
                    //dtm.addRow(rs);
                    
                    peliBD[0]= rs.getString(1);
                    peliBD[1]= rs.getString(2);
                    peliBD[2]= rs.getString(3);
                    peliBD[3]= rs.getString(4);
                    peliBD[4]= rs.getString(5);
                    peliBD[5]= rs.getString(6);
                    peliBD[6]= rs.getString(7);
                    peliBD[7]= rs.getString(8);
                    
                    
                    
                    
                    dtm.addRow(peliBD);
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
     * @param args the command line arguments
     */
    
    private void refrescarTabla() {
     
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"idPelicula","Titulo","Director","Fecha proyeccion","A??o de estreno", "Tematica","Precio de entrada","Sala"});

        jTablePelis.setModel(dtm);
        
        //ACCESO A BASE DE DATOS 
        //Conectamos con la base de datos
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        String[] peliBD = new String[8];
        if (conexion != null) {
            try {
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery ("SELECT p.idPelicula,p.titulo,d.nombre as director,p.fechaProyeccion,p.a??oEstreno,t.nombre as tematica,p.precioEntrada,s.nombre as sala FROM pelicula as p inner join director as d on p.director = d.idDirector inner join tematica as t on p.tematica=t.idTematica inner join sala as s on p.sala=s.idSala");
                 
                while (rs.next()) {
                    //dtm.addRow(rs);
                    
                    peliBD[0]= rs.getString(1);
                    peliBD[1]= rs.getString(2);
                    peliBD[2]= rs.getString(3);
                    peliBD[3]= rs.getString(4);
                    peliBD[4]= rs.getString(5);
                    peliBD[5]= rs.getString(6);
                    peliBD[6]= rs.getString(7);
                    peliBD[7]= rs.getString(8);



                    
                    dtm.addRow(peliBD);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
        else{
            JOptionPane.showMessageDialog(this, "Conoxion fallida");
        }
    }
    
    private void crearpopupmenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem directorItem = new JMenuItem("Buscar por el director de la pelicula seleccionada");
        JMenuItem tematicaItem = new JMenuItem("Buscar por la tematica de la pelicula seleccionada");

        
               
        popupMenu.add(directorItem);
        popupMenu.add(tematicaItem);
        
        jTablePelis.setComponentPopupMenu(popupMenu);
        
        directorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               buscarDirector();
            }
        });

        tematicaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               buscarTematica();
            }
        });  
    }
    
    public void buscarDirector(){
        int cuentaFilasSeleccionadas = jTablePelis.getSelectedRowCount(); 

        if (cuentaFilasSeleccionadas == 0) { 
            JOptionPane.showMessageDialog(this, "No hay filas seleccionadas","Error",JOptionPane.WARNING_MESSAGE);  
        } else { 
            int resultado=JOptionPane.showConfirmDialog(this, "??Esta seguro que desea buscar por director?","??Seguro?", JOptionPane.YES_NO_CANCEL_OPTION);
            if (resultado==JOptionPane.YES_OPTION) {
                int fila = jTablePelis.getSelectedRow();
                var director =jTablePelis.getModel().getValueAt(fila, 2).toString();
                
                DefaultTableModel dtm = new DefaultTableModel();
                dtm.setColumnIdentifiers(new String[]{"idPelicula","Titulo","Director","Fecha proyeccion","A??o de estreno", "Tematica","Precio de entrada","Sala"});

                jTablePelis.setModel(dtm);
        
                buscarDirector(director, dtm);
                
                
            }else if (resultado==JOptionPane.NO_OPTION) {
                JOptionPane.showConfirmDialog(this, "Fila no borrada","",JOptionPane.ERROR_MESSAGE);
            }
            else if (resultado==JOptionPane.CANCEL_OPTION) {
                JOptionPane.showConfirmDialog(this, "Operacion cancelada","",JOptionPane.WARNING_MESSAGE);
            }
        } 
    }
    
    public void buscarTematica(){
        int cuentaFilasSeleccionadas = jTablePelis.getSelectedRowCount(); 

        if (cuentaFilasSeleccionadas == 0) { 
            JOptionPane.showMessageDialog(this, "No hay filas seleccionadas","Error",JOptionPane.WARNING_MESSAGE);  
        } else { 
            int resultado=JOptionPane.showConfirmDialog(this, "??Esta seguro que desea buscar por director?","??Seguro?", JOptionPane.YES_NO_CANCEL_OPTION);
            if (resultado==JOptionPane.YES_OPTION) {
                int fila = jTablePelis.getSelectedRow();
                var tematica =jTablePelis.getModel().getValueAt(fila, 5).toString();
                
                DefaultTableModel dtm = new DefaultTableModel();
                dtm.setColumnIdentifiers(new String[]{"idPelicula","Titulo","Director","Fecha proyeccion","A??o de estreno", "Tematica","Precio de entrada","Sala"});

                jTablePelis.setModel(dtm);
        
                buscarTematica(tematica, dtm);
                
                
            }else if (resultado==JOptionPane.NO_OPTION) {
                JOptionPane.showConfirmDialog(this, "Fila no borrada","",JOptionPane.ERROR_MESSAGE);
            }
            else if (resultado==JOptionPane.CANCEL_OPTION) {
                JOptionPane.showConfirmDialog(this, "Operacion cancelada","",JOptionPane.WARNING_MESSAGE);
            }
        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddPeliculas;
    private javax.swing.JButton jButtonBuDirector;
    private javax.swing.JButton jButtonBuSala;
    private javax.swing.JButton jButtonBuTematica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePelis;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}
