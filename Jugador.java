/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package triki;

/**
 *
 * @author mac
 */
public class Jugador {

    private String nombre;
    private String color;
    private String ficha;

    public Jugador(String nombre, String color, String ficha) {
        this.nombre = nombre;
        this.color = color;
        this.ficha = ficha;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public String getFicha() {
        return ficha;
    }

}
