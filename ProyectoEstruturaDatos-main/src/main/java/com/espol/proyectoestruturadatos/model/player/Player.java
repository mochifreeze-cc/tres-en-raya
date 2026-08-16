package com.espol.proyectoestruturadatos.model.player;

import com.espol.proyectoestruturadatos.model.board.Symbol;

/**
 * Clase base abstracta para los jugadores del juego.
 * 
 * @author Gabriel
 * @author Helen Cruz
 */
public abstract class Player {

    protected Symbol symbol;
    protected int wins;

    public Player() {
        this.wins = 0;
    }

    public Player(Symbol symbol) {
        this.symbol = symbol;
        this.wins = 0;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void addWin() {
        wins++;
    }

    public String getColor() {
        return symbol != null ? symbol.getColor() : "#000000";
    }

    public void setColor(String color) {
        if (symbol != null) {
            symbol.setColor(color);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + symbol + ")";
    }
}
