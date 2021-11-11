package jlabelreloj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author damA
 */
public class JLabelReloj extends JLabel implements Serializable {
    
    //Creando los getter y setter de este boolean crearemos una propiedad del mismo nombre que sera un check box
    private boolean horas24;
    private SimpleDateFormat formato24h = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat formato12h = new SimpleDateFormat("hh:mm:ss");
    
    //propiedad para crear la alarma
    private propiedadAlarma alarma;
    
    //para hacer sonar la alarma
    private SuenaListener suenaListener;
    
    public JLabelReloj() {
        Timer timerr = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
             Date date = new Date();
             //Si el check box esta señalado pondra el formato en 24h
             if (horas24) {
                 setText(formato24h.format(date));
             //Si no pondra formato 12h
            }else{
                setText(formato12h.format(date));
            }
             
            if(alarma!=null){
                if (alarma.isActiva()&& comprabar(date,alarma.getHoraFecha())) {
                     if (suenaListener!=null) {
                            suenaListener.suena();
                        }
                }
            }
 
        }
          
    });
    timerr.start();
    }

    
    public boolean comprabar(Date date, Date horaFecha) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar1.setTime(horaFecha);
        if (calendar1.get(Calendar.HOUR)==calendar2.get(Calendar.HOUR)&& 
            calendar1.get(Calendar.MINUTE)== calendar2.get(Calendar.MINUTE)&&
            calendar1.get(Calendar.SECOND)==calendar2.get(Calendar.SECOND)) 
        {
            return true;
        }else{
            return false;
        }
       
    }
    
    public boolean isHoras24() {
        return horas24;
    }

    public void setHoras24(boolean horas24) {
        this.horas24 = horas24;
    }

    
    
    
    public propiedadAlarma getAlarma() {
        return alarma;
    }

    public void setAlarma(propiedadAlarma alarma) {
        this.alarma = alarma;
    }
    
    
    

    public SuenaListener getSuenaListener() {
        return suenaListener;
    }

    public void setSuenaListener(SuenaListener suenaListener) {
        this.suenaListener = suenaListener;
    }
    
 
}





/*PARA COMPROBAR SI FUNCIONA EN EL FORMULARIO METER ESTE CODIGO*/

  /*public NewJFrame() {
        initComponents();
        jLabelReloj1.setSuenaListener(new SuenaListener() {
            @Override
            public void suena() {
                msg();
            }
        });
    }

    public void msg() {
        JOptionPane.showConfirmDialog(this, "La alarma esta sonando");
    }*/

