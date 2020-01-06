/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Emilio
 */
@Entity
@Table (name = "departamento")
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
}
