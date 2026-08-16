package com.espol.proyectoestruturadatos.dstructure;

import com.espol.proyectoestruturadatos.model.board.Board;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabriel
 * @author Dylan Jeanpier Pincay Salazar
 * @author Helen Cruz
 */
public class GameTreeNode extends TreeNode<Board> {

    public GameTreeNode(Board board) {
        super(board);
    }

    public GameTreeNode(Board board, int movement, int depth, boolean maximizing) {
        super(board, movement, depth, maximizing);
    }

    public Board getBoard() {
        return getData();
    }

    public void setBoard(Board board) {
        setData(board);
    }

    @SuppressWarnings("unchecked")
    public List<GameTreeNode> getGameChildren() {
        List<GameTreeNode> list = new ArrayList<>();
        for (TreeNode<Board> child : getChildren()) {
            if (child instanceof GameTreeNode) {
                list.add((GameTreeNode) child);
            }
        }
        return list;
    }
}
