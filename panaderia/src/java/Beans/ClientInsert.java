/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Modelo.Cliente;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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
    public String pu;

    public String getPu() {
        return pu;
    }

    public void setPu(String pu) {
        this.pu = pu;
    }
    
    public List<Cliente> listClientes;

    public List<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<Cliente> listClientes) {
        this.listClientes = listClientes;
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
    
    public void insertar(){       
        Cliente usuario = new Cliente(this.nombre, this.apellido_p, this.apellido_m, this.contra, this.correo, this.telefono);
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("panaderiaPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();       
    }
    
    public void log(){
        try{
            Cliente user;
            user = new Cliente();  
            listClientes = user.login(this.nombre);
        }catch(Exception e){
            throw e;
        }        
    }
         
}
