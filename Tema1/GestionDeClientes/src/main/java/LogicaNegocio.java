
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
public class LogicaNegocio {
    private static List<Clientes> listaClientes = new ArrayList<>();
    
    public static void anadirCliente(Clientes clientes){
        listaClientes.add(clientes);
    }

    public static List<Clientes> getListaClientes() {
        return listaClientes;
    }
     
}
