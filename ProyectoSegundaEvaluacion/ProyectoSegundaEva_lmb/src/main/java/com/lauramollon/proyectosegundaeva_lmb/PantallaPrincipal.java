/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lauramollon.proyectosegundaeva_lmb;

import Email.EnviarCorreo;
import Incidencias.Estadistica;
import Incidencias.InsertarIncidencia;
import Incidencias.ModificaIncidencia;
import Incidencias.MostrarIncidencias;
import Profesores.ProfesoresPrincipal;
import baseDatos.Conectar;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author damA
 */
public class PantallaPrincipal extends javax.swing.JDialog {

    //Variables que usuaremos durante todo el programa
    String usuRol = "";
    String usuario = "";
    Conectar conectar = null;
    SimpleDateFormat fechaLarga=new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat fechaCorta=new SimpleDateFormat("dd-MM-yy");
    boolean selectFecha;

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal(java.awt.Frame parent, boolean modal, String rol, String usu) throws SQLException {
        super(parent, modal);
        //Guardamos en la variables creadas a nivel de clase los datos que traemos desde la pantalla de autenticacion
        usuRol = rol;
        usuario = usu;
        
        
        initComponents();
        Toolkit. getDefaultToolkit(). getScreenSize();

       
        controlUsuarios();
        rellenoComboAnexo();
        rellenoTabla();
        crearPopupMenu();
       
        jTableMisIncidencias.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ponLaAyuda();
        
        
        
        

    }

    /**
     * Hace que el item del menu y la pulsacion de F1 visualicen la ayuda.
     */
    private void ponLaAyuda() {
        try {
            // Carga el fichero de ayuda
            File fichero = new File("./src/main/java/help/help_set.hs");
            URL hsURL = fichero.toURI().toURL();

            // Crea el HelpSet y el HelpBroker
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();

            // Pone ayuda a item de menu al pulsarlo y a F1 en ventana
            // principal y secundaria.
            hb.enableHelpOnButton(jButtonAyuda, "aplicacion", helpset);
            hb.enableHelpKey(this.getRootPane(), "aplicacion", helpset);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //METODO PARA OCULTAR DEPENDIENDO DEL USUARIO QUE ES EL QUE ESTA CONECTADO
    public void controlUsuarios() {
        //SI EL USUARO ES ROOT
        if (usuRol.equals("root")) {
            jMenuItemProfesores.setVisible(true);
            jMenuItemIncidencias.setVisible(true);
            jMenuItemEstadisticaMes.setVisible(true);
            jMenuIncidencias.setVisible(true);
            jComboBoxEstadosInci.setVisible(true);
            jLabelAnexo.setVisible(true);
            jButtonImprimir.setVisible(true);
            //SI EL USUARIO ES TECNICO
        } else if (usuRol.equals("tecnico")) {
            jMenuItemProfesores.setVisible(true);
            jMenuItemIncidencias.setVisible(true);
            jMenuItemEstadisticaMes.setVisible(false);
            jMenuIncidencias.setVisible(true);
            jComboBoxEstadosInci.setVisible(false);
            jLabelAnexo.setVisible(false);
            jButtonImprimir.setVisible(false);
            //SI EL USUARIO ES PROFESOR
        } else if (usuRol.equals("profesor")) {
            jMenuItemProfesores.setVisible(true);
            jMenuItemIncidencias.setVisible(false);
            jMenuItemEstadisticaMes.setVisible(false);
            jMenuIncidencias.setVisible(false);
            jComboBoxEstadosInci.setVisible(false);
            jLabelAnexo.setVisible(false);
            jButtonImprimir.setVisible(false);

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

        jButtonInsertarIncidencia = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMisIncidencias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabelAnexo = new javax.swing.JLabel();
        jComboBoxEstadosInci = new javax.swing.JComboBox<>();
        jButtonImprimir = new javax.swing.JButton();
        jButtonAyuda = new javax.swing.JButton();
        jCheckBoxFormatoFecha = new javax.swing.JCheckBox();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuGo = new javax.swing.JMenu();
        jMenuIncidencias = new javax.swing.JMenu();
        jMenuItemIncidencias = new javax.swing.JMenuItem();
        jMenuItemEstadisticaMes = new javax.swing.JMenuItem();
        jMenuItemImprimirIncidencias = new javax.swing.JMenuItem();
        jMenuItemProfesores = new javax.swing.JMenuItem();
        jMenuItemEnviarCorreo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButtonInsertarIncidencia.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jButtonInsertarIncidencia.setText("Crear incidecia");
        jButtonInsertarIncidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarIncidenciaActionPerformed(evt);
            }
        });

        jTableMisIncidencias.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jTableMisIncidencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMisIncidencias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableMisIncidenciasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMisIncidencias);

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Tus incidencias son...");

