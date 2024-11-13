package linkedList;

import BinaryTree.Node;

public class SinglyLinkedList {
    private SinglyLinkedListNode head = null;
     int size = 0;

    public SinglyLinkedList() {
        head = null;
    }

    public void add(int value) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);

        if (head == null) {
            head = newNode;
        }
        else{
            SinglyLinkedListNode current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
    }
    public void addBefore(int target,int value){
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
        if (head == null){
            head = newNode;
        } else if (head.data == target) {
            newNode.next = head;
            head = newNode;
        }
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode prev = null;
        while (current != null && current.data != target){
            prev = current;
            current = current.next;
        }
        if (current != null){
            newNode.next = current;
            if(prev != null){
                prev.next =  newNode;
            }
        }
        else {
            System.out.println("target not found");
        }
    }
    public void delete(int target){
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode prev = null;
        if (head == null){
            return;
        }
        if (head.data == target){
            head = head.next;
        }

        while (current.next != null && current.data != target){
            prev = current;
            current = current.next;
        }
        if (current == null){
            System.out.println("element not found");
            return;
        }
        prev.next = current.next;
        current = null;
    }
    public void DeleteFirstNode(){
        if(head == null){
            return;
        }
        head = head.next;
    }

    public void DeleteLastNode(){
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode prev = head;
        if (head == null){
            return;
        }
        if(current.next == null){
            head = null;
            return;
        }
        while(current.next != null){
            prev = current;
            current = current.next;
        }
            current = null;
            prev.next = null;

    }
    public void clear(){
        head = null;
        size = 0;
    }


}
