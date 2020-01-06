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
@Table (name = "proveedor")
public class Proveedor {
    @Id
    @Column
    private int id_proveedor;
    @Column
    private String nombre;
    @Column
    private String telefono;
    @Column
    private String domicilio;

    public Proveedor() {
    }

    public Proveedor(String nombre, String telefono, String domicilio) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
