/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author pc
 */
public class Caja {
    public int id;
    public String t_transaccion;
    public double dinero;
    public int nro_Clientes;
    public Caja LinkCaja;
    public Cliente LinkCliente;
}



 
    /*
    static Nodo Eliminar(Nodo ptr,int Elem){
        Nodo p = ptr;
        Nodo q = null;
        while(p.Numero != Elem &&  p != null){
            q = p;
            p = p.link;
        }
        if (p.Numero == Elem) {
            if (p == ptr) {
                ptr = ptr.link;
            }else{
                q.link = p.link;
                p.link = null;
            }
        }
        return ptr;
    }*/