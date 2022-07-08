package dsa.gfg.linkedlist.singly;

import java.util.*;

public class LinkedList {

    private Node head;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        if (isEmpty())
            return 0;
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void insertEnd(int data) {
        Node node = new Node(data);
        if (isEmpty())
            head = node;
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    public void insertBegin(int data) {
        Node node = new Node(data);
        if (!isEmpty())
            node.next = head;
        head = node;
    }

	public void deleteBegin() {
		if(isEmpty())
			return;
		head = head.next;
	}

	public void deleteEnd(){
		if(isEmpty())
			return;
		else if(head.next == null)
			head = null;
		else{
			Node temp = head;
			Node previous = null;
			while(temp.next!=null){
                previous = temp;
                temp = temp.next;
            }
			previous.next = null;
		}
	}

    public boolean delete(int key) {
		if (isEmpty())
			return false;
		else if(head.next == null){
			if(head.data == key) {
				head = null;
				return true;
			}else
				return false;
		}
		Node current = head;
		Node previous = null;
		while (current != null) {
			if (current.data == key) {
				previous.next = current.next;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
    }

    public boolean search(int key) {

        if (isEmpty())
            return false;
        Node current = head;
        while (current != null) {
            if (current.data == key)
                return true;
            current = current.next;
        }
        return false;
    }

    public int find(int index) {
        if (isEmpty() || size() < index)
            return -1;

        else if(index == 1)
            return head.data;

        Node current = head;
        int i = 1;
		int result = 0;
        while (i <= index && current != null) {
            if (i == index) {
				result = current.data;
				break;
			}
            current = current.next;
            i++;
        }
		return result;
    }

    public void traverse() {
        if (isEmpty())
            return;
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.insertBegin(10);
        linkedList.insertBegin(5);

        System.out.println("Traverse after insertion :");
        linkedList.traverse();

        linkedList.insertEnd(20);
        linkedList.insertEnd(30);
        linkedList.insertEnd(50);

        System.out.println("Traverse after insertion :");
        linkedList.traverse();

        linkedList.deleteBegin();
        System.out.println("Traverse after Deletion :");
        linkedList.traverse();

        linkedList.insertEnd(70);
        linkedList.insertEnd(75);
        linkedList.deleteEnd();

        System.out.println("Traverse after Deletion :");
        linkedList.traverse();

        System.out.println("Delete 20 :");
        linkedList.delete(20);
        linkedList.insertEnd(100);

        System.out.println("Traverse updated list :");
        linkedList.traverse();

        System.out.println("Element 50 found? :"+linkedList.search(50));
        System.out.println("Element at index 4 = "+linkedList.find(4));
        System.out.println("Element at index 5 = "+linkedList.find(5));
        System.out.println("Element at index 0 = "+linkedList.find(1));
    }

}