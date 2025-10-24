package com.talentotech.inicio;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        
        //creo el array de usuarios con un usuario admin
        final ArrayList<Usuario> usuarios = new ArrayList<>();
        Util.centrar("Credenciales admin",'=');
        Util.centrar("Usuario: Leandro",'-');
        Util.centrar("Contraseña: abc123",'-');
        usuarios.add(new Usuario("leandro", "abc123")); // datos de la "base de datos"
        Usuario usrActivo = new Usuario(); // creo usuario interactivo
        boolean logueado=false;
        while (!logueado) {
            usrActivo.setUserName(Util.leerTexto("Ingrese usuario:"));
            usrActivo.setPass(Util.leerTexto("Ingrese contraseña:"));
            if(Util.login(usuarios,usrActivo)){
                Util.centrar("Bienvenido usuario: " + usrActivo.getUserName());
                logueado=true;
            }
        }

        // creo listas de productos (ya sea servicios o articulos) y categorias
        final ArrayList<Producto> productos = new ArrayList<>();
        final ArrayList<Categoria> categorias = new ArrayList<>();
        

        //preparo categorias default
        categorias.add(new Categoria("Tecnología"));
        categorias.add(new Categoria("Limpieza"));
        categorias.add(new Categoria("Blancos"));
        categorias.add(new Categoria("Deportes"));

        final CrudProductos crudProd = new CrudProductos(productos, categorias);
        final CrudCategorias crudCat = new CrudCategorias(categorias);
        final CrudUsuarios crudUsr = new CrudUsuarios(usuarios);

        int opcion;
        do {
            Util.separador('=');
            Util.centrar("MENU PRINCIPAL",'-');
            Util.separador('=');
            Util.centrar("1) CRUD de Productos");
            Util.centrar("2) CRUD de Categorías");
            Util.centrar("3) CRUD de Usuarios");
            Util.centrar("0) Salir");
            String linea = Util.leerTexto("Opción: ");       
            try {
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> {
                    int op;
                    do {
                        crudProd.mostrarOpciones("PRODUCTOS");
                        op = crudProd.leerEntero("");
                        switch (op) {
                            case 1 -> crudProd.crear();
                            case 2 -> crudProd.listar();
                            case 3 -> crudProd.actualizar();
                            case 4 -> crudProd.eliminar();
                            case 0 -> Util.centrar("Volviendo al menú principal...");
                            default -> Util.centrar("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 2 -> {
                    int op;
                    do {
                        crudCat.mostrarOpciones("CATEGORIAS");
                        op = crudCat.leerEntero("");
                        switch (op) {
                            case 1 -> crudCat.crear();
                            case 2 -> crudCat.listar();
                            case 3 -> crudCat.actualizar();
                            case 4 -> crudCat.eliminar();
                            case 0 -> Util.centrar("Volviendo al menú principal...");
                            default -> Util.centrar("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 3 -> {
                    int op;
                    do {
                        crudUsr.mostrarOpciones("USUARIOS");
                        op = crudUsr.leerEntero("");
                        switch (op) {
                            case 1 -> crudUsr.crear();
                            case 2 -> crudUsr.listar();
                            case 3 -> crudUsr.actualizar();
                            case 4 -> crudUsr.eliminar();
                            case 0 -> Util.centrar("Volviendo al menú principal...");
                            default -> Util.centrar("Opción inválida");
                        }
                    } while (op != 0);
                }
                case 0 -> Util.centrar("¡Hasta luego!");
                default -> Util.centrar("Opción inválida");
            }

        } while (opcion != 0);
    }


}
