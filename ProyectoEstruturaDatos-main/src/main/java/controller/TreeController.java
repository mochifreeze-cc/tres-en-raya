package controller;

import com.espol.proyectoestruturadatos.dstructure.GameTree;
import com.espol.proyectoestruturadatos.dstructure.GameTreeNode;
import com.espol.proyectoestruturadatos.model.board.Board;
import com.espol.proyectoestruturadatos.model.board.Symbol;

/**
 * Controlador para la gestión y traversal del Árbol N-ario de decisiones (GameTree).
 * 
 * @author Gabriel
 */
public class TreeController {

    public static GameTree buildDecisionTree(Board board, Symbol computerSymbol, Symbol humanSymbol) {
        GameTree gameTree = new GameTree(new Board(board));
        GameTreeNode root = gameTree.getGameRoot();

        for (int moveL1 : board.getAvailableMovements()) {
            Board boardL1 = new Board(board);
            boardL1.setSymbol(computerSymbol, moveL1);

            GameTreeNode nodeL1 = gameTree.addChild(root, boardL1, moveL1, false);

            if (!boardL1.hasEnded && !boardL1.isFull()) {
                for (int moveL2 : boardL1.getAvailableMovements()) {
                    Board boardL2 = new Board(boardL1);
                    boardL2.setSymbol(humanSymbol, moveL2);
                    gameTree.addChild(nodeL1, boardL2, moveL2, true);
                }
            }
        }
        return gameTree;
    }
}
