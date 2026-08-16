package com.espol.proyectoestruturadatos.model.player;

import com.espol.proyectoestruturadatos.model.board.Board;
import com.espol.proyectoestruturadatos.model.board.Symbol;

/**
 * Representa al Jugador Humano.
 * 
 * @author Gabriel
 */
public class Human extends Player {

    public Human() {
        super();
    }

    public Human(Symbol symbol) {
        super(symbol);
    }

    public boolean playTurn(Board board, int index) {
        if (board != null && index >= 0 && index < 9) {
            board.setSymbol(this.symbol, index);
            return true;
        }
        return false;
    }
}