        jLabelAnexo.setFont(new java.awt.Font("Lucida Sans", 2, 14)); // NOI18N
        jLabelAnexo.setForeground(new java.awt.Color(255, 204, 0));
        jLabelAnexo.setText("Anexo de incidencias, dependiendo del estado ");

        jComboBoxEstadosInci.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N

        jButtonImprimir.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        jButtonAyuda.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        jButtonAyuda.setText("?");
        jButtonAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAyudaActionPerformed(evt);
            }
        });

        jCheckBoxFormatoFecha.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jCheckBoxFormatoFecha.setText("Formato de fecha largo");
        jCheckBoxFormatoFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxFormatoFechaMouseClicked(evt);
            }
        });
        jCheckBoxFormatoFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxFormatoFechaActionPerformed(evt);
            }
        });

        jMenuGo.setText("Ir a..");
        jMenuGo.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jMenuGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGoActionPerformed(evt);
            }
        });

        jMenuIncidencias.setText("Incidencias");
        jMenuIncidencias.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N

        jMenuItemIncidencias.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jMenuItemIncidencias.setText("Mostrar");
        jMenuItemIncidencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIncidenciasActionPerformed(evt);
            }
        });
        jMenuIncidencias.add(jMenuItemIncidencias);

        jMenuItemEstadisticaMes.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jMenuItemEstadisticaMes.setText("Grafico de incidencias por mes");
        jMenuItemEstadisticaMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstadisticaMesActionPerformed(evt);
            }
        });
        jMenuIncidencias.add(jMenuItemEstadisticaMes);

        jMenuItemImprimirIncidencias.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jMenuItemImprimirIncidencias.setText("Imprimir incidencias");
        jMenuItemImprimirIncidencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImprimirIncidenciasActionPerformed(evt);
            }
        });
        jMenuIncidencias.add(jMenuItemImprimirIncidencias);

        jMenuGo.add(jMenuIncidencias);

        jMenuItemProfesores.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jMenuItemProfesores.setText("Profesores");
        jMenuItemProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProfesoresActionPerformed(evt);
            }
        });
        jMenuGo.add(jMenuItemProfesores);

        jMenuItemEnviarCorreo.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jMenuItemEnviarCorreo.setText("Enviar correo");
        jMenuItemEnviarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEnviarCorreoActionPerformed(evt);
            }
        });
        jMenuGo.add(jMenuItemEnviarCorreo);

        jMenuBar.add(jMenuGo);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBoxFormatoFecha)
                        .addGap(45, 45, 45)
                        .addComponent(jButtonAyuda))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxEstadosInci, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonImprimir))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonInsertarIncidencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelAnexo))))
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonAyuda)
                    .addComponent(jCheckBoxFormatoFecha))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonInsertarIncidencia)
                .addGap(13, 13, 13)
                .addComponent(jLabelAnexo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEstadosInci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonImprimir))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1028, 721));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGoActionPerformed

    }//GEN-LAST:event_jMenuGoActionPerformed

    private void jMenuItemProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProfesoresActionPerformed

        try {
            //Si se presiona el item se abre la pantalla de mostrar todos los profesores (dependiende del usuario)
            ProfesoresPrincipal pantallaProfesores = new ProfesoresPrincipal(this, true, usuRol);
            pantallaProfesores.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItemProfesoresActionPerformed

    private void jMenuItemIncidenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIncidenciasActionPerformed
        try {
            //Si se presiona el item se abre la pantalla de mostrar todas las incidencias (dependiendo del usuario)
            MostrarIncidencias pantallaIncidencias = new MostrarIncidencias(this, true, usuRol);
            pantallaIncidencias.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemIncidenciasActionPerformed

    private void jButtonInsertarIncidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarIncidenciaActionPerformed
        try {
            //Si se presiona el boton se abre la pantalla de insertar incidencia
            InsertarIncidencia pantallaIncidenciaInsertar = new InsertarIncidencia(this, true, usuario);
            pantallaIncidenciaInsertar.setVisible(true);
            rellenoTabla();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProfesoresPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonInsertarIncidenciaActionPerformed

    private void jMenuItemEstadisticaMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEstadisticaMesActionPerformed
        try {
            //Si se presiona el item se habre la pantalla del grafico de las incidencias del mes
            Estadistica pantallaIncidencias = new Estadistica(this, true);
            pantallaIncidencias.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MostrarIncidencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemEstadisticaMesActionPerformed

    private void jTableMisIncidenciasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableMisIncidenciasKeyReleased

    }//GEN-LAST:event_jTableMisIncidenciasKeyReleased

    private void jMenuItemEnviarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEnviarCorreoActionPerformed
        try {
            //Si se presiona el item se habre la pantalla del correo
            EnviarCorreo pantallaEnviarCorreo = new EnviarCorreo(this, true);
            pantallaEnviarCorreo.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MostrarIncidencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemEnviarCorreoActionPerformed

    private void jMenuItemImprimirIncidenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImprimirIncidenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemImprimirIncidenciasActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        try {
            //Cargar driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Llamamos a la clase conectar
            conectar = new Conectar();
            //Creamos la conxion
            Connection conexion = conectar.getConexion();
            Map parametros = new HashMap();

            String esta = jComboBoxEstadosInci.getSelectedItem().toString();
            String[] estados = esta.split("-");
            String idEstado = estados[0];

            parametros.put("estado", idEstado);

            JasperPrint print = JasperFillManager.fillReport(".\\src\\main\\java\\Informes\\DetalleIncidencia.jasper", parametros, conexion);

            JFileChooser chooser = new JFileChooser();

            //Para que solo de deje escojer archivos pdf
            chooser.setAcceptAllFileFilterUsed(false);
            //Ponemos la opcion de pdf en el file chooser 
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.pdf", "pdf");
            chooser.setFileFilter(filtro);

            //Abrimos el JFileChooser y guardamos el resultado en seleccion
            int seleccion = chooser.showOpenDialog(this);
            //Si el usuario ha pulsado la opci??n Aceptar
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                //Guarda la factura creada en el informe en la ruta elegida por el usuario
                JasperExportManager.exportReportToPdfFile(print, chooser.getSelectedFile().getAbsolutePath() + ".pdf");
                //Muestra un dialogo
                JOptionPane.showMessageDialog(this, "Las incidencias han sido imprimidas");
            } else {
                JOptionPane.showMessageDialog(this, "No hay fichero selecionado", "Error!", JOptionPane.ERROR_MESSAGE);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jButtonAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAyudaActionPerformed

    private void jCheckBoxFormatoFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxFormatoFechaActionPerformed

    }//GEN-LAST:event_jCheckBoxFormatoFechaActionPerformed

    private void jCheckBoxFormatoFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxFormatoFechaMouseClicked
        try {
            selectFecha = jCheckBoxFormatoFecha.isSelected();
            rellenoTabla();
        } catch (SQLException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBoxFormatoFechaMouseClicked

    public void rellenoTabla() throws SQLException {
        //Creamos el modelo de la tabla
        DefaultTableModel dtm = new DefaultTableModel();
        //Creamos las columnas que tendra la tabla
        dtm.setColumnIdentifiers(new String[]{"Numero incidencia", "Creada por", "Descripcion", "Descripcion tecnica", "Horas de reparacion", "Estado", "Lazmiento", "Inicio reparacion", "Fin reparacion", "Nivel", "Clase", "Edificio", "Observaciones"});
        //Elemento para ordenar la tabla
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(dtm);
        //Ordenamos la tabla segun las columnas
        jTableMisIncidencias.setRowSorter(elQueOrdena);

        //A??adimos las columnas a la tabla
        jTableMisIncidencias.setModel(dtm);

        //Llamamos a la clase conectar
        conectar = new Conectar();
        //Creamos la conxion
        Connection conexion = conectar.getConexion();
        //Creamos el array para guardar los datos cojidos de la base de datos
        String[] incidencia = new String[13];
        //Si la conexion esta bien echa
        if (conexion != null) {

            try {
                Statement s = conexion.createStatement();
                //Guardamos la consulta ha hacer
                ResultSet rs = s.executeQuery("select inc.id_incidencia,p.nombre_completo,inc.descripcion,inc.desc_tecnica,inc.horas, \n"
                        + "est.estado,inc.fecha,inc.fecha_ini_rep,inc.fecha_fin_rep,ur.urgencia,\n"
                        + "ub.ubicacion,ed.edificio,inc.observaciones\n"
                        + "from man_incidencias inc\n"
                        + "inner join fp_profesor p on p.id_profesor=inc.id_profesor_crea\n"
                        + "inner join man_estado est on est.id_estado = inc.id_estado\n"
                        + "inner join man_urgencia ur on ur.id_urgencia=inc.nivel_urgencia\n"
                        + "inner join man_ubicacion ub on ub.id_ubicacion=inc.id_ubicacion\n"
                        + "inner join man_edificio ed on ed.id_edificio=ub.id_edificio\n"
                        + "where p.login='" + usuario + "'");
                //Mientras queden datos 
                while (rs.next()) {
                    //Guardamos los datos en el array creado antes

                    incidencia[0] = rs.getString(1);
                    incidencia[1] = rs.getString(2);
                    incidencia[2] = rs.getString(3);
                    incidencia[3] = rs.getString(4);
                    incidencia[4] = rs.getString(5);
                    incidencia[5] = rs.getString(6);
                    if (selectFecha==true) {
                        Date fecha = rs.getDate(7);
                        incidencia[6] = fechaLarga.format(fecha);
                    }else if (selectFecha==false){
                        Date fecha = rs.getDate(7);
                        incidencia[6] = fechaCorta.format(fecha);
                    }
                    incidencia[7] = rs.getString(8);
                    incidencia[8] = rs.getString(9);
                    incidencia[9] = rs.getString(10);
                    incidencia[10] = rs.getString(11);
                    incidencia[11] = rs.getString(12);
                    incidencia[12] = rs.getString(13);

                    //Metemos en las filas del modelo (tabla) los datos extraidos
                    dtm.addRow(incidencia);
                }
            } catch (SQLException sQLException) {

                JOptionPane.showMessageDialog(this, "Datos no cargados");
            }
            conexion.close();

        } else {
            //Si la conexion esta mal echa muestra mensaje por pantalla
            JOptionPane.showMessageDialog(this, "Conoxion fallida");
        }
        
        autoagustarColumnas(jTableMisIncidencias);

    }

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

    private void crearPopupMenu() throws SQLException {
        //Creamos el popmenu y insertamos los campos
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem modificar = new JMenuItem("Modificar esta incidencia");

        popupMenu.add(modificar);

        //A??adidos el popupmenu a la tabla
        jTableMisIncidencias.setComponentPopupMenu(popupMenu);

        //Cuando se clike sobre el el item modifica esta incidencia
        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    //Llamamo al metodo para actualizar la incidencia
                    modificarIncidencia();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(ProfesoresPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    public void modificarIncidencia() throws SQLException {
        //Guarmamos la fila que esta seleccionada en una variable
        int cuentaFilasSeleccionadas = jTableMisIncidencias.getSelectedRowCount();
        //Si no hay fila seleccionada
        if (cuentaFilasSeleccionadas == 0) {
            //Muestra mensaje de error
            JOptionPane.showMessageDialog(this, "No hay filas seleccionadas", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            //Guarda la fila seleccionada 
            int fila = jTableMisIncidencias.getSelectedRow();
            //Guarda el valor de la fila en una variable
            String idIncidencia = jTableMisIncidencias.getModel().getValueAt(fila, 0).toString();

            //Pasamos a la pantalla de modicar la incidencia y le pasamos el id de la incidencia y el rol
            ModificaIncidencia modificarMiIncidencia = new ModificaIncidencia(this, true, idIncidencia, usuRol);
            modificarMiIncidencia.setVisible(true);

            rellenoTabla();

        }
    }

    public void rellenoComboAnexo() throws SQLException {

        PreparedStatement ps = null;
        conectar = new Conectar();
        Connection conexion = conectar.getConexion();
        String sql = "SELECT id_estado,estado FROM mantenimiento_mollon.man_estado;";
        try {
            ps = conexion.prepareStatement(sql);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                jComboBoxEstadosInci.addItem(result.getString("id_estado") + "-" + result.getString("estado"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        conexion.close();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAyuda;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonInsertarIncidencia;
    private javax.swing.JCheckBox jCheckBoxFormatoFecha;
    private javax.swing.JComboBox<String> jComboBoxEstadosInci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAnexo;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuGo;
    private javax.swing.JMenu jMenuIncidencias;
    private javax.swing.JMenuItem jMenuItemEnviarCorreo;
    private javax.swing.JMenuItem jMenuItemEstadisticaMes;
    private javax.swing.JMenuItem jMenuItemImprimirIncidencias;
    private javax.swing.JMenuItem jMenuItemIncidencias;
    private javax.swing.JMenuItem jMenuItemProfesores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMisIncidencias;
    // End of variables declaration//GEN-END:variables

}
