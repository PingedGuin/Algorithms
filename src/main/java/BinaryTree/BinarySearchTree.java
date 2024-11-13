package BinaryTree;

public class BinarySearchTree {
    private Node root = null;

    public BinarySearchTree() {
    }

    private Node addRecursive(Node current,int value) {
        if (current == null) {
            return new Node(value);
        } else {
            if (current.value > value) {
                current.left = this.addRecursive(current.left, value);
            } else if (current.value < value) {
                current.right = this.addRecursive(current.right, value);
            }
            return current;
        }
    }

    public void add(int value) {
        this.root = this.addRecursive(this.root, value);
    }

    private boolean containsNodeRecursiveNode(Node current, int value) {
        if (current == null) {
            return false;
        } else if (value == current.value) {
            return true;
        } else {
            return value < current.value ? this.containsNodeRecursiveNode(current.left, value) : this.containsNodeRecursiveNode(current.right, value);
        }
    }

    public boolean containsNode(int value) {

        // comment hhaaaaa
        return this.containsNodeRecursiveNode(this.root, value);
    }

    private int findSmallestValue(Node current) {
        return current.left == null ? current.value : this.findSmallestValue(current.left);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        } else if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.right == null) {
                return current.left;
            } else if (current.left == null) {
                return current.right;
                } else {
                int smallestValue = this.findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = this.deleteRecursive(current.right, smallestValue);
                return current;
            }
        } else {
            if (value < current.value) {
                current.left = this.deleteRecursive(current.left, value);
            } else {
                current.right = this.deleteRecursive(current.right, value);
            }
            return current;
        }
    }

    public void delete(int value) {
        this.root = this.deleteRecursive(this.root, value);
    }

    private void traverseInOrder(Node node) {
        if (node != null) {
            this.traverseInOrder(node.left);
            System.out.print(" " + node.value);
            this.traverseInOrder(node.right);
        }

    }

    public void inOrder() {
        this.traverseInOrder(this.root);
        System.out.println();
    }

    private void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            this.traversePreOrder(node.left);
            this.traversePreOrder(node.right);
        }

    }

    public void preOrder() {
        this.traversePreOrder(this.root);
        System.out.println();
    }

    private void traversePostOrder(Node node) {
        if (node != null) {
            this.traversePostOrder(node.left);
            this.traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }

    }

    public void postOrder() {
        this.traversePostOrder(this.root);
        System.out.println();
    }

}
