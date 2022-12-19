package com.aetxabao.connect4;

import static com.aetxabao.connect4.Tablero.*;

/**
 * @author Rubén Gurrea
 */
public class Salida {

    private static void limpiaPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println();
    }

    public static void pintaInicio() {
        limpiaPantalla();
        System.out.println("###################################");
        System.out.println("#            CONECTA 4            #");
        System.out.println("###################################");
        System.out.println("                                   ");
        System.out.println("F  |   |   |   |   |   |   |   |  F");
        System.out.println("E  |   |   | O |   |   |   |   |  E");
        System.out.println("D  | X | O | X | O | X | O |   |  D");
        System.out.println("C  | X | X | X | O | O | X |   |  C");
        System.out.println("B  | X | O | O | X | X | O |   |  B");
        System.out.println("A  | O | X | X | O | O | O | X |  A");
        System.out.println("   -----------------------------   ");
        System.out.println("   | 1 | 2 | 3 | 4 | 5 | 6 | 7 |   ");
        System.out.println("                                   ");
        System.out.println("Pulsa ENTER para empezar.");
        System.out.println();
    }

    public static void pinta(char[][] matriz) {
        limpiaPantalla();//no borrar esta primera línea
        int h = matriz[0].length;
        int w = matriz.length;
        System.out.println("###################################");
        System.out.println("#            CONECTA 4            #");
        System.out.println("###################################");
        System.out.println("                                   ");
        char[] letras = {'A','B','C','D','E','F'};
        System.out.println(letras[5]+"  | "+matriz[0][5]+" | "+matriz[1][5]+" | "+matriz[2][5]+" | "+matriz[3][5]+" | "+matriz[4][5]+" | "+matriz[5][5]+" | "+matriz[6][5]+" |  "+letras[5]);
        System.out.println(letras[4]+"  | "+matriz[0][4]+" | "+matriz[1][4]+" | "+matriz[2][4]+" | "+matriz[3][4]+" | "+matriz[4][4]+" | "+matriz[5][4]+" | "+matriz[6][4]+" |  "+letras[4]);
        System.out.println(letras[3]+"  | "+matriz[0][3]+" | "+matriz[1][3]+" | "+matriz[2][3]+" | "+matriz[3][3]+" | "+matriz[4][3]+" | "+matriz[5][3]+" | "+matriz[6][3]+" |  "+letras[3]);
        System.out.println(letras[2]+"  | "+matriz[0][2]+" | "+matriz[1][2]+" | "+matriz[2][2]+" | "+matriz[3][2]+" | "+matriz[4][2]+" | "+matriz[5][2]+" | "+matriz[6][2]+" |  "+letras[2]);
        System.out.println(letras[1]+"  | "+matriz[0][1]+" | "+matriz[1][1]+" | "+matriz[2][1]+" | "+matriz[3][1]+" | "+matriz[4][1]+" | "+matriz[5][1]+" | "+matriz[6][1]+" |  "+letras[1]);
        System.out.println(letras[0]+"  | "+matriz[0][0]+" | "+matriz[1][0]+" | "+matriz[2][0]+" | "+matriz[3][0]+" | "+matriz[4][0]+" | "+matriz[5][0]+" | "+matriz[6][0]+" |  "+letras[0]);
        System.out.println("   -----------------------------   ");
        System.out.println("   | 1 | 2 | 3 | 4 | 5 | 6 | 7 |   ");
        System.out.println("                                   ");
    }

    public static void pintaGana(char[][] m, char jugador) {
        pinta(m);
        System.out.printf("Enhorabuena, ha ganado '%c'. FIN.\n", jugador);
    }

    public static void pintaEmpate(char[][] m) {
        pinta(m);
        System.out.println("Empate. No hay ganador. FIN.");
    }

    public static void main(String[] args) {
       char[][] m0 = {
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '}
         };
        pinta(m0);
        char[][] m1 = {
                {X, O, X, O, L, L},
                {X, O, L, L, L, L},
                {X, O, X, O, O, X},
                {O, X, O, O, X, X},
                {O, X, X, O, L, L},
                {O, O, L, L, L, L},
                {X, X, O, L, L, L}
        };
        pinta(m1);
    }

}
