package com.porfirio.fraccionando.dominio.enumerados;

import java.awt.Color;

/**
 * Este enumerado contiene los colores de los temas visuales de la aplicacion,
 * asociandoles ademas dos instancias de Color, una para el fondo claro, y otra
 * para el fondo oscuro del tema correspondiente.
 *
 * @author Porfirio Angel Diaz Sanchez <porfirioads@gmail.com>
 */
public enum ColorTema {

    AZUL(new Color(hexToInt("088BD2")), new Color(hexToInt("8AC4E3"))),
    AMARILLO(new Color(hexToInt("FF8B00")), new Color(hexToInt("FFCF95"))),
    ROSA(new Color(hexToInt("DE00AD")), new Color(hexToInt("EA89D5"))),
    ROJO(new Color(hexToInt("F70030")), new Color(hexToInt("FA92A6"))),
    MORADO(new Color(hexToInt("810AD7")), new Color(hexToInt("C08CE6")));

    private Color claro;
    private Color oscuro;

    private ColorTema(Color oscuro, Color claro) {
        this.claro = claro;
        this.oscuro = oscuro;
    }

    private static int hexToInt(String hex) {
        return Integer.parseInt(hex, 16);
    }

    public Color getClaro() {
        return claro;
    }

    public Color getOscuro() {
        return oscuro;
    }
}
