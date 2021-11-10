/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlabelreloj;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author damA
 */
public class propiedadAlarma implements Serializable{
    private Date horaFecha;
    
    private boolean activa;

    public propiedadAlarma(Date horaFecha, boolean activa) {
        this.horaFecha = horaFecha;
        this.activa = activa;
    }

    
    public Date getHoraFecha() {
        return horaFecha;
    }
    public void setHoraFecha(Date horaFecha) {
        this.horaFecha = horaFecha;
    }

    
    public boolean isActiva() {
        return activa;
    }
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
 
    
}
