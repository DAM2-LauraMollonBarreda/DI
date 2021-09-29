/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author damA
 */
public class Usuarios {
    private String profesion;
    private String edad;
    private int hermanos;
    private String sexo;
    private String deporte;
    private String cual;
    private int compras;
    private int tele;
    private int cine;
    
    public Usuarios (String profesion, String edad, int hermanos, String sexo, String deporte, String cual, int compras, int tele, int cine){
        this.profesion = profesion;
        this.edad =edad;
        this.hermanos = hermanos;
        this.sexo=sexo;
        this.deporte=deporte;
        this.cual=cual;
        this.compras = compras;
        this.tele=tele;
        this.cine=cine;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public int getHermanos() {
        return hermanos;
    }

    public void setHermanos(int hermanos) {
        this.hermanos = hermanos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String isDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getCual() {
        return cual;
    }

    public void setCual(String cual) {
        this.cual = cual;
    }

    public int getCompras() {
        return compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

    public int getTele() {
        return tele;
    }

    public void setTele(int tele) {
        this.tele = tele;
    }

    public int getCine() {
        return cine;
    }

    public void setCine(int cine) {
        this.cine = cine;
    }
    
     public String[] toArrayString(){
        String[] s = new String[9];
        s[0]=profesion;
        s[1]=edad;
        s[2]= String.valueOf(hermanos);
        s[3]=sexo;
        s[4] = deporte;
        s[5]= cual;
        s[6]= String.valueOf(compras);
        s[7]= String.valueOf(tele);
        s[8]= String.valueOf(cine);
        return s;
    }
    
    
    
}
