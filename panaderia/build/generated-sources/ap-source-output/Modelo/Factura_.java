package Modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-08T14:13:31")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Integer> id_factura;
    public static volatile SingularAttribute<Factura, String> fecha;
    public static volatile SingularAttribute<Factura, Integer> id_cliente;
    public static volatile SingularAttribute<Factura, Integer> id_pan;
    public static volatile SingularAttribute<Factura, String> Total;
    public static volatile SingularAttribute<Factura, String> cantidad;
    public static volatile SingularAttribute<Factura, String> subTotal;

}