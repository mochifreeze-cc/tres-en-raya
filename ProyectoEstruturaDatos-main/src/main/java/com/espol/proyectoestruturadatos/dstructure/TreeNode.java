package com.espol.proyectoestruturadatos.dstructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase genérica TreeNode para representar un nodo en un árbol N-ario.
 * 
 * @param <E> Tipo de elemento almacenado en el nodo.
 * @author Gabriel
 */
public class TreeNode<E> {
    private E data;
    private TreeNode<E> parent;
    private List<TreeNode<E>> children;
    private int utility;
    private int movement;
    private int depth;
    private boolean maximizing;

    public TreeNode(E data) {
        this.data = data;
        this.parent = null;
        this.children = new ArrayList<>();
        this.utility = 0;
        this.movement = -1;
        this.depth = 0;
        this.maximizing = true;
    }

    public TreeNode(E data, int movement, int depth, boolean maximizing) {
        this.data = data;
        this.parent = null;
        this.children = new ArrayList<>();
        this.utility = 0;
        this.movement = movement;
        this.depth = depth;
        this.maximizing = maximizing;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public List<TreeNode<E>> getChildren() {
        return children;
    }

    public void addChild(TreeNode<E> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public int getUtility() {
        return utility;
    }

    public void setUtility(int utility) {
        this.utility = utility;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public boolean isMaximizing() {
        return maximizing;
    }

    public void setMaximizing(boolean maximizing) {
        this.maximizing = maximizing;
    }
}
