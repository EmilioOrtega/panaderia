/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Emilio
 */
@ManagedBean (name = "panBean")
@RequestScoped
public class PanBean {
    
    public int id_pan;
    public String nombre;
    public String precio;
    public String cantidad;
    public String caducidad;
    public int id_ingrediente;
    public int id_departamento;

    public PanBean() {
    }

    public PanBean(String nombre, String precio, String cantidad, String caducidad, int id_ingrediente, int id_departamento) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.caducidad = caducidad;
        this.id_ingrediente = id_ingrediente;
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

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }
    
}
