package com.talentotech.inicio;

import java.util.Scanner;
import java.util.ArrayList;

public class Util {
    
    protected final static Scanner sc = new Scanner(System.in);

    protected static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    public static boolean login(ArrayList<Usuario> usuarios, Usuario usrActivo) {
        for (Usuario u : usuarios) {
            if (u.getUserName().equals(usrActivo.getUserName())) {
                if(u.getPass().equals(usrActivo.getPass()))
                    return true;
                else
                    break;
            }
        }
        return false;
        
    }

    public static void centrar(String texto){
        int largo = texto.length();
        short espacio = (short) ((80-largo)/2);
        for (int i=0; i<espacio; i++)
            System.out.print(" ");
        System.out.println(texto);
    }
    
    public static void centrar(String texto, char decorador){
        int largo = texto.length();
        short espacio = (short) ((80-largo)/2);
        for (int i=1; i<espacio; i++)
            System.out.print(decorador);
        System.out.print(" ");
        System.out.print(texto);
        System.out.print(" ");
        for (int i=1; i<espacio; i++)            
            System.out.print(decorador);
        System.out.println();
    }

    public static void separador(char c) {
        for (int i=0; i<80; i++)
            System.out.print(c);
        System.out.println();
    }

}
