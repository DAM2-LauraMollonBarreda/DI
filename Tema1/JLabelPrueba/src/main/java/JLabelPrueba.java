
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.Serializable;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author damA
 */
public class JLabelPrueba extends  JLabel implements  Serializable{

    private String PruevaString;
    private boolean PruebaBoolean;
    private Color PruebaColor;
    private Font PruebaFont;
    private File PrivateFile;
    
    public JLabelPrueba() {
    }

    public boolean isPruebaBoolean() {
        return PruebaBoolean;
    }

    public void setPruebaBoolean(boolean PruebaBoolean) {
        this.PruebaBoolean = PruebaBoolean;
    }
    

    public String getPruevaString() {
        return PruevaString;
    }

    public void setPruevaString(String PruevaString) {
        this.PruevaString = PruevaString;
    }

    public Color getPruebaColor() {
        return PruebaColor;
    }

    public void setPruebaColor(Color PruebaColor) {
        this.PruebaColor = PruebaColor;
    }

    public Font getPruebaFont() {
        return PruebaFont;
    }

    public void setPruebaFont(Font PruebaFont) {
        this.PruebaFont = PruebaFont;
    }

    public File getPrivateFile() {
        return PrivateFile;
    }

    public void setPrivateFile(File PrivateFile) {
        this.PrivateFile = PrivateFile;
    }
    
    
    
    
}
