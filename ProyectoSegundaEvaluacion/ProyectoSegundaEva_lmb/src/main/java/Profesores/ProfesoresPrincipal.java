/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profesores;

import Incidencias.InsertarIncidencia;
import baseDatos.Conectar;
import com.lauramollon.proyectosegundaeva_lmb.Autenticacion_pantalla;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author laura
 */
public class ProfesoresPrincipal extends javax.swing.JDialog {

    Conectar conectar = null;
    Object opcionDepartamento = "";
    Object opcionRol="";
    String usuRol = "";
    TableRowSorter<TableModel> elQueOrdena;
    

    /**
     * Creates new form Profesores_principal
     */
    public ProfesoresPrincipal(javax.swing.JDialog parent, boolean modal,String rol) throws SQLException {
        super(parent, modal);
        initComponents();
        
        usuRol=rol;

        controlUsuarios();
        rellenoTabla();


    }
    public void controlUsuarios() throws SQLException {
        if (usuRol.equals("root")) {
            jButtonInsertar.setEnabled(true);
            crearPopupMenu();
        }else if (usuRol.equals("tecnico")){
            jButtonInsertar.setEnabled(false);
        }else if (usuRol.equals("profesor")){
            jButtonInsertar.setEnabled(false);
;
        }
    }

    public void rellenoTabla() throws SQLException {
        DefaultTableModel dtm = new DefaultTableModel();
        //Creamos las columnas que tendra la tabla
        dtm.setColumnIdentifiers(new String[]{"Usuario", "Nombre completo", "Email", "Activo", "Rol", "Departamento"});
        //Elemento para ordenar la tabla
        elQueOrdena = new TableRowSorter<TableModel>(dtm);
        //Ordenamos la tabla segun las columnas
        jTableProfesores.setRowSorter(elQueOrdena);

        //Añadimos las columnas a la tabla
        jTableProfesores.setModel(dtm);

        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        String[] profes = new String[6];
        if (conexion != null) {

            try {
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery("select p.login,p.nombre_completo,p.email,if(p.activo=1,\"Si\",\"No\"),r.rol,d.departamento_corto from fp_profesor p inner join fp_rol r on r.id_rol=p.id_rol inner join fp_departamento d on d.id_departamento=p.id_departamento;");

                while (rs.next()) {
                    //dtm.addRow(rs);
                    profes[0] = rs.getString(1);
                    profes[1] = rs.getString(2);
                    profes[2] = rs.getString(3);
                    profes[3] = rs.getString(4);
                    profes[4] = rs.getString(5);
                    profes[5] = rs.getString(6);

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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jButtonInsertar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProfesores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonRol = new javax.swing.JButton();
        jButtonDepartamento = new javax.swing.JButton();
        jButtonActividad = new javax.swing.JButton();
        jButtonQuitarFiltro = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonInsertar.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonInsertar.setText("Nuevo profesor");
        jButtonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarActionPerformed(evt);
            }
        });

        jTableProfesores.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jTableProfesores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableProfesores);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Filtrar por: ");

