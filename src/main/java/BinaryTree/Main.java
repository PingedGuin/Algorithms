package BinaryTree;
import sorting.*;
import linkedList.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {2,1,13,23,32,3,42,31,5};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(InsertionSort.insertionSort(arr)));
        int da = 3;
        DoublyLinkedListNode<Integer> ah = new DoublyLinkedListNode<>(da);

    }
}