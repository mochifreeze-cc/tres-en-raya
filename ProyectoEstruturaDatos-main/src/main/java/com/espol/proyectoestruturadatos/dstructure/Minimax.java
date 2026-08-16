package com.espol.proyectoestruturadatos.dstructure;

import com.espol.proyectoestruturadatos.model.board.Board;
import com.espol.proyectoestruturadatos.model.board.Symbol;
import java.util.List;

/**
 * Algoritmo Minimax que genera el árbol de decisiones N-ario a 2 niveles de profundidad
 * y selecciona la mejor jugada para la computadora siguiendo los 4 pasos especificados.
 * 
 * @author Gabriel
 */
public class Minimax {
    public static int getBestMove(Board currentBoard, Symbol computerSymbol, Symbol humanSymbol) {
        List<Integer> availableMovesL1 = currentBoard.getAvailableMovements();
        if (availableMovesL1.isEmpty()) {
            return -1;
        }

        // PASO 1: Generar los posibles estados simulando dos turnos de profundidad (Árbol N-ario)
        GameTree gameTree = new GameTree(new Board(currentBoard));
        GameTreeNode root = gameTree.getGameRoot();

        // Nivel 1: Movimientos de la computadora
        for (int moveL1 : availableMovesL1) {
            Board boardL1 = new Board(currentBoard);
            boardL1.setSymbol(computerSymbol, moveL1);

            GameTreeNode nodeL1 = gameTree.addChild(root, boardL1, moveL1, false);

            // Nivel 2 (Nodos hoja): Respuestas del oponente (humano)
            if (!boardL1.hasEnded && !boardL1.isFull()) {
                List<Integer> availableMovesL2 = boardL1.getAvailableMovements();
                for (int moveL2 : availableMovesL2) {
                    Board boardL2 = new Board(boardL1);
                    boardL2.setSymbol(humanSymbol, moveL2);

                    gameTree.addChild(nodeL1, boardL2, moveL2, true);
                }
            }
        }

        // PASO 2 & PASO 3:
        // PASO 2: Calcular la utilidad de cada uno de los tableros hoja generados por el oponente (Nivel 2).
        // PASO 3: Encontrar la utilidad mínima dentro de cada familia (nodos Nivel 2) y asociarla a su nodo padre del Nivel 1.
        for (TreeNode<Board> nodeL1 : root.getChildren()) {
            if (nodeL1.isLeaf()) {
                int util = nodeL1.getData().calculateUtility(computerSymbol, humanSymbol);
                nodeL1.setUtility(util);
            } else {
                int minUtility = Integer.MAX_VALUE;
                for (TreeNode<Board> nodeL2 : nodeL1.getChildren()) {
                    int utilL2 = nodeL2.getData().calculateUtility(computerSymbol, humanSymbol);
                    nodeL2.setUtility(utilL2);

                    if (utilL2 < minUtility) {
                        minUtility = utilL2;
                    }
                }
                nodeL1.setUtility(minUtility);
            }
        }

        // PASO 4: Elegir el tablero propio (Nivel 1) con la utilidad MÁXIMA de entre las utilidades mínimas calculadas
        TreeNode<Board> bestNodeL1 = null;
        int maxUtility = Integer.MIN_VALUE;

        for (TreeNode<Board> nodeL1 : root.getChildren()) {
            if (nodeL1.getUtility() > maxUtility) {
                maxUtility = nodeL1.getUtility();
                bestNodeL1 = nodeL1;
            }
        }

        if (bestNodeL1 != null) {
            return bestNodeL1.getMovement();
        }

        return availableMovesL1.get(0);
    }
}
