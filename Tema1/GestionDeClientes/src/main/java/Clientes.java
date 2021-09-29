
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author damA
 */
public class Clientes {
    private String nombre;
    private String apellido;
    private Date fechaAlta;
    private String provincias;

    public Clientes(String nombre, String apellido, Date fechaAlta, String provincias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaAlta = fechaAlta;
        this.provincias = provincias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getProvincias() {
        return provincias;
    }

    public void setProvincias(String provincias) {
        this.provincias = provincias;
    }
    
    public String[] toArrayString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String [] s = new String[4];
        s[0]=nombre;
        s[1]= apellido;
        s[2]= sdf.format(fechaAlta);
        s[3]= provincias;
        return s;
    }
    
    
}
