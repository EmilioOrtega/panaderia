/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Iterator;
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
@Table (name ="cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id_cliente = :id_cliente")
    , @NamedQuery(name = "Cliente.findByContra", query = "SELECT c FROM Cliente c WHERE c.contra = :contra")
    , @NamedQuery(name = "Cliente.login", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre and c.contra = :contra")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")})
public class Cliente {
    
    @Id
    @Column(name = "id_cliente")
    int id_cliente;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "apellido_p")
    String apellido_p;
    @Column(name = "apellido_m")
    String apellido_m;
    @Column(name = "contra")
    String contra;
    @Column(name = "correo")
    String correo;
    @Column(name = "telefono")
    String telefono;
    
    public Cliente(){}

    public Cliente(String nombre, String apellido_p, String apellido_m, String contra, String correo, String telefono) {
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.contra = contra;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public Cliente(String nombre, String apellido_p){
        this.nombre = nombre;
        this.contra = contra;
    }
    
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public List<Cliente> login(String name){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panaderiaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction entr = em.getTransaction();
        entr.begin();
        Query query = em.createNamedQuery("Cliente.findByNombre");
        query.setParameter("nombre", name);
        List<Cliente> datos = (List<Cliente>) query.getResultList();
        return datos;
    }
    
    public boolean encontrar(String name, String password){
        try{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panaderiaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction entr = em.getTransaction();
        entr.begin();
        Query query = em.createNamedQuery("Cliente.login").setParameter("nombre", name).setParameter("contra", password);        
        List<Cliente> datos = (List<Cliente>) query.getResultList();
        if(!datos.isEmpty()){
            return true;
        }
        return false;
        }catch(Exception e){
            return false;
        }
    }
    
}
