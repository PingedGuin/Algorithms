package BinaryTree;

public class AvlTree {
    AvlNode root;

    private AvlNode add(int value, AvlNode node){
        if (node == null){
            return new AvlNode(value);
        }
        if(node.value < value){
            node.right = add(value,node.right);
        } else if (node.value > value) {
            node.left = add(value,node.left);
        }else {
            return node;
        }
        UpdateHeight(node);
        return balance(node);
    }
    public void add(int value){
        root = add(value,root);
    }
    private void UpdateHeight(AvlNode node){
        node.height = 1 + Math.max(height(node.left),height(node.right));
    }
    private int height(AvlNode node){
        return node != null ? node.height : 0;
    }
    private int getBalanceFactor(AvlNode node){
        return (node != null) ? height(node.left) - height(node.right) : 0;
    }

    private AvlNode balance(AvlNode node){
        int balanceFactor = getBalanceFactor(node);

        if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
            return leftRotate(node);
        }
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
            return rightRotate(node);
        }

        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);

            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);

            return leftRotate(node);
        }
        return node;
    }
    private AvlNode leftRotate(AvlNode originalRoot){
        AvlNode newRoot = originalRoot.right;
        AvlNode originalLeftChild = newRoot.left;
        newRoot.left = originalRoot;
        originalRoot.left = originalLeftChild;
        UpdateHeight(originalRoot);
        UpdateHeight(newRoot);
        return newRoot;
    }
    private AvlNode rightRotate(AvlNode originalRoot){
        AvlNode newRoot = originalRoot.left;
        AvlNode originalRightChild = newRoot.right;
        newRoot.right = originalRoot;
        originalRoot.left = originalRightChild;
        UpdateHeight(originalRoot);
        UpdateHeight(newRoot);
        return newRoot;
    }
    private int findSmallestValue(AvlNode current){
        return current.left == null ? current.value : this.findSmallestValue(current.left);
    }
    private AvlNode delete(int data , AvlNode current){
        if (current == null)
            return null;
        else if (current.value == data) {
            if (current.left == null && current.right == null){
                return null;
            }
            else if (current.right == null){
                return current.left;
            } else if (current.left ==   null) {
                return current.right;
            }
            else {
                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = this.delete(smallestValue,current.right);
                return current;
            }
        } else{
            if (current.value < data){
                current.right = this.delete(data,current.right);
            }
            else {
                current.left = this.delete(data, current.left);
            }
        }
        UpdateHeight(current);
        return balance(current);
    }
}
