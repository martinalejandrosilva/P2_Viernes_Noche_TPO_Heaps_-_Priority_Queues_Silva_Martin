package Main;

import Main.Heaps.HeapSort;
import Main.Heaps.MaxHeap;
import Main.Heaps.MinHeap;
import Main.PriorityQueues.HighPriorityQueue;
import Main.PriorityQueues.LowPriorityQueue;

public class Main {

    public static void main(String[] args) {


        MaxHeap a = new MaxHeap(10,true);
        a.AddValue(3);
        a.AddValue(4);
        a.AddValue(7);
        a.AddValue(24);
        a.AddValue(9);
        a.AddValue(45);
        a.AddValue(78);
        a.AddValue(33);
        a.AddValue(12);
        a.AddValue(27);
        a.AddValue(9000);
        a.PrintHeap();

        a.RemoveValue(78);
        a.RemoveValue(45);
        a.RemoveValue(1);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        a.PrintHeap();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        a.AddValue(54);
        a.AddValue(12);
        a.AddValue(20);
        a.AddValue(20);
        a.PrintHeap();







    }
}

