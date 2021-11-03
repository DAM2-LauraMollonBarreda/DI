/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author damA
 */
public class JPanelImagen extends  JPanel implements Serializable{
    //para realizar una clase, tiene que implementar serializable
    // y tener un constructor sin parametros
    private File archivoImagen;
    private propiedadOpacidad opacidad;

    //Alt + insert y insertar el constructor vacio
    public JPanelImagen() {
    }

    public File getArchivoImagen() {
        return archivoImagen;
    }

    public void setArchivoImagen(File archivoImagen) {
        this.archivoImagen = archivoImagen;
    }

    public propiedadOpacidad getOpacidad() {
        return opacidad;
    }

    public void setOpacidad(propiedadOpacidad opacidad) {
        this.opacidad = opacidad;
    }

    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        //pintamos la imagen
        //creamos una imagen con la ruta elegida
        if (archivoImagen!=null && archivoImagen.exists()) {
            ImageIcon imageIcon= new ImageIcon(archivoImagen.getAbsolutePath());
            //para darle opacidad, a todo lo que dibujaremos a partir de ahora
            Graphics2D g2d = (Graphics2D)g;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,opacidad.getOpacidad()));
            //le pasamos la image, las cooredenadas de origen y un observer nulo
            g.drawImage(imageIcon.getImage(), 0, 0, this);
            //restauramos la opacidad a 1
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1));
           
            
        }
    }
    
}


