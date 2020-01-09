/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Table;

/**
 *
 * @author Emilio
 */
@Entity
@Table (name = "factura")
public class Factura {
    @Id
    @Column
    private int id_factura;
    @Column
    private String fecha;
    @Column
    private String Total;
    @Column
    private int id_cliente;
    @Column
    private int id_pan;

    public Factura() {
    }

    public Factura(String fecha, String Total, int id_cliente, int id_pan) {
        this.fecha = fecha;
        this.Total = Total;
        this.id_cliente = id_cliente;
        this.id_pan = id_pan;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_pan() {
        return id_pan;
    }

    public void setId_pan(int id_pan) {
        this.id_pan = id_pan;
    }
    
}
