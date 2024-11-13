package BinaryTree;

public class AvlNode {
    int value;
    int height;
    AvlNode right;
    AvlNode left;

    public AvlNode(int value) {
        this.value = value;
        height = 1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AvlNode getRight() {
        return right;
    }

    public void setRight(AvlNode right) {
        this.right = right;
    }

    public AvlNode getLeft() {
        return left;
    }

    public void setLeft(AvlNode left) {
        this.left = left;
    }
}
