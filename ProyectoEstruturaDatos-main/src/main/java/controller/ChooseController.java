package controller;

import com.espol.proyectoestruturadatos.model.board.Symbol;

/**
 * Controlador para gestionar la configuración previa de la partida:
 * selección de símbolos (X u O) y elección de turno inicial (Humano o Computadora).
 * 
 * @author Gabriel
 */
public class ChooseController {

    private Symbol humanSymbol;
    private Symbol botSymbol;
    private boolean humanStarts;

    public ChooseController() {
        this.humanSymbol = Symbol.X;
        this.botSymbol = Symbol.O;
        this.humanStarts = true;
    }

    public void setPreferences(boolean isHumanX, boolean humanStarts) {
        if (isHumanX) {
            this.humanSymbol = Symbol.X;
            this.botSymbol = Symbol.O;
        } else {
            this.humanSymbol = Symbol.O;
            this.botSymbol = Symbol.X;
        }
        this.humanStarts = humanStarts;
    }

    public Symbol getHumanSymbol() {
        return humanSymbol;
    }

    public Symbol getBotSymbol() {
        return botSymbol;
    }

    public boolean isHumanStarts() {
        return humanStarts;
    }
}
