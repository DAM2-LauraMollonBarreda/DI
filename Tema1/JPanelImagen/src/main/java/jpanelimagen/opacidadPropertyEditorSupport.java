/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author damA
 */
public class opacidadPropertyEditorSupport extends PropertyEditorSupport {
    private opacidadPanel panelOpacidad = new opacidadPanel();
    
    //Devuelve si existe un editor personalizado
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    //solicita el panel que tiene que colocar el editor
    @Override
    public Component getCustomEditor() {
        return panelOpacidad;
    }

    @Override
    public String getJavaInitializationString() {
        return super.getJavaInitializationString(); //To change
    }
    
    //Devuelve los valores que el usuario a introducido
    @Override
    public Object getValue() {
        return panelOpacidad.getSelectValue();
    }
    
}
