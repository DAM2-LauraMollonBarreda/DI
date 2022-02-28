/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Incidencias;

import baseDatos.Conectar;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author laura
 */
public class Estadistica extends javax.swing.JDialog {

    Conectar conectar = null;

    /**
     * Creates new form Estadistica
     */
    public Estadistica(javax.swing.JDialog parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        numeroIncidencias();

    }

    public void numeroIncidencias() throws SQLException {

        conectar = new Conectar();
        Connection conexion = conectar.getConexion();

        if (conexion != null) {

            try {
                DefaultCategoryDataset datos = new DefaultCategoryDataset();
                Statement s = conexion.createStatement();
                ResultSet rs = s.executeQuery("SELECT MonthName(fecha) AS mes, count(*) AS numFilas FROM man_incidencias GROUP BY mes");

                while (rs.next()) {
                    //dtm.addRow(rs);
                    datos.setValue(rs.getInt(2), "", rs.getString(1));
                }
                //Se crea el gráfico y se asignan algunas caracteristicas
                JFreeChart grafico_barras = ChartFactory.createBarChart("Incidencias por mes", "Meses", "Numero incidencias", datos, PlotOrientation.VERTICAL, false, false, false);

                //CAMBIAR EL COLOR DE LAS BARRAS 
              
                BarRenderer r = (BarRenderer) grafico_barras.getCategoryPlot().getRenderer();
                r.setSeriesPaint(0, Color.ORANGE);

                //Se guarda el grafico
                BufferedImage image = grafico_barras.createBufferedImage(814, 542);

                //Se crea la imagen y se agrega al label creado desde diseño
                grafico.setIcon(new ImageIcon(image));

                pack();
                repaint();
            } catch (SQLException sQLException) {
                JOptionPane.showMessageDialog(this, "Datos no cargados");
            }
            conexion.close();

        } else {
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

        grafico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grafico, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grafico, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(848, 601));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel grafico;
    // End of variables declaration//GEN-END:variables
}