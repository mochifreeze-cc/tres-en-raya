package controller;

import com.espol.proyectoestruturadatos.model.board.Symbol;

/**
 * Controlador para procesar los resultados finales de las partidas.
 * 
 * @author Gabriel
 */
public class ResultController {

    public static String getResultMessage(Symbol winner, Symbol humanSymbol) {
        if (winner == null) {
            return "¡Empate! Ha sido una partida muy igualada.";
        }
        if (winner.equals(humanSymbol)) {
            return "¡Felicidades! Has ganado la partida al Computador.";
        } else {
            return "¡El Computador ha ganado la partida!";
        }
    }

    public static String getResultTitle(Symbol winner, Symbol humanSymbol) {
        if (winner == null) {
            return "Resultado: Empate";
        }
        if (winner.equals(humanSymbol)) {
            return "¡Victoria!";
        } else {
            return "Derrota";
        }
    }
}