        jButtonRol.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonRol.setText("Rol");
        jButtonRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRolActionPerformed(evt);
            }
        });

        jButtonDepartamento.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonDepartamento.setText("Departamento");
        jButtonDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDepartamentoActionPerformed(evt);
            }
        });

        jButtonActividad.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonActividad.setText("Activo/no activo");
        jButtonActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActividadActionPerformed(evt);
            }
        });

        jButtonQuitarFiltro.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonQuitarFiltro.setText("Quitar filtros");
        jButtonQuitarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarFiltroActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 0));
        jLabel7.setText("Profesores...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButtonRol)
                .addGap(42, 42, 42)
                .addComponent(jButtonDepartamento)
                .addGap(37, 37, 37)
                .addComponent(jButtonActividad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonQuitarFiltro)
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonInsertar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jButtonInsertar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jButtonRol))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDepartamento)
                        .addComponent(jButtonActividad)
                        .addComponent(jButtonQuitarFiltro)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(859, 671));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarActionPerformed

        InsertarProfesor pantallaProfesoresInsertar;
        try {
            pantallaProfesoresInsertar = new InsertarProfesor(this, true);
            pantallaProfesoresInsertar.setVisible(true);
            rellenoTabla();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProfesoresPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonInsertarActionPerformed

    
    //FILTROS
    private void jButtonQuitarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarFiltroActionPerformed
        elQueOrdena.setRowFilter(RowFilter.regexFilter("", 0));
    }//GEN-LAST:event_jButtonQuitarFiltroActionPerformed

    
    private void jButtonRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRolActionPerformed
        try {
            consultarRol();
            if (opcionRol != null) {
                 elQueOrdena.setRowFilter(RowFilter.regexFilter("(?i)" + opcionRol, 4));
            }
        } catch (HeadlessException ex) {
            java.util.logging.Logger.getLogger(ProfesoresPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProfesoresPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonRolActionPerformed
    public void consultarRol() throws SQLException {
         PreparedStatement ps = null;
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        ArrayList<String> rol = new ArrayList<>();
        String sql = "SELECT rol FROM mantenimiento_mollon.fp_rol;";
        try {
            ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rol.add(rs.getString(1));
            }
            String[] rolArray = new String[rol.size()];
            rolArray = rol.toArray(rolArray);
            opcionRol = JOptionPane.showInputDialog(null, "Selecciona el rol por el que quieres filtrar", "Elegir", JOptionPane.QUESTION_MESSAGE, null, rolArray, rolArray[0]);
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void jButtonDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDepartamentoActionPerformed
        try {
            consultarDepartamento();
            if (opcionDepartamento != null) {
                elQueOrdena.setRowFilter(RowFilter.regexFilter("(?i)" + opcionDepartamento, 5));
            }
        } catch (HeadlessException ex) {
            java.util.logging.Logger.getLogger(ProfesoresPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }//GEN-LAST:event_jButtonDepartamentoActionPerformed
    public void consultarDepartamento() {
        PreparedStatement ps = null;
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        ArrayList<String> departamento = new ArrayList<>();
        String sql = "SELECT departamento_corto FROM mantenimiento_mollon.fp_departamento;";
        try {
            ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                departamento.add(rs.getString(1));
            }
            String[] departamentoArray = new String[departamento.size()];
            departamentoArray = departamento.toArray(departamentoArray);
            opcionDepartamento = JOptionPane.showInputDialog(null, "Selecciona el rol por el que quieres filtrar", "Elegir", JOptionPane.QUESTION_MESSAGE, null, departamentoArray, departamentoArray[0]);
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void jButtonActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActividadActionPerformed

        try {
            String[] actividad = new String[2];
            actividad[0] = "Activo";
            actividad[1] = "Inactivo";

            Object opcionRol = JOptionPane.showInputDialog(null, "Selecciona la actividad por la que quieres filtrar", "Elegir", JOptionPane.QUESTION_MESSAGE, null, actividad, actividad[0]);

            //ERROR
            if (opcionRol != null) {
                 elQueOrdena.setRowFilter(RowFilter.regexFilter("(?i)" + opcionRol, 3));
            }

        } catch (HeadlessException ex) {

        } 
    }//GEN-LAST:event_jButtonActividadActionPerformed
    
    //FIN FILTROS
    
    //POPUP MENU
    private void crearPopupMenu() throws SQLException {
        JPopupMenu popupMenu= new JPopupMenu();
        JMenuItem bajaProfesor = new JMenuItem("Baja/alta de este profesor");
        JMenu rolProfesor = new JMenu("Cambiar rol de este profesor ");
        JMenuItem root = new JMenuItem("Poner como root");
        JMenuItem tecnico = new JMenuItem("Poner como tecnico");
        JMenuItem profesor = new JMenuItem("Poner como profesor");
        JMenuItem contraseñaProfesor = new JMenuItem("Cambiar contraseña de este profesor");
        
        popupMenu.add(bajaProfesor);

        popupMenu.add(rolProfesor);
        rolProfesor.add(root);
        rolProfesor.add(tecnico);
        rolProfesor.add(profesor);

        popupMenu.add(contraseñaProfesor);
        
        popupMenu.setEnabled(true);
        

        
        jTableProfesores.setComponentPopupMenu(popupMenu);
        

        bajaProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    bajaProfesor();
                    rellenoTabla();

                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ProfesoresPrincipal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        root.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cambiarRolRoot();
                try {
                    rellenoTabla();

                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ProfesoresPrincipal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        tecnico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cambiarRolTecnico();
                try {
                    rellenoTabla();

                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ProfesoresPrincipal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        profesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cambiarRolProfesor();
                try {
                    rellenoTabla();

                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ProfesoresPrincipal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        contraseñaProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cambiarContraseña();
            }
        });

    }

    public void bajaProfesor() {
        int cuentaFilasSeleccionadas = jTableProfesores.getSelectedRowCount();
        if (cuentaFilasSeleccionadas == 0) {
            JOptionPane.showMessageDialog(this, "No hay filas seleccionadas", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            int fila = jTableProfesores.getSelectedRow();
            String login = jTableProfesores.getModel().getValueAt(fila, 0).toString();
            String activo = jTableProfesores.getModel().getValueAt(fila, 3).toString();

            if (activo.equals("Si")) {

                try {
                    PreparedStatement ps = null;
                    conectar = new Conectar();
                    Connection conexion = conectar.getConexion();

                    String sql = "UPDATE fp_profesor SET activo='0' WHERE login='" + login + "';";

                    ps = conexion.prepareStatement(sql);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Este profesor ya no esta activo");

                    conexion.close();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "No se han podido insertar los datos");
                }

            } else if (activo.equals("No")) {
                try {
                    PreparedStatement ps = null;
                    conectar = new Conectar();
                    Connection conexion = conectar.getConexion();

                    String sql = "UPDATE fp_profesor SET activo='1' WHERE login='" + login + "';";

                    ps = conexion.prepareStatement(sql);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Este profesor ya esta activo");

                    conexion.close();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "No se han podido insertar los datos");
                }
            }
        }
    }

    public void cambiarRolRoot() {
        int cuentaFilasSeleccionadas = jTableProfesores.getSelectedRowCount();
        if (cuentaFilasSeleccionadas == 0) {
            JOptionPane.showMessageDialog(this, "No hay filas seleccionadas", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            int fila = jTableProfesores.getSelectedRow();
            String login = jTableProfesores.getModel().getValueAt(fila, 0).toString();
            String rol = jTableProfesores.getModel().getValueAt(fila, 4).toString();

            if (rol.equals("root")) {
                JOptionPane.showMessageDialog(this, "Este usuario ya es root");

            } else {
                try {
                    PreparedStatement ps = null;
                    conectar = new Conectar();
                    Connection conexion = conectar.getConexion();

                    String sql = "UPDATE fp_profesor SET id_rol='1' WHERE login='" + login + "';";

                    ps = conexion.prepareStatement(sql);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Este profesor ya es root");

                    conexion.close();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "No se han podido insertar los datos");
                }
            }
        }
    }

    public void cambiarRolTecnico() {
        int cuentaFilasSeleccionadas = jTableProfesores.getSelectedRowCount();
        if (cuentaFilasSeleccionadas == 0) {
            JOptionPane.showMessageDialog(this, "No hay filas seleccionadas", "Error", JOptionPane.WARNING_MESSAGE);
        } else {

            int fila = jTableProfesores.getSelectedRow();
            String login = jTableProfesores.getModel().getValueAt(fila, 0).toString();
            String rol = jTableProfesores.getModel().getValueAt(fila, 4).toString();

            if (rol.equals("tecnico")) {
                JOptionPane.showMessageDialog(this, "Este usuario ya es tecnico");

            } else {
                try {
                    PreparedStatement ps = null;
                    conectar = new Conectar();
                    Connection conexion = conectar.getConexion();

                    String sql = "UPDATE fp_profesor SET id_rol='2' WHERE login='" + login + "';";

                    ps = conexion.prepareStatement(sql);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Este profesor ya es tecnico");

                    conexion.close();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "No se han podido insertar los datos");
                }
            }

        }
    }

    public void cambiarRolProfesor() {
        int cuentaFilasSeleccionadas = jTableProfesores.getSelectedRowCount();
        if (cuentaFilasSeleccionadas == 0) {
            JOptionPane.showMessageDialog(this, "No hay filas seleccionadas", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            int fila = jTableProfesores.getSelectedRow();
            String login = jTableProfesores.getModel().getValueAt(fila, 0).toString();
            String rol = jTableProfesores.getModel().getValueAt(fila, 4).toString();

            if (rol.equals("profesor")) {
                JOptionPane.showMessageDialog(this, "Este usuario ya tiene los permisos de profesor");

            } else {
                try {
                    PreparedStatement ps = null;
                    conectar = new Conectar();
                    Connection conexion = conectar.getConexion();

                    String sql = "UPDATE fp_profesor SET id_rol='3' WHERE login='" + login + "';";

                    ps = conexion.prepareStatement(sql);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Este usuario ya tiene los permisos de profesor");

                    conexion.close();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "No se han podido insertar los datos");
                }
            }
        }
    }

    public void cambiarContraseña() {
        int cuentaFilasSeleccionadas = jTableProfesores.getSelectedRowCount();
        if (cuentaFilasSeleccionadas == 0) {
            JOptionPane.showMessageDialog(this, "No hay filas seleccionadas", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            int resultado = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea resetear la contraseña a la de por defecto?", "¿Seguro?", JOptionPane.YES_NO_CANCEL_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                int fila = jTableProfesores.getSelectedRow();
                String login = jTableProfesores.getModel().getValueAt(fila, 0).toString();

                try {
                    PreparedStatement ps = null;
                    conectar = new Conectar();
                    Connection conexion = conectar.getConexion();

                    String pass = DigestUtils.md5Hex("iesChomon");

                    String sql = "UPDATE fp_profesor SET password='" + pass + "' WHERE login='" + login + "';";

                    ps = conexion.prepareStatement(sql);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Ya tiene la contraseña cambiada, recuerda ahora la contraseña es iesChomon");

                    conexion.close();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "No se han podido insertar los datos");
                }

            } else if (resultado == JOptionPane.NO_OPTION) {
                JOptionPane.showConfirmDialog(this, "Fila no borrada", "", JOptionPane.ERROR_MESSAGE);
            } else if (resultado == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showConfirmDialog(this, "Operacion cancelada", "", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    //FIN POPUP MENU

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActividad;
    private javax.swing.JButton jButtonDepartamento;
    private javax.swing.JButton jButtonInsertar;
    private javax.swing.JButton jButtonQuitarFiltro;
    private javax.swing.JButton jButtonRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProfesores;
    // End of variables declaration//GEN-END:variables

    

}
