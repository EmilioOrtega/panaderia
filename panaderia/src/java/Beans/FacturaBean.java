/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Pan;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emilio
 */
@ManagedBean (name = "facturaBean")
@RequestScoped
public class FacturaBean {
    private int id_factura;
    private String fecha;
    private String total;
    private int id_cliente;
    private int id_pan;

    public FacturaBean() {
    }

    public FacturaBean(String cantidad, String fecha, String Total, int id_cliente, int id_pan) {;
        this.fecha = fecha;
        this.total = Total;
        this.id_cliente = id_cliente;
        this.id_pan = id_pan;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_pan() {
        return id_pan;
    }

    public void setId_pan(int id_pan) {
        this.id_pan = id_pan;
    }
    public void insertar(){  
        PanBean pan = new PanBean();
        Date objDate = new Date();
        Cliente user;
        user = new Cliente();  
            
        ClientInsert cliente = new ClientInsert();
        cliente.listClientes = user.login(cliente.nombre);
        for (Cliente a : cliente.listClientes) {
                this.id_cliente = a.getId_cliente();
        }
        
        this.total = pan.precio;
        this.fecha = objDate.toString();
        
        Factura factura = new Factura("a", "a", 35, 40);
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("panaderiaPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(factura);
        em.getTransaction().commit();       
    }
    
}
