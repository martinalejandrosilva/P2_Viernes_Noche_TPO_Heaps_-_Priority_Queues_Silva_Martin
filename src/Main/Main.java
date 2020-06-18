package Main;

import Main.Heaps.HeapSort;
import Main.Heaps.MaxHeap;
import Main.Heaps.MinHeap;
import Main.PriorityQueues.HighPriorityQueue;
import Main.PriorityQueues.LowPriorityQueue;
import Main.PriorityQueues.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        PriorityQueue hp = new HighPriorityQueue();

        hp.Initialize(10);
        System.out.println(hp.isEmpty());
        //hp.Peek();
        hp.Insert(9,5);
        System.out.println(hp.isEmpty());
        System.out.println(hp.Peek());
        hp.Insert(1,3);
        hp.Insert(3,4);
        hp.Insert(7,7);
        hp.Insert(4,1);
        hp.Insert(2,5);
        System.out.println(hp.Peek());
        hp.Extract();
        System.out.println(hp.Peek());
        System.out.println(hp.Extract());
        System.out.println(hp.Peek());













    }
}

