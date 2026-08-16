package com.espol.proyectoestruturadatos.dstructure;

/**
 * Clase genérica Tree que representa un Árbol N-ario.
 * 
 * @param <E> Tipo de elemento almacenado en el árbol.
 * @author Gabriel
 */
public class Tree<E> {
    private TreeNode<E> root;

    public Tree() {
        this.root = null;
    }

    public Tree(E rootData) {
        this.root = new TreeNode<>(rootData);
    }

    public Tree(TreeNode<E> root) {
        this.root = root;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isLeaf() {
        return root != null && root.isLeaf();
    }
}
