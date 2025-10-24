package com.talentotech.inicio;

public abstract class Producto implements Vendible {

    private int id;
    private String descripcion;
    private double precio;
    
    private static int contador = 0;

    public abstract double aplicarDescuento();

    public Producto(String descripcion, double precio) {
        this.id = ++contador; 
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {   
        return id;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto [descripcion=" + descripcion + ", precio=" + precio + "]";
    }


  
    
}
