/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
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
    
    public String nombre;
    public String apellido_p;
    public String apellido_m;
    public String contra;
    public String correo;
    public String telefono;
    
    
    public void insertar(){
        Cliente cliente = new Cliente();
        cliente.insertUser();
        /*
        Cliente usuario = new Cliente(this.nombre, this.apellido_p, this.apellido_m, this.contra, this.correo, this.telefono);
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("panaderiaPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();     */   
    }
}
