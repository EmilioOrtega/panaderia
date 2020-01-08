/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import Modelo.Ingrediente;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Emilio
 */
@ManagedBean (name = "ingredienteBean")
@RequestScoped 
public class IngredienteBean {
    public int id_ingrediente;
    public String nombre;
    public String cantidad;
    
    public List<Ingrediente> listIngredientes;
    
    public IngredienteBean() {
        log();
    }

    public IngredienteBean(String nombre, String cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public List<Ingrediente> getListIngredientes() {
        return listIngredientes;
    }

    public void setListIngredientes(List<Ingrediente> listIngredientes) {
        this.listIngredientes = listIngredientes;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    public void insertar(){       
        Ingrediente ingrediente = new Ingrediente(this.nombre, this.cantidad);
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("panaderiaPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(ingrediente);
        em.getTransaction().commit();       
    }
    public void eliminar(){
        try{          
            EntityManagerFactory emf;
            emf = Persistence.createEntityManagerFactory("panaderiaPU");
            EntityManager em = emf.createEntityManager();
            em.getEntityManagerFactory();
            Ingrediente ingrediente = em.find(Ingrediente.class, this.id_ingrediente);
            em.getTransaction().begin();
            em.remove(ingrediente);   
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
            Ingrediente ingrediente = em.find(Ingrediente.class, this.id_ingrediente);            
            em.getTransaction().begin();
            ingrediente.setNombre(this.nombre);
            ingrediente.setCantidad(this.cantidad);
            em.getTransaction().commit();
            
        }catch(Exception e){
            throw e;
        }
    }
    public void log(){
        Ingrediente user;
        user = new Ingrediente();  
        listIngredientes = user.setItems();
        for (Ingrediente a : listIngredientes) {
        }    
    }
}
