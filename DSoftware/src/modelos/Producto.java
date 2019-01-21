/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import controladores.SistemaPoliVentas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author IYAC
 */
public class Producto {

    private String nombre;
    private Categoria categoria;
    private double precio;
    private String TiempoMaxEntrega;
    private Calificacion calificacion;
    private Vendedor vendedor;

    public Producto(){}
    
    public Producto(String nombre, Categoria categoria, double precio, String TiempoMaxEntrega, Calificacion calificacion, Vendedor vendedor) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.TiempoMaxEntrega = TiempoMaxEntrega;
        this.calificacion = calificacion;
        this.vendedor = vendedor;
    }

    public boolean equals(Producto producto) {
        boolean nombreIgual = producto.getNombre().equals(this.nombre);
        boolean precioIgual = (producto.getPrecio()==(this.precio));

        return nombreIgual && precioIgual;

    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTiempoMaxEntrega(String TiempoMaxEntrega) {
        this.TiempoMaxEntrega = TiempoMaxEntrega;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    
    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTiempoMaxEntrega() {
        return TiempoMaxEntrega;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public int getId(){
        int i=0;
        String query = "Select idproducto from producto where nombre="+this.nombre;
        ResultSet rs;
        try (Connection conn = ConexionSQL.getConnection();
                CallableStatement stmt = conn.prepareCall(query)) {
            //Set IN parameter
            i=stmt.getInt("idproducto");
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    return i;
    }
}
