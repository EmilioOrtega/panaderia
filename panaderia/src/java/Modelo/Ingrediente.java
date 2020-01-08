/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 *
 * @author Emilio
 */

@Entity
@Table (name = "ingrediente")
@NamedQueries({
    @NamedQuery(name = "Ingrediente.findAll", query = "SELECT i FROM Ingrediente i")
    , @NamedQuery(name = "Ingrediente.findById", query = "SELECT i FROM Ingrediente i WHERE i.id_ingrediente = :id_ingrediente")
    , @NamedQuery(name = "Ingrediente.findByNombre", query = "SELECT i FROM Ingrediente i WHERE i.nombre = :nombre")})
public class Ingrediente {
    @Id
    @Column
    public int id_ingrediente;
    @Column
    public String nombre;
    @Column 
    public String cantidad;

    public Ingrediente() {
    }

    public Ingrediente(String nombre, String cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getId_ingrediente() {
        return id_ingrediente;
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
    public List<Ingrediente> setItems(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panaderiaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction entr = em.getTransaction();
        entr.begin();
        Query query = em.createNamedQuery("Ingrediente.findAll");
        List<Ingrediente> datos = (List<Ingrediente>) query.getResultList();
        em.close();
        return datos;    
    }
    
    public List<Ingrediente> setItems(String name){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panaderiaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction entr = em.getTransaction();
        entr.begin();
        Query query = em.createNamedQuery("Ingrediente.findByNombre");
        query.setParameter("nombre", name);
        List<Ingrediente> datos = (List<Ingrediente>) query.getResultList();
        em.close();
        return datos;    
    }
}
