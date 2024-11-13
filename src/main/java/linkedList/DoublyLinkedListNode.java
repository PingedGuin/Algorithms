package linkedList;

import java.util.Arrays;

public class DoublyLinkedListNode<T> {
    T data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(T data) {
        this.data = data;
    }

}