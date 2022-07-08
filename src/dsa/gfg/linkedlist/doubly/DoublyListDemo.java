package dsa.gfg.linkedlist.doubly;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.Scanner;

public class DoublyListDemo {

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
                    /*
                    ArrayList<Integer> elements = dlist.traverse();
                    for(Integer i:elements)
                        System.out.print(" "+i);

                     */
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
