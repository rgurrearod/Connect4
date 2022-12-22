package com.aetxabao.connect4;

import java.util.Random;

/**
 * @author Rubén Gurrea
 */
public class Tablero {

    public final static char O = 'O';
    public final static char X = 'X';
    public final static char L = ' ';
    private final static int W = 7;
    private final static int H = 6;
    private int contador;
    private char turno;
    private final int ancho;
    private final int alto;
    private final char[][] m;

    public Tablero() {
        contador = 0;
        turno = O;
        ancho = W;
        alto = H;
        m = new char[ancho][alto];
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                m[i][j] = L;
            }
        }
    }

    public Tablero(char[][] m) {
        contador = 0;
        turno = getTurno();
        ancho = m.length;
        alto = m[0].length;
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                if (m[i][j] != L){
                    contador++;
                }
            }
        }
        this.m = m;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getContador() {
        return contador;
    }

    public char[][] getMatriz(){
        return m;
    }

    public char getTurno() {
        return turno;
    }

    public void iniciaTurno() {
        char[] chars = {X, O};
        Random rnd = new Random();
        int next = rnd.nextInt(2);
        turno = chars[next];
        System.out.printf("Comienza el jugador: %s", chars[next]);
    }

    public void cambiaTurno() {
        if (turno == O){
            turno = X;
        }else {
            turno = O;
        }
    }

    public boolean estaColumnaLibre(int columna) {
        if (m[columna] == null && columna > (W-1)){
            return true;
        }
        if (m[columna][5] == L){
            return true;
        }
       return false;
    }

    public void inserta(char ficha, int columna) {
        if (estaColumnaLibre(columna)){
            for (int j = 0; j < H; j++) {
                if (m[columna][j]== L) {
                    m[columna][j]=ficha;
                    contador++;
                    return;
                }
            }
        }else{
            System.out.println("Esta columna no tiene huecos libres");
        }
    }

    public boolean estaLleno() {
        return contador == alto*ancho;
    }

    public boolean gana(char jugador) {
        boolean b;
        b = ganaHorizontal(jugador);
        b = b || ganaVertical(jugador);
        b = b || ganaDiagonalArriba(jugador);
        b = b || ganaDiagonalAbajo(jugador);
        return b;
    }

    private boolean ganaHorizontal(char jugador) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < alto; j++) {
                if (hay4Horizontales(i,j,jugador)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hay4Horizontales(int columna, int fila, char jugador){
        return m[columna][fila]==jugador && m[columna+1][fila]==jugador  && m[columna+2][fila]==jugador  && m[columna+3][fila]==jugador;
    }

    private boolean ganaVertical(char jugador) {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < 3; j++) {
                if (hay4Verticales(i,j,jugador)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hay4Verticales(int columna, int fila, char jugador){
        return m[columna][fila]==jugador && m[columna][fila+1]==jugador  && m[columna][fila+2]==jugador  && m[columna][fila+3]==jugador;
    }

    private boolean ganaDiagonalArriba(char jugador) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (hay4DiagonalesArriba(i,j,jugador)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hay4DiagonalesArriba(int columna, int fila, char jugador){
        return m[columna][fila]==jugador && m[columna+1][fila+1]==jugador  && m[columna+2][fila+2]==jugador  && m[columna+3][fila+3]==jugador;
    }

    private boolean ganaDiagonalAbajo(char jugador) {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j < alto; j++) {
                if (hay4DiagonalesAbajo(i, j, jugador)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hay4DiagonalesAbajo(int columna, int fila, char jugador) {
        return m[columna][fila] == jugador && m[columna + 1][fila - 1] == jugador && m[columna + 2][fila - 2] == jugador && m[columna + 3][fila - 3] == jugador;
    }


    public boolean estaFinalizado() {
        if (gana(turno)||estaLleno()){
            return true;
        }
        return false;
    }
}
