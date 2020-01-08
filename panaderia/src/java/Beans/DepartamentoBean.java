/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Departamento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Emilio
 */
@ManagedBean (name = "departamentoBean")
@RequestScoped
@ViewScoped
public class DepartamentoBean {
    public int id_departamento;
    public String nombre;
    public List<Departamento> listDepartamento;
    
    public DepartamentoBean(){
        showDepartments();
    }
    
    public DepartamentoBean(int id_departamento, String nombre) {
        this.id_departamento = id_departamento;
        this.nombre = nombre;
    }
    public List<Departamento> getListDepartamento() {
        return listDepartamento;
    }

    public void setListDepartamento(List<Departamento> listDepartamento) {
        this.listDepartamento = listDepartamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public String getNombre() {
        return nombre;
    } 
    
    public void showDepartments(){
        Departamento department;
        department = new Departamento();  
        listDepartamento = department.getItems();            
    }
}
