
import java.io.Serializable;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author damA
 */
public class JTextFielPlaceHold extends JTextField implements Serializable{

    private String PlaceHolder;
    public JTextFielPlaceHold() {
        this.setText(PlaceHolder);
    }

    public String getPlaceHolder() {
        return PlaceHolder;
    }

    public void setPlaceHolder(String PlaceHolder) {
        this.PlaceHolder = PlaceHolder;
    }
    
    
}
