package com.talentotech.inicio;

import java.util.ArrayList;

public class CrudUsuarios extends CrudConsola<Usuario> {

    private final ArrayList<Usuario> usuarios;

    public CrudUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public void crear() {
        String nombre = leerTexto("Nombre del nuevo usuario: ");
        String pass = leerTexto("Contraseña: ");
        usuarios.add(new Usuario(nombre, pass));
        System.out.println("Usuario creado.");
    }

    @Override
    public void listar() {
        if (usuarios.isEmpty()) {
            System.out.println("(sin usuarios)");
        } else {
            for (Usuario c : usuarios) {
                System.out.println(c);
            }
        }
    }

    @Override
    public void actualizar() {
        int id = leerEntero("Id del usuario: ");
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                String nuevoNombre = leerTexto("Nuevo nombre: ");
                u.setUserName(nuevoNombre);
                String nuevoPass = leerTexto("Nuevo nombre: ");
                u.setPass(nuevoPass);
                System.out.println("Actualizada: " + u);
                return;
            }
        }
        System.out.println("No se encontró usuario con id " + id);
    }

    @Override
    public void eliminar() {
        int id = leerEntero("Id de la usuario a eliminar: ");
        boolean eliminado = usuarios.removeIf(c -> c.getId() == id);
        System.out.println(eliminado);
    }
}
