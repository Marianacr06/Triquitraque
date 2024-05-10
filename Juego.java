/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package triki;

import java.util.Map;

/**
 *
 * @author mac
 */
public class Juego {

    private Jugador[] jugadores;
    private Tablero tablero;

    public Juego() {
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void iniciarPartida(Jugador[] jugadores, Tablero tablero) {
        this.jugadores = jugadores;
        this.tablero = tablero;
    }

    public String manejarEntradaUsuario(int fila, int columna, int jugador) {
        if (!tablero.colocarFicha(fila, columna, jugador)) {
            return "¡No se puede mover ahí!";
        }

        if (tablero.verificarGanador(jugador)) {
            return "¡Gana " + jugadores[jugador - 1].obtenerNombre() + "!";
        }

        if (tablero.verificarEmpate()) {
            return "¡Es un empate!";
        }

        return cambiarTurno(jugador);
    }

    public String cambiarTurno(int jugador) {
        if (jugador == 1) {
            return "Cambio de turno al jugador " + jugadores[1].obtenerNombre();
        }

        return "Cambio de turno al jugador " + jugadores[0].obtenerNombre();
    }

    public String finalizarPartida() {
        if (tablero.verificarGanador(1)) {
            return "¡Gana " + jugadores[0].obtenerNombre() + "!";
        }

        if (tablero.verificarGanador(2)) {
            return "¡Gana " + jugadores[1].obtenerNombre() + "!";
        }

        return "¡Es un empate!";
    }

}
