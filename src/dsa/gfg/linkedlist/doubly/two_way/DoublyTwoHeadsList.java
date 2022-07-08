package dsa.gfg.linkedlist.doubly.two_way;

import dsa.gfg.linkedlist.exceptions.EmptyListException;

public class DoublyTwoHeadsList {

    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;
    private int length;

    public DoublyTwoHeadsList(){

        this.head = null;
        this.tail = null;
        length = 0;
    }

    private class DoublyLinkedNode{
        private int data;
        private DoublyLinkedNode next;
        private DoublyLinkedNode previous;

        DoublyLinkedNode(int data){
            this.data = data;
        }
    }

    public boolean isEmpty(){
        return head == null;   // return length == 0;
    }

    public int getLength(){
        return this.length;
    }

    public int size(){
        if(isEmpty())
            return 0;
        else if(head == tail)
            return 1;
        else {
            int count = 0;
            DoublyLinkedNode temp = head;
            while (temp != null){    // temp.data != tail.data
                 ++count;
                temp = temp.next;
            }
            return count;
        }
    }

    public void traverse() throws EmptyListException {
        if(isEmpty())
            throw new EmptyListException("Doubly Linked List is empty !!");

        DoublyLinkedNode temp = head;
        while(temp != null){
            System.out.print(" --> " + temp.data);
            temp = temp.next;
        }
        System.out.print(" --> null");
    }

    public void reverse()throws EmptyListException {
        if(isEmpty())
            throw new EmptyListException("Doubly Linked List is empty !!");

        DoublyLinkedNode temp = tail;
        while(temp != null){
            System.out.print(" --> " + temp.data);
            temp = temp.previous;
        }
        System.out.print(" --> null");
    }

    public void insertBegin(int element) {
        DoublyLinkedNode node = new DoublyLinkedNode(element);
        if(isEmpty())
            tail = node;
        else
            head.previous = node;
        node.next = head;
        head = node;
        length++;
    }

    public void insertEnd(int element) {
        DoublyLinkedNode node = new DoublyLinkedNode(element);
        if(isEmpty())
            head = node;
        else{
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
        length++;
    }

    public void insertAfter(int key, int data) throws NoSuchElementException{
        DoublyLinkedNode node = new DoublyLinkedNode(data);
        if(isEmpty())
            head = node;
        else{
            DoublyLinkedNode current = head;
            while(current.data!=key){
                current = current.next;
                if(current == null)
                    throw new NoSuchElementException("Reached end of list !! Element "+key+" cannot be found. Hence cannot insert data!");
            }
            if(current == tail){
                node.next = null;
                tail = node;
            }else{
                node.next = current.next;
                current.next.previous = node;
            }
            node.previous = current;
            current.next = node;
        }
    }

    public void delete(int key) throws EmptyListException, NoSuchElementException{
        if(isEmpty())
            throw new EmptyListException("Element cannot be found since List is empty!!");
        else{
            DoublyLinkedNode current = head;
            while(current.data != key){
                current = current.next;
                if(current == null)
                    throw new NoSuchElementException("Reached end of list !! Element "+key+" cannot be found. Hence cannot delete it!");
            }
            if(current == head)
                head = current.next;
            else
                current.previous.next = current.next;

            if(current == tail)
                tail = current.previous;
            else
                current.next.previous = current.previous;
        }
    }

    public int deleteBegin() throws EmptyListException{    // returns data of deleted node : head
        if(isEmpty())
            throw new EmptyListException("Cannot Delete Since List is empty !!");

        DoublyLinkedNode temp = head;
        if(head == tail)
            tail = null;
        else
            head.next.previous = null;

        head = head.next;
        temp.next = null;
        length--;
        return temp.data;
    }

    public int deleteEnd() throws EmptyListException{     // returns data of deleted node : tail
        if(isEmpty())
            throw new EmptyListException("Cannot Delete Since List is empty !!");

        DoublyLinkedNode temp = tail;
        if(head == tail)
            head = null;
        else
            tail.previous.next = null;

        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp.data;
    }

    public static void main(String[] args) {
        DoublyTwoHeadsList twoHeadsList = new DoublyTwoHeadsList();

        System.out.println("\n Insert Begin");
        twoHeadsList.insertBegin(20);
        twoHeadsList.insertBegin(10);
        twoHeadsList.insertBegin(5);

        System.out.println("\n Insert End");
        twoHeadsList.insertEnd(30);
        twoHeadsList.insertEnd(50);

        twoHeadsList.insertBegin(1);
        twoHeadsList.insertEnd(70);
        twoHeadsList.insertEnd(75);
        twoHeadsList.insertEnd(81);
        try {
            System.out.println("\n Traverse");
            twoHeadsList.traverse();
            System.out.println("\n Reverse");
            twoHeadsList.reverse();
            System.out.println("\nSize ="+twoHeadsList.size());

            System.out.println("Deleted head :"+twoHeadsList.deleteBegin());
            System.out.println("Deleted tail :"+twoHeadsList.deleteEnd());
            System.out.println("Deleted tail :"+twoHeadsList.deleteEnd());
            //System.out.println("Deleted tail :"+twoHeadsList.deleteEnd());

            System.out.println("\n Traverse after delete");
            twoHeadsList.traverse();

            /*
            System.out.println("\n Reverse after delete");
            twoHeadsList.reverse();
            */

            System.out.println("\nafter delete Size ="+twoHeadsList.size());

            twoHeadsList.delete(20);

            System.out.println("\n Traverse after delete 20");
            twoHeadsList.traverse();

            System.out.println("\n Insert 60 after 50");
            twoHeadsList.insertAfter(50,60);

            System.out.println("\n Insert 40 after 30");
            twoHeadsList.insertAfter(30,40);

            System.out.println("\n Insert 20 after 10");
            twoHeadsList.insertAfter(10,20);

            System.out.println("\n Traverse after insertion");
            twoHeadsList.traverse();

            System.out.println("\nSize ="+twoHeadsList.size());

            twoHeadsList.insertEnd(80);
            twoHeadsList.insertEnd(90);
            twoHeadsList.insertEnd(95);
            twoHeadsList.insertEnd(100);
            twoHeadsList.insertEnd(120);

            System.out.println("\n Traverse after insertion");
            twoHeadsList.traverse();

            System.out.println("\nSize ="+twoHeadsList.size());

            twoHeadsList.deleteBegin();
            twoHeadsList.deleteEnd();
            twoHeadsList.delete(95);

            System.out.println("\n Traverse after delete");
            twoHeadsList.traverse();

            System.out.println("\nSize ="+twoHeadsList.size());

        }catch(EmptyListException | NoSuchElementException ex){
            ex.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
