/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package triki;

import static java.lang.Math.min;
import static java.lang.Math.max;

/**
 *
 * @author mac
 */
public class Tablero {

    private int[][] tablero;

    public Tablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public boolean colocarFicha(int fila, int columna, int jugador) {
        if (tablero[fila][columna] != 0) {
            return false;
        }

        tablero[fila][columna] = jugador;

        return true;
    }

    public boolean verificarGanador(int jugador) {
        int contadorEnFilas = 0;
        int contadorEnColumnas = 0;
        for (int i = 0; i < tablero.length && contadorEnFilas < 3 && contadorEnColumnas < 3; i++) {
            for (int j = 0; j < tablero.length && contadorEnFilas < 3 && contadorEnColumnas < 3; j++) {
                if (tablero[i][j] == jugador) {
                    contadorEnFilas++;
                    if (contadorEnFilas > 2) {
                        return true;
                    }
                } else {
                    contadorEnFilas = 0;
                }

                if (tablero[j][i] == jugador) {
                    contadorEnColumnas++;
                    if (contadorEnColumnas > 2) {
                        return true;
                    }
                } else {
                    contadorEnColumnas = 0;
                }
            }
            contadorEnFilas = 0;
            contadorEnColumnas = 0;
        }

        int contadorEnDiagonalCaidaDerecha = 0;
        for (int i = 1 - tablero.length; i < tablero.length && contadorEnDiagonalCaidaDerecha < 3; i++) {
            for (int x = -min(0, i), y = max(0, i); x < tablero.length && y < tablero.length && contadorEnDiagonalCaidaDerecha < 3; x++, y++) {
                if (tablero[y][x] == jugador) {
                    contadorEnDiagonalCaidaDerecha++;
                    if (contadorEnDiagonalCaidaDerecha > 2) {
                        return true;
                    }
                } else {
                    contadorEnDiagonalCaidaDerecha = 0;
                }
            }
            contadorEnDiagonalCaidaDerecha = 0;
        }

        int contadorEnDiagonalCaidaIzquierda = 0;
        for (int i = 1 - tablero.length; i < tablero.length && contadorEnDiagonalCaidaIzquierda < 3; i++) {
            for (int x = -min(0, i), y = max(0, i); x < tablero.length && y < tablero.length && contadorEnDiagonalCaidaIzquierda < 3; x++, y++) {
                if (tablero[y][x] == jugador) {
                    contadorEnDiagonalCaidaIzquierda++;
                    if (contadorEnDiagonalCaidaIzquierda > 2) {
                        return true;
                    }
                } else {
                    contadorEnDiagonalCaidaIzquierda = 0;
                }
            }
            contadorEnDiagonalCaidaIzquierda = 0;
        }

        for (int r = 0; r < tablero.length; r++) {
            for (int i = r, j = 0; j < tablero.length && i >= 0; i--, j++) {
                if (tablero[i][j] == jugador) {
                    contadorEnDiagonalCaidaIzquierda++;
                    if (contadorEnDiagonalCaidaIzquierda > 2) {
                        return true;
                    }
                } else {
                    contadorEnDiagonalCaidaIzquierda = 0;
                }
            }
            contadorEnDiagonalCaidaIzquierda = 0;
        }

        for (int c = 1; c < tablero.length; c++) {
            for (int i = tablero.length - 1, j = c; j < tablero.length && i >= 0; i--, j++) {
                if (tablero[i][j] == jugador) {
                    contadorEnDiagonalCaidaIzquierda++;
                    if (contadorEnDiagonalCaidaIzquierda > 2) {
                        return true;
                    }
                } else {
                    contadorEnDiagonalCaidaIzquierda = 0;
                }
            }
            contadorEnDiagonalCaidaIzquierda = 0;
        }

        return false;
    }

    public boolean verificarEmpate() {
        int cantidadPosicionesLibres = 0;
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero.length; columna++) {
                if (tablero[fila][columna] == 0) {
                    cantidadPosicionesLibres++;
                }
            }
        }

        return !verificarGanador(1) && !verificarGanador(2) && cantidadPosicionesLibres == 0;
    }

    public int[][] mostrarTablero() {
        return tablero;
    }

}
