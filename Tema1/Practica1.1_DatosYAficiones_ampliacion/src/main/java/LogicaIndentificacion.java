
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author damA
 */
public class LogicaIndentificacion {
    public static List<Usuarios> listaUsuarios = new ArrayList<>();
    
    public static void anadirUsuarios(Usuarios usuarios){
        listaUsuarios.add(usuarios);
    }

    public static List<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }
      
}
