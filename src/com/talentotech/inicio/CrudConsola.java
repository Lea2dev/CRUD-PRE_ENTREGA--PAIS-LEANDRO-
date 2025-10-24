package com.talentotech.inicio;

import java.util.Scanner;

public abstract class CrudConsola<T> {

    protected final Scanner scanner = new Scanner(System.in); 

    public abstract void crear();
    public abstract void listar();
    public abstract void actualizar();
    public abstract void eliminar();

    public void mostrarOpciones(String tipo) {
        Util.centrar("Menu CRUD "+tipo,'=');
        Util.centrar("1.--- Crear");
        Util.centrar("2.--- Listar");
        Util.centrar("3.--- Actualizar");
        Util.centrar("4.--- Eliminar");
        Util.centrar("0.--- Volver/Salir");
        System.out.print("Ingrese selección: ");
    }
 
    protected int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String linea = scanner.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ser un número entero.");
            }
        }
    }

    protected double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String linea = scanner.nextLine();
                return Double.parseDouble(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ser un número (usar punto para el decimal).");
            }
        }
    }

    protected String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}
