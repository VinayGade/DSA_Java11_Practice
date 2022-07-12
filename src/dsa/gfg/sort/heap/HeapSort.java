package dsa.gfg.sort.heap;

import dsa.gfg.sort.CommonUtility;

public class HeapSort extends CommonUtility {

    public void heapSort(int[] array){
        int n = array.length;

        for(int i=n/2 - 1; i>=0; i--)
            heapify(array, n, i);

        for(int j=n-1; j>0; j--){
            swap(0, j, array);
            heapify(array, j, 0);
        }
    }

    private void heapify(int[] array, int n, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left < n && array[left] > array[largest])
            largest = left;

        if(right < n && array[right] > array[largest])
            largest = right;

        if(largest != i){
            swap(i, largest, array);
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] a = {100, 80, 90, 75, 5, 20, 50, 40, 70};
        HeapSort obj = new HeapSort();
        obj.heapSort(a);
        obj.display(a);
    }
}
