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
@ManagedBean (name = "facturaBean")
@RequestScoped
public class FacturaBean {
    private int id_factura;
    private  String cantidad;
    private String fecha;
    private String subTotal;
    private String Total;
    private int id_cliente;
    private int id_pan;

    public FacturaBean() {
    }

    public FacturaBean(String cantidad, String fecha, String subTotal, String Total, int id_cliente, int id_pan) {
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.subTotal = subTotal;
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
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
