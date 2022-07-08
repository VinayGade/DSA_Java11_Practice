package dsa.gfg.linkedlist.doubly.two_heads;

public class DLL {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("Doubly Linked List Test");
        System.out.println("Insert at Start");
        list.insertAtStart(0);
        list.display();
        System.out.println("Insert at End");
        list.insertAtEnd(5);
        list.display();
        System.out.println("Insert at Position");
        list.insertAtPos(1, 2);
        list.insertAtPos(2, 3);
        list.insertAtPos(3, 4);
        list.display();
        System.out.println("Deleting at Position 1");
        list.deleteAtPos(1);
        list.display();
    }

}
