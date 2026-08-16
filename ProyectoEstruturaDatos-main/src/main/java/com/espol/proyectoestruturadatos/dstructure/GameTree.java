package com.espol.proyectoestruturadatos.dstructure;

import com.espol.proyectoestruturadatos.model.board.Board;
import java.util.LinkedList;
import java.util.Queue;

/** 
 * @author Gabriel
 * @author Dylan Jeanpier Pincay Salazar
 * @author Helen Cruz
 */
public class GameTree extends Tree<Board> {

    public GameTree(Board board) {
        super(new GameTreeNode(board));
    }

    public GameTreeNode getGameRoot() {
        return (GameTreeNode) getRoot();
    }

    public GameTreeNode addChild(GameTreeNode parent, Board board, int movement, boolean maximizing) {
        GameTreeNode child = new GameTreeNode(board, movement, parent.getDepth() + 1, maximizing);
        parent.addChild(child);
        return child;
    }

    public void traverse() {
        if (isEmpty()) return;
        Queue<TreeNode<Board>> queue = new LinkedList<>();
        queue.offer(getRoot());

        while (!queue.isEmpty()) {
            TreeNode<Board> node = queue.poll();
            System.out.println("---");
            System.out.println("Nivel: " + node.getDepth());
            System.out.println("Movimiento: " + node.getMovement());
            System.out.println("Utilidad: " + node.getUtility());
            System.out.println("Tipo: " + (node.isMaximizing() ? "MAX" : "MIN"));

            for (TreeNode<Board> child : node.getChildren()) {
                queue.offer(child);
            }
            System.out.println("---");
        }
    }
}
