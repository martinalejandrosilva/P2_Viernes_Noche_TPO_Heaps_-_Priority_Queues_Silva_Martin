package Main.Heaps;

public class HeapSort {

    private int [] SortedArray;
    private int HeapSize;


    public int [] Sort(int [] A){

        HeapSize = A.length;
        A = BuildMaxHeap(A);
        for(int i = HeapSize-1; i >0; i--)
        {
            int x = A[0];
            A[0] = A[i];
            A[i] = x;
            HeapSize--;
            A = MaxHeapify(A,0);
        }
        return A;
    }



    private int [] MaxHeapify(int[] A, int i){
        int l = (2*i)+1;
        int r = (2*i)+2;
        int largest;

        if(l <= HeapSize-1 && A[l] > A[i]){
            largest = l;
        }else{
            largest = i;
        }
        if (r <= HeapSize-1 && A[r] > A[largest]){
            largest = r;
        }
        if(largest != i) {
            int aux = A[i];
            A[i] = A[largest];
            A[largest] = aux;
            MaxHeapify(A,largest);
        }
        return A;
    }

    private int [] BuildMaxHeap(int [] A){

        //int x = ((HeapSize/2))-1;
        int x = ((HeapSize/2));
        for(int i = x; i>=0; i--){
            MaxHeapify(A,i);
        }
        return A;
    }

}
