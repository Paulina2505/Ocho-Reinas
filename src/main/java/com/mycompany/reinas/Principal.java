/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reinas;

import javax.swing.JOptionPane;

/**
 *
 * @author Paulina
 */
public class Principal {

    private static int tableroNum = 0;

    public static void main(String[] args) {
        String[][] tablero = new String[8][8];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = " ";
            }
        }
        ponerReina(tablero, 0);
    }

    public static void ponerReina(String[][] tablero, int numero) {
        for (int i = 0; i < tablero.length; i++) {
            if (libre(tablero, i, numero)) {
                tablero[i][numero] = "R";

                if (numero < tablero.length - 1) {
                    ponerReina(tablero, numero + 1);
                } else {
                    tableroNum++;
                    System.out.println("\n\n________________________");
                    System.out.println("       TABLERO " + tableroNum);
                    System.out.println("________________________");
                    for (int m = 0; m < tablero.length; m++) {
                        for (int n = 0; n < tablero.length; n++) {
                            System.out.print(tablero[m][n] + "| ");
                        }
                        System.out.println();
                    }
                    System.out.println("________________________");
                    System.out.println("________________________");
                }

                tablero[i][numero] = " ";
            }

        }
    }

    public static boolean libre(String[][] tablero, int i, int numero) {
        for (int x = 0; x < numero; x++) {
            if (tablero[i][x].equals("R")) {
                return false;
            }
        }
        for (int j = 0; j < tablero.length && (i - j) >= 0 && (numero - j) >= 0; j++) {
            if (tablero[i - j][numero - j].equals("R")) {
                return false;
            }
        }
        for (int j = 0; j < tablero.length && (i + j) < tablero.length && numero - j >= 0; j++) {
            if (tablero[i + j][numero - j].equals("R")) {
                return false;
            }
        }
        return true;
    }
}
