package dsa.gfg.linkedlist.doubly;

import java.util.ArrayList;
import java.util.Scanner;

public class DoublyLinkedList {

    private DoublyNode head;

    public DoublyLinkedList(){
        head = null;
    }

    public DoublyLinkedList(int data){
        head = new DoublyNode(data);
        head.next = null;
    }

    public void setHead(DoublyNode head) {
        this.head = head;
    }

    public boolean isEmpty(){
        return head == null;
    }

    //public DoublyNode insertBegin(DoublyNode head, int data){

    public DoublyNode insertBegin(int data){
        DoublyNode newHead = new DoublyNode(data);
        //newHead.next = head;
        if(isEmpty()) {
            head = newHead;
            //newHead = head.prev;
        }else {
            //head = newHead;
            newHead.next = head;
            newHead = head.prev;
            //this.setHead(newHead);
        }
        return head;
    }

    public DoublyNode insertEnd(int data){

        DoublyNode tail = new DoublyNode(data);
        if(isEmpty()) {
            head = tail;
        }else {
            DoublyNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = tail;
            tail.prev = temp;
        }
        return head;
    }

    public DoublyNode insertAfter(int data, int key){
        DoublyNode node = new DoublyNode(data);
        if(isEmpty()) {
            this.setHead(node);
            head = node;
        }else {
            DoublyNode temp = head;
            while (temp.next != null) {
                if (temp.data == key) {
                    node.next = temp.next.prev;
                    temp.next = node;
                    node.prev = temp;
                    break;
                }
                temp = temp.next;
            }
            if(temp.next == null && temp.data == key){
                temp.next = node;
                node.prev = temp;
            }
        }
        return head;
    }

    public DoublyNode deleteKey(int key){
        if(head.next == null)
            return head = null;

        DoublyNode temp = head;
        while(temp!=null) {
            if(temp.data == key){
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }
        return head;
    }

    public DoublyNode deleteHead(){

        if(head.next == null)
            return head = null;
        head = head.next;
        head.prev = null;
        return head;
    }

    public DoublyNode deleteEnd(){
        if(head.next == null)
            return head = null;

        DoublyNode temp = head;
        while(temp != null)
            temp = temp.next;

        temp.prev.next = null;
        return head;
    }

    public ArrayList<Integer> traverse2(){
        ArrayList<Integer> elements = new ArrayList<>();
        DoublyNode temp = head;
        while(temp != null){
            elements.add(temp.data);
            temp = temp.next;
        }
        return elements;
    }

    public void traverse(){
        //ArrayList<Integer> elements = new ArrayList<>();
        DoublyNode temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList dlist = new DoublyLinkedList();

        Scanner scanner = new Scanner(System.in);

        /*System.out.println("Create List:");
        System.out.println("Enter head data:");
        int headData = scanner.nextInt();
        DoublyNode head = new DoublyNode(headData);
        dlist.setHead(head);*/

        while(true){

            System.out.println("Doubly Linked List operations :");

            System.out.println("1. insert begin");
            System.out.println("2. insert end");
            System.out.println("3. insert after");
            System.out.println("4. delete bein");
            System.out.println("5. delete end");
            System.out.println("6. delete key");
            System.out.println("7. traverse");

            System.out.println("Enter your choice :");
            int ch = scanner.nextInt();

            switch(ch){

                case 1:
                    System.out.println("Enter data to insert at begin:");
                    int data = scanner.nextInt();
                    dlist.insertBegin(data);
                    break;

                case 2:
                    System.out.println("Enter data to insert at end:");
                    int dataEnd = scanner.nextInt();
                    dlist.insertEnd(dataEnd);
                    break;

                case 3:
                    System.out.println("Enter key after which element need to insert :");
                    int insertKey = scanner.nextInt();
                    System.out.println("Enter data to insert :");
                    int dataAfter = scanner.nextInt();
                    dlist.insertAfter(dataAfter, insertKey);
                    break;

                case 4:
                    System.out.println("Delete from begin:");
                    dlist.deleteHead();
                    break;

                case 5:
                    System.out.println("Delete at end:");
                    dlist.deleteEnd();
                    break;

                case 6:
                    System.out.println("Enter key to delete :");
                    int deleteKey = scanner.nextInt();
                    dlist.deleteKey(deleteKey);
                    break;

                case 7:
                    System.out.println("Traverse Doubly LinkedList :");
                    dlist.traverse();

                    /*ArrayList<Integer> elements = dlist.traverse();
                    for(Integer i:elements)
                        System.out.print(" "+i);*/
                    break;

                case 8:
                    break;
                case 9:
                    break;

                default:
                    System.exit(0);
                    break;
            }
        }
    }

}

