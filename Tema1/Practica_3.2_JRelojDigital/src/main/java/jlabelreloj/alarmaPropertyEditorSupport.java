/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlabelreloj;

import java.awt.Component;
import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 *
 * @author damA
 */
public class alarmaPropertyEditorSupport extends PropertyEditorSupport{

    private alarmaPanel panelAlarma = new alarmaPanel();
    @Override
    public boolean supportsCustomEditor() {
        return true;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component getCustomEditor() {
        return panelAlarma; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJavaInitializationString() {
        propiedadAlarma alarma = panelAlarma.getSelectValue();
        return "new jlabelreloj.propiedadAlarma(new java.util.Date("+alarma.getHoraFecha().getTime()+"l),"+alarma.isActiva()+")";
    }

    @Override
    public Object getValue() {
        return panelAlarma.getSelectValue(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
