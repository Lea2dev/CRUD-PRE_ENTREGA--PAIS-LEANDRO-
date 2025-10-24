package com.talentotech.inicio;

public class Categoria {

    private int id;
    private String nombre;

    private static int contador = 0;

    public Categoria(String nombre) {
        this.id = ++contador;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{id=" + id + ", nombre='" + nombre + "'}";
    }
}
