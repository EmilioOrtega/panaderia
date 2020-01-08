/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import Modelo.Pan;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emilio
 */
@ManagedBean (name = "panBean")
@RequestScoped
public class PanBean {
    
    public int id_pan;
    public String nombre;
    public String precio;
    public String cantidad;
    public String caducidad;
    public int id_departamento;
    
    public List<Pan> listPan;

    public List<Pan> getListPan() {
        return listPan;
    }

    public void setListPan(List<Pan> listPan) {
        this.listPan = listPan;
    }
    public PanBean() {
        log();
    }

    public PanBean(String nombre, String precio, String cantidad, String caducidad, int id_departamento) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.caducidad = caducidad;
        this.id_departamento = id_departamento;
    }

    public int getId_pan() {
        return id_pan;
    }

    public void setId_pan(int id_pan) {
        this.id_pan = id_pan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }
    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }
    public void insertar(){       
        Pan pan = new Pan(this.nombre, this.precio, this.cantidad, this.caducidad, this.id_departamento);
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("panaderiaPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pan);
        em.getTransaction().commit(); 
        em.close();
    }
    public void eliminar(){
        try{          
            EntityManagerFactory emf;
            emf = Persistence.createEntityManagerFactory("panaderiaPU");
            EntityManager em = emf.createEntityManager();
            em.getEntityManagerFactory();
            Pan pan = em.find(Pan.class, this.id_pan);            
            em.getTransaction().begin();
            em.remove(pan);   
            em.getTransaction().commit();
            em.close();
            
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
            Pan ingrediente = em.find(Pan.class, this.id_pan);            
            em.getTransaction().begin();
            ingrediente.setNombre(this.nombre);
            ingrediente.setPrecio(this.precio);
            ingrediente.setCantidad(this.cantidad);
            ingrediente.setCaducidad(this.caducidad);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            throw e;
        }
    }
    public void log(){
        try{
            Pan user;
            user = new Pan();  
            listPan = user.setItems(); 
        }catch(Exception e){
            throw e;
        }
    }
}
