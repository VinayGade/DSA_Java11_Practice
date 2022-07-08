package dsa.hackerrank;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapOperations {

    /*

    Heap Operations

    1 - Add element to heap
    2 - Delete element from heap
    3 - Print Minimum from heap

    STDIN       Function
-----       --------
5           Q = 5
1 4         insert 4
1 9         insert 9
3           print minimum
2 4         delete 4
3           print minimum

    * */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();

        //PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i=0; i<q; i++){

            int operation = scan.nextInt();

            switch(operation){
                case 1 :
                    int element = scan.nextInt();
                    heap.add(element);
                    break;

                case 2 :
                    int key = scan.nextInt();
                    heap.remove(key);
                    break;

                case 3 :
                    int min = heap.peek();
                    System.out.println(min);
                    break;

                default : break;
            }
        }
        scan.close();
    }
}
