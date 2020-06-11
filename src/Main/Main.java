package Main;

import Main.Heaps.HeapSort;
import Main.Heaps.MaxHeap;
import Main.Heaps.MinHeap;
import Main.PriorityQueues.HighPriorityQueue;
import Main.PriorityQueues.LowPriorityQueue;

public class Main {

    public static void main(String[] args) {

        int A [] = new int []{14,9,10,16,2,3,4,1,7,8};

        HeapSort b = new HeapSort();

        int [] c = b.Sort(A);

        for(byte x = 0; x<c.length;x++){
            System.out.println(c[x]);
        }




}
}

