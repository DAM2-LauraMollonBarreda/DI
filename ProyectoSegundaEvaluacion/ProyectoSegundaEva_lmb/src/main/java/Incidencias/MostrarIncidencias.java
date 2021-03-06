/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Incidencias;

import Profesores.InsertarProfesor;
import Profesores.ProfesoresPrincipal;
import baseDatos.Conectar;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author damA
 */
public class MostrarIncidencias extends javax.swing.JDialog {

    Conectar conectar = null;
    String rolUsu = "";
    Object opcionUrgencia = "";
    Object opcionEstado = "";
    Object opcionProfesor = "";
    TableRowSorter<TableModel> elQueOrdena;

    /**
     * Creates new form MostrarIncidencias
     */
    public MostrarIncidencias(javax.swing.JDialog parent, boolean modal, String usuRol) throws SQLException {
        super(parent, modal);
        initComponents();
        rolUsu = usuRol;

        rellenoTabla();
        crearPopupMenu();
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
        jTableIncidencias = new javax.swing.JTable();
        jButtonProfesor = new javax.swing.JButton();
        jButtonQuitarFiltro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonUrgencia = new javax.swing.JButton();
        jButtonEstado = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableIncidencias.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jTableIncidencias.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableIncidencias.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableIncidencias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTableIncidencias);

