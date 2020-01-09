/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Pan;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Emilio
 */
@ManagedBean(name = "panDulce")
@RequestScoped
public class PanDulce {
    public int id_pan;
    public String nombre;
    public String precio;
    public String cantidad;
    public String caducidad;
    public int id_departamento;
    
    public List<Pan> listPan;
    public PanDulce() {
        setPanDulce();
    }

    public PanDulce(String nombre, String precio, String cantidad, String caducidad, int id_departamento) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.caducidad = caducidad;
        this.id_departamento = id_departamento;
    }
    public List<Pan> getListPan() {
        return listPan;
    }

    public void setListPan(List<Pan> listPan) {
        this.listPan = listPan;
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
    public void setPanDulce(){
        try{
            Pan pan;
            pan = new Pan();  
            listPan = pan.setPan(2);
        }catch(Exception e){
            throw e;
        }
    }
}
