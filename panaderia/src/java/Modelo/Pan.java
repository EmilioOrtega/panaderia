/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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
@Table (name = "pan")
@NamedQueries({
    @NamedQuery(name = "Pan.findAll", query = "SELECT p FROM Pan p")
    , @NamedQuery(name = "Pan.findByNombre", query = "SELECT p FROM Pan p WHERE p.nombre = :nombre")})
public class Pan {
    @Id
    @Column
    private int id_pan;
    @Column
    private String nombre;
    @Column
    private String precio;
    @Column
    private String cantidad;
    @Column
    private String caducidad;
    @Column
    private int id_departamento;

    public Pan() {
    }

    public Pan(String nombre, String precio, String cantidad, String caducidad, int id_departamento) {
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
    
    public List<Pan> setItems(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panaderiaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction entr = em.getTransaction();
        entr.begin();
        Query query = em.createNamedQuery("Pan.findAll");
        List<Pan> datos = (List<Pan>) query.getResultList();
        return datos;    
    }
    
}
