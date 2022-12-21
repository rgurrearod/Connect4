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
        turno = X;
        ancho = W;
        alto = H;
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
        if (turno == X){
            turno = O;
        }else {
            turno = X;
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
        //TODO: insertar
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
        //TODO: ganaHorizontal
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < H; j++) {
                hay4Horizontales(i,j,jugador);
            }
        }
        return false;
    }

    private boolean hay4Horizontales(int columna, int fila, char jugador){
            for (int i = 0; i < (columna+4); i++) {
                m[i][fila]=jugador;
            }
            return true;
    }

    private boolean ganaVertical(char jugador) {
        //TODO: ganaVertical
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < 3; j++) {
                hay4Verticales(i,j,jugador);
            }
        }
        return false;
    }

    private boolean hay4Verticales(int columna, int fila, char jugador){
        if (fila <=3){
            for (int j = 0; j < (fila+4); j++) {
                m[columna][j]=jugador;
            }
            return true;
        }
        return false;
    }

    private boolean ganaDiagonalArriba(char jugador) {
        //TODO: ganaDiagonalArriba
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                hay4DiagonalesArriba(i,j,jugador);
            }
        }
        return false;
    }

    private boolean hay4DiagonalesArriba(int columna, int fila, char jugador){
        if (columna <= 4 && fila <= 3){
            for (int i = 0; i < columna+4; i++) {
                for (int j = 0; j < fila+4; j++) {
                    m[i][j]=jugador;
                }
            }
            return true;
        }
        return false;
    }

    private boolean ganaDiagonalAbajo(char jugador) {
        //TODO: ganaDiagonalAbajo
        for (int i = 0; i < 4; i++) {
            for (int j = 4; j < H; j++) {
                hay4DiagonalesAbajo(i,j,jugador);
            }
        }
        return false;
    }

    private boolean hay4DiagonalesAbajo(int columna, int fila, char jugador){
        if (columna <= 4 && fila >= 4){
            for (int i = 0; i < columna+4; i++) {
                for (int j = 0; j < fila-4; j++) {
                    m[i][j]=jugador;
                }
            }
            return true;
        }
        return false;
    }

    public boolean estaFinalizado() {
        if (estaLleno()||gana(turno)){
            return true;
        }
        return false;
    }
}
