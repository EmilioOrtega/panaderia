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
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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
    public int id_factura;
    public String fecha;
    public String total;
    public int id_cliente;
    public int id_pan;
    public List<Pan> listPan;
    public List<Cliente> listCliente;

    public List<Pan> getListPan() {
        return listPan;
    }

    public void setListPan(List<Pan> listPan) {
        this.listPan = listPan;
    }
    
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
        try{
            int id=0;
            String name="", howMuch="", cad="";
            Pan pan;
            pan = new Pan();  
            listPan = pan.conmprarPan(this.id_pan);
            for(Pan a : listPan){
                id = a.getId_pan();
                name = a.getNombre();
                this.total = a.getPrecio();
                howMuch = a.getCantidad();
                cad = a.getCaducidad();
            }
            int a=0;
            a = Integer.parseInt(howMuch);
            a-=1;
            howMuch = String.valueOf(a);
            PanBean panBean = new PanBean();
            panBean.unPanMenos(id, name, this.total, howMuch, cad);
        }catch(Exception e){
            throw e;
        }
    
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getId_cliente() {
        try{
            String name = LoginBean.usuario;
            Cliente cliente;
            cliente = new Cliente();  
            listCliente = cliente.login(name);
            for(Cliente a : listCliente){
                this.id_cliente = a.getId_cliente();
            }
        }catch(Exception e){
            throw e;
        }
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
        getTotal();
        getId_cliente();
        Date objDate = new Date();
        this.fecha = objDate.toString();
        
        
        Factura factura = new Factura(this.fecha, this.total, this.id_cliente, this.id_pan);
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("panaderiaPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(factura);
        em.getTransaction().commit();       
    }
    
}
