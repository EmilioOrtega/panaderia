/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Emilio
 */
@ManagedBean (name="client")
@RequestScoped
public class ClientInsert {
    
    String nombre;
    String apellido_p;
    String apellido_m;
    String contra;
    String correo;
    String telefono;
    
    public void in(){
        System.out.println("Holaaaaa");
    }
    public void insertar(){
        System.out.println("Holaaaaa");
        Cliente usuario = new Cliente("a", "a", "a", "a", "a", "a");
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("panaderiaPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        
        //return "register";
    }
}
