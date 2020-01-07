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
@Table (name = "departamento")
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Departamento.findByNombre", query = "SELECT d FROM Departamento d WHERE d.nombre = :nombre")})
public class Departamento {
    @Id
    @Column
    private int id_departamento;
    @Column
    private String nombre;

    public Departamento() {
    }
    
    public Departamento(int id_departamento, String nombre) {
        this.id_departamento = id_departamento;
        this.nombre = nombre;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public String getNombre() {
        return nombre;
    }
    public List<Departamento> getItems(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("panaderiaPU");
        EntityManager em = emf.createEntityManager();
        Query consulta = em.createNamedQuery("Departamento.findAll");
        List<Departamento> datos = (List<Departamento>) consulta.getResultList();
        for(Departamento a : datos){
            System.out.println(a.getNombre());
        }

        return datos;
    }
}
