/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Proveedor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emilio
 */
@ManagedBean (name = "proveedorBean")
@RequestScoped
public class ProveedorBean {
    public int id_proveedor;
    public String nombre;
    public String telefono;
    public String domicilio;
    public List<Proveedor> listProveedor;

    public List<Proveedor> getListProveedor() {
        return listProveedor;
    }

    public void setListProveedor(List<Proveedor> listProveedor) {
        this.listProveedor = listProveedor;
    }
    public ProveedorBean() {
        log();
    }

    public ProveedorBean(String nombre, String telefono, String domicilio) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public void insertar(){       
        Proveedor proveedor = new Proveedor(this.nombre, this.telefono, this.domicilio);
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("panaderiaPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(proveedor);
        em.getTransaction().commit();       
    }
    public void eliminar(){
        try{          
            EntityManagerFactory emf;
            emf = Persistence.createEntityManagerFactory("panaderiaPU");
            EntityManager em = emf.createEntityManager();
            em.getEntityManagerFactory();
            Proveedor proveedor = em.find(Proveedor.class, this.id_proveedor);
            em.getTransaction().begin();
            em.remove(proveedor);
            em.getTransaction().commit();
            
        }catch(Exception e){
            throw e;
        }
    }
    public void modificar(){
        try{          
            EntityManagerFactory emf;
            emf = Persistence.createEntityManagerFactory("panaderiaPU");
            EntityManager em = emf.createEntityManager();
            em.getEntityManagerFactory();
            Proveedor proveedor = em.find(Proveedor.class, this.id_proveedor);            
            em.getTransaction().begin();
            proveedor.setNombre(this.nombre);
            proveedor.setTelefono(this.telefono);
            proveedor.setDomicilio(this.domicilio);
            em.getTransaction().commit();
            
        }catch(Exception e){
            throw e;
        }
    }
    public void log(){
        Proveedor user;
        user = new Proveedor();  
        listProveedor = user.setItems();
        for (Proveedor a : listProveedor) {
        }    
    }
}
