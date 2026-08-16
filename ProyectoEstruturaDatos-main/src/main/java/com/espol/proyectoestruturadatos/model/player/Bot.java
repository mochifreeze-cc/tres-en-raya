package com.espol.proyectoestruturadatos.model.player;

import com.espol.proyectoestruturadatos.dstructure.Minimax;
import com.espol.proyectoestruturadatos.model.board.Board;
import com.espol.proyectoestruturadatos.model.board.Symbol;

/**
 * Representa al Jugador Computadora (Bot) en el juego Tres en Raya.
 * Utiliza el algoritmo Minimax para calcular su mejor movimiento.
 * 
 * @author Gabriel
 */
public class Bot extends Player {

    public Bot() {
        super();
    }

    public Bot(Symbol symbol) {
        super(symbol);
    }
    public int playTurn(Board board, Symbol humanSymbol) {
        int move = Minimax.getBestMove(board, this.symbol, humanSymbol);
        if (move != -1) {
            board.setSymbol(this.symbol, move);
        }
        return move;
    }
}