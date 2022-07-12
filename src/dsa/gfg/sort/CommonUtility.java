package dsa.gfg.sort;

public class CommonUtility {

    public void display(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }

    public int[] swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }
}
