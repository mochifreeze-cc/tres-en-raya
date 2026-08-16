package com.espol.proyectoestruturadatos.model.board;

import java.util.Objects;

/**
 * Modelo para representar el símbolo (X u O) de las casillas en el tablero.
 * 
 * @author Gabriel
 * @author Dylan Jeanpier Pincay Salazar
 * @author Helen Cruz
 */
public class Symbol {
    private Character character;
    private String color;

    public static final Symbol X = new Symbol('X', "#1E88E5");
    public static final Symbol O = new Symbol('O', "#E53935");

    public Symbol(Character character) {
        this.character = character;
        if (character != null && character == 'X') {
            this.color = "#1E88E5"; // Azul
        } else if (character != null && character == 'O') {
            this.color = "#E53935"; // Rojo
        } else {
            this.color = "#000000";
        }
    }

    public Symbol(Character character, String color) {
        this.character = character;
        this.color = color;
    }

    public Character getCharacter() {
        return character;
    }

    public String getColor() {
        return color;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Symbol opponent() {
        if (character == null) return null;
        if (character == 'X') return O;
        if (character == 'O') return X;
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Symbol other = (Symbol) obj;
        return Objects.equals(this.character, other.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }

    @Override
    public String toString() {
        return character != null ? character + "" : "";
    }
}
