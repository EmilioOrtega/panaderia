/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;

/**
 *
 * @author Emilio
 */

@ManagedBean
@Entity 
@Table (name ="cliente")
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
    
    public void insertUser() {
        ClientInsert login = new ClientInsert();
        login.nombre = this.nombre;
        login.apellido_p = this.apellido_p;
        login.apellido_m = this.apellido_m;
        login.contra = this.contra;
        login.correo = this.correo;
        login.telefono = this.telefono;
        Cliente usuario = new Cliente(this.nombre, this.apellido_p, this.apellido_m, this.contra, this.correo, this.telefono);
        //Cliente usuario = new Cliente(this.nombre, this.apellido_p, this.apellido_m, "a", "a", "a");
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("panaderiaPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }
    
    
    
    
}
