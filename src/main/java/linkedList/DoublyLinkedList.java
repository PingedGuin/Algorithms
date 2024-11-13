package linkedList;

public class DoublyLinkedList<T> {
    DoublyLinkedListNode head;

    public void addAtBeginning(T value){
        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(value);
        newNode.prev = null;
        newNode.next = head;
        if(head != null){
            head.prev = newNode;
        }
        head = newNode;
    }
    public boolean Find(T value) {
        if (head == null)
            return false;

        while (head != null){
            if (head.data == value){
                return true;
            }
            head = head.next;
        }
        return false;
    }
    public void addAfter(T target,T valueAfter){
        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(valueAfter);
        DoublyLinkedListNode<T> current = head;
        if (head == null){
            return;
        }
        while (current != null){
            if (current.data == target){
                newNode.prev = current;
                newNode.next = current.next;
                current.next = newNode;
            }
            current = current.next;
        }
    }
    public void addAtEnd(T value){
        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(value);
        DoublyLinkedListNode<T> current = head;
        newNode.next = null;
        if (head == null){
            newNode.prev = null;
            head = newNode;
            return;
        }
        while(current.next != null){
            current = current.next;
        }
        newNode.prev = current;
        current.next = newNode;
    }
    public void delete(T value){
        DoublyLinkedListNode<T> current = head;
        if(head == null)
            return;
       while(current != null){
           if (current.data == value){
               current.prev.next = current.next;
               current.next.prev = current.prev;
           }
       }
    }
    public void deleteFirstNode(){
        DoublyLinkedListNode temp;
        if(head == null){
            return;
        }
        temp = head;
        head.next.prev = null;
        head = head.next;
        temp = null;

    }
    public void deleteLastNode(){
        DoublyLinkedListNode<T> current = head;
        if (head == null)
            return;
        if(head.next == null){
            head = null;
            return;
        }
        while (current.next.next != null){
            current = current.next;
        }
        DoublyLinkedListNode<T> temp = current.next;
        current.next =null;
        temp = null;
    }
}