        jButtonProfesor.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonProfesor.setText("Profesor");
        jButtonProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProfesorActionPerformed(evt);
            }
        });

        jButtonQuitarFiltro.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonQuitarFiltro.setText("Quitar filtros");
        jButtonQuitarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarFiltroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Filtrar por: ");

        jButtonUrgencia.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonUrgencia.setText("Urgencia");
        jButtonUrgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUrgenciaActionPerformed(evt);
            }
        });

        jButtonEstado.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonEstado.setText("Estado");
        jButtonEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstadoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 0));
        jLabel7.setText("Incidencias generales...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUrgencia)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonEstado)
                        .addGap(49, 49, 49)
                        .addComponent(jButtonProfesor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonQuitarFiltro)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jButtonUrgencia))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonEstado)
                        .addComponent(jButtonProfesor)
                        .addComponent(jButtonQuitarFiltro)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1143, 621));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //INICIO FILTROS
        //Boton que llama al metodo de conultar profesor y hace un filtro
    private void jButtonProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProfesorActionPerformed
        try {
            consultarProfesor();
            if (opcionProfesor != null) {
                elQueOrdena.setRowFilter(RowFilter.regexFilter("(?i)" + opcionProfesor, 1));
            }
        } catch (HeadlessException ex) {
            java.util.logging.Logger.getLogger(ProfesoresPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MostrarIncidencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonProfesorActionPerformed
        //Metodo que consulta los profesores y los mete en un combo box y muestra un jOption pane
    public void consultarProfesor() throws SQLException {
        PreparedStatement ps = null;
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        ArrayList<String> profe = new ArrayList<>();
        String sql = "SELECT nombre_completo FROM mantenimiento_mollon.fp_profesor;";
        try {
            ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                profe.add(rs.getString(1));
            }
            String[] profeArray = new String[profe.size()];
            profeArray = profe.toArray(profeArray);
            opcionProfesor = JOptionPane.showInputDialog(null, "Selecciona la opcion por la que quieres filtrar", "Elegir", JOptionPane.QUESTION_MESSAGE, null, profeArray, profeArray[0]);
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion.close();
        }
    }

        //Boton para quitar los filtros aplicados
    private void jButtonQuitarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarFiltroActionPerformed
        elQueOrdena.setRowFilter(RowFilter.regexFilter("", 0));
    }//GEN-LAST:event_jButtonQuitarFiltroActionPerformed

        //Boton que llama al metodo de conultar urgencia y hace un filtro
    private void jButtonUrgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUrgenciaActionPerformed
        try {
            consultarUrgencia();
            if (opcionUrgencia != null) {
                elQueOrdena.setRowFilter(RowFilter.regexFilter("(?i)" + opcionUrgencia, 9));
            }
        } catch (HeadlessException ex) {
            java.util.logging.Logger.getLogger(ProfesoresPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MostrarIncidencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonUrgenciaActionPerformed
        //Metodo que consulta la urgencia y las mete en un combo box y muestra un jOption pane
    public void consultarUrgencia() throws SQLException {
        PreparedStatement ps = null;
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        ArrayList<String> ur = new ArrayList<>();
        String sql = "SELECT urgencia FROM mantenimiento_mollon.man_urgencia;";
        try {
            ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ur.add(rs.getString(1));
            }
            String[] urgenciaArray = new String[ur.size()];
            urgenciaArray = ur.toArray(urgenciaArray);
            opcionUrgencia = JOptionPane.showInputDialog(null, "Selecciona la urgencia por la que quieres filtrar", "Elegir", JOptionPane.QUESTION_MESSAGE, null, urgenciaArray, urgenciaArray[0]);
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion.close();
        }
    }

        //Boton que llama al metodo de conultar estado y hace un filtro
    private void jButtonEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstadoActionPerformed
        try {
            consultarEstado();
            if (opcionEstado != null) {
                elQueOrdena.setRowFilter(RowFilter.regexFilter("(?i)" + opcionEstado, 5));
            }
        } catch (HeadlessException ex) {
            java.util.logging.Logger.getLogger(ProfesoresPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MostrarIncidencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEstadoActionPerformed
        //Metodo que consulta un estado y los mete en un combo box y muestra un jOption pane
    public void consultarEstado() throws SQLException {
        PreparedStatement ps = null;
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        ArrayList<String> es = new ArrayList<>();
        String sql = "SELECT estado FROM mantenimiento_mollon.man_estado;";
        try {
            ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                es.add(rs.getString(1));
            }
            String[] estadoArray = new String[es.size()];
            estadoArray = es.toArray(estadoArray);
            opcionEstado = JOptionPane.showInputDialog(null, "Selecciona el estado por el que quieres filtrar", "Elegir", JOptionPane.QUESTION_MESSAGE, null, estadoArray, estadoArray[0]);
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion.close();
        }
    }
    //FIN FILTROS

    //Metodo para crear la tabla 
    public void rellenoTabla() throws SQLException {
        DefaultTableModel dtm = new DefaultTableModel();
        //Creamos las columnas que tendra la tabla
        dtm.setColumnIdentifiers(new String[]{"Numero de incidencia", "Creada por", "Descripcion", "Descripcion tecnica", "Horas de reparacion", "Estado", "Lazmiento", "Inicio reparacion", "Fin reparacion", "Nivel", "Clase", "Edificio", "Observaciones"});
        //Elemento para ordenar la tabla
        elQueOrdena = new TableRowSorter<TableModel>(dtm);
        //Ordenamos la tabla segun las columnas
        jTableIncidencias.setRowSorter(elQueOrdena);

        //A??adimos las columnas a la tabla
        jTableIncidencias.setModel(dtm);
        
        //Creamos la conexion y hacemos la consulta de todas las incidencias
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        String[] incidencia = new String[13];
        if (conexion != null) {

            try {
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery("select inc.id_incidencia,p.nombre_completo,inc.descripcion,inc.desc_tecnica,inc.horas, \n"
                        + "est.estado,inc.fecha,inc.fecha_ini_rep,inc.fecha_fin_rep,ur.urgencia,\n"
                        + "ub.ubicacion,ed.edificio,inc.observaciones\n"
                        + "from man_incidencias inc\n"
                        + "inner join fp_profesor p on p.id_profesor=inc.id_profesor_crea\n"
                        + "inner join man_estado est on est.id_estado = inc.id_estado\n"
                        + "inner join man_urgencia ur on ur.id_urgencia=inc.nivel_urgencia\n"
                        + "inner join man_ubicacion ub on ub.id_ubicacion=inc.id_ubicacion\n"
                        + "inner join man_edificio ed on ed.id_edificio=ub.id_edificio;");

                while (rs.next()) {
                    //Mentemos lo extrado de la base de datos en un array
                    incidencia[0] = rs.getString(1);
                    incidencia[1] = rs.getString(2);
                    incidencia[2] = rs.getString(3);
                    incidencia[3] = rs.getString(4);
                    incidencia[4] = rs.getString(5);
                    incidencia[5] = rs.getString(6);
                    incidencia[6] = rs.getString(7);
                    incidencia[7] = rs.getString(8);
                    incidencia[8] = rs.getString(9);
                    incidencia[9] = rs.getString(10);
                    incidencia[10] = rs.getString(11);
                    incidencia[11] = rs.getString(12);
                    incidencia[12] = rs.getString(13);

                    //Y lo insertamos en la base de datos
                    dtm.addRow(incidencia);
                }
            } catch (SQLException sQLException) {
                JOptionPane.showMessageDialog(this, "Datos no cargados");
            }
            conexion.close();

        } else {
            JOptionPane.showMessageDialog(this, "Conoxion fallida");
            conexion.close();
        }
        autoagustarColumnas(jTableIncidencias);

    }

    //Metodo para hacer que los datos se ajusten a las columnas en las que estan
    private void autoagustarColumnas(JTable table) {
        //Se obtiene el modelo de la columna
        TableColumnModel columnModel = table.getColumnModel();
        //Se obtiene el total de las columnas
        for (int column = 0; column < table.getColumnCount(); column++) {
            //Establecemos un valor minimo para el ancho de la columna
            int width = 60; //Min Width
            //Obtenemos el numero de filas de la tabla
            for (int row = 0; row < table.getRowCount(); row++) {
                //Obtenemos el renderizador de la tabla
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                //Creamos un objeto para preparar el renderer
                Component comp = table.prepareRenderer(renderer, row, column);
                //Establecemos el width segun el valor maximo del ancho de la columna
                width = Math.max(comp.getPreferredSize().width + 1, width);

            }
            //Se establece una condicion para no sobrepasar el valor de 300
            //Esto es Opcional
            if (width > 300) {
                width = 300;
            }
            //Se establece el ancho de la columna
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    
    
    //Creamos un popMenu que habre la pantalla de modifcar incidencia
    private void crearPopupMenu() throws SQLException {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem modificar = new JMenuItem("Reparar esta incidencia");

        popupMenu.add(modificar);

        jTableIncidencias.setComponentPopupMenu(popupMenu);

        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    modificarIncidencia();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ProfesoresPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    //Metodo que abre la pantalla de modificar incidencias si hay filas selecionadas
    public void modificarIncidencia() throws SQLException {
        int cuentaFilasSeleccionadas = jTableIncidencias.getSelectedRowCount();
        if (cuentaFilasSeleccionadas == 0) {
            JOptionPane.showMessageDialog(this, "No hay filas seleccionadas", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            int fila = jTableIncidencias.getSelectedRow();
            String idIncidencia = jTableIncidencias.getModel().getValueAt(fila, 0).toString();

            ModificaIncidencia modificarMiIncidencia = new ModificaIncidencia(this, true, idIncidencia, rolUsu);
            modificarMiIncidencia.setVisible(true);

            rellenoTabla();

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEstado;
    private javax.swing.JButton jButtonProfesor;
    private javax.swing.JButton jButtonQuitarFiltro;
    private javax.swing.JButton jButtonUrgencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableIncidencias;
    // End of variables declaration//GEN-END:variables

}
