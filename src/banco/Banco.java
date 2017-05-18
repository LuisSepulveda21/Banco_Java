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
public class Banco {

    private Caja ListaCaja; //ListaSimple
    private Cliente ListaCliente; //ListaDoble
    static Caja ptr;

    public static void main(String[] args) {
        Vista F = new Vista();
        F.setVisible(true);
        ptr = null;
    }

    public Caja getPtr() {
        return ptr;
    }

    public void setPtr(Caja ptr) {
        Banco.ptr = ptr;
    }

    public Caja AgregarCaja(Caja ptr, int id, String transaccion, double dinero, int nro) {
        Caja p = new Caja();
        p.id = id;
        p.t_transaccion = transaccion;
        p.dinero = dinero;
        p.nro_Clientes = nro;
        if (ptr == null) {
            System.out.println("nulo");
            ptr = p;
        } else {
            System.out.println("...");
            Caja q = ptr;
            while (q.LinkCaja != null) {
                q = q.LinkCaja;
            }
            q.LinkCaja = p;
        }
        return ptr;
    }

    public Caja agregarCliente(Caja ptr, int id_caja, int id_client, String transaccion) {
        Caja caja = ptr;
        while (caja != null && caja.id != id_caja) {
            caja = caja.LinkCaja;
        }
        if (caja == null) {
            return ptr;
        }
        Cliente q = caja.LinkCliente;
        Cliente r = new Cliente();
        r.id = id_client;
        r.t_transaccion = transaccion;

        if (q == null) {
            caja.LinkCliente = r;

        } else {
            while (q.RLink != null) {
                q = q.RLink;
            }
            q.RLink = r;
            r.RLink = null;
            r.LLink = q;
        }
        caja.nro_Clientes++;
        return ptr;
    }

    public void addToCaja(String idCliente, String tipoTrans) {
        Caja caja = this.ptr;
        int numC = 99999999;
        int id = 0;
        while (caja != null) {

            if (caja.t_transaccion.equals(tipoTrans) && caja.nro_Clientes <= numC) {
                numC = caja.nro_Clientes;
                id = caja.id;
                System.out.println("Encontro Caja");
            }
            caja = caja.LinkCaja;

        }
        agregarCliente(this.ptr, id, Integer.parseInt(idCliente), tipoTrans);
    }

    public void Mostrar(Caja ptr) {
        Caja p = ptr;
        while (p != null) {
            System.out.println("Caja ID:" + p.id + " // " + "Capital:$"+ p.dinero);
            Cliente q = p.LinkCliente;
            while (q != null) {
                System.out.println("     ------> " + q.id + "______" + q.t_transaccion);
                q = q.RLink;
            }
            p = p.LinkCaja;
        }

    }

    public Caja EliminarCaja(Caja ptr, int Id_caja) {

        Caja p = ptr;
        Caja q = null;
        while (p.id != Id_caja && p != null) {
            q = p;
            p = p.LinkCaja;
        }
        if (p.id == Id_caja) {

            if (p.nro_Clientes != 0) {
                if (p == ptr) {
                    ptr = ptr.LinkCaja;
                } else {
                    q.LinkCaja = p.LinkCaja;
                    p.LinkCaja = null;
                }
            } else {

                //
            }
        } else {

            //
        }

        return ptr;
    }

}
