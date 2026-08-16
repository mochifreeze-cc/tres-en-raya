package com.espol.proyectoestruturadatos.model.board;

/**
 * Representa una casilla individual dentro del tablero 3x3.
 * 
 * @author Gabriel
 * @author Dylan Jeanpier Pincay Salazar
 * @author Helen Cruz
 */
public class Box {
    private Symbol symbol;

    public Box() {
        this.symbol = null;
    }

    public Box(Box box) {
        this.symbol = (box != null && box.symbol != null) ? new Symbol(box.symbol.getCharacter(),box.symbol.getColor()) : null;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public boolean isEmpty() {
        return this.symbol == null;
    }

    @Override
    public String toString() {
        return symbol != null ? symbol.toString() : " ";
    }
}
