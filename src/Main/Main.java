package Main;

import Main.Heaps.HeapSort;
import Main.Heaps.MaxHeap;
import Main.Heaps.MinHeap;

public class Main {

    public static void main(String[] args) {
        //MinHeap Test...
        MinHeap M;
        int A [] = new int []{14,9,10,16,2,3,4,1,7,8};
        //Create A Min Heap from an Array Without Possibility of Increasing its Size...

        M = new MinHeap(A);

        System.out.println("Printing A Min Heap");
        System.out.println("------------------------------------------------------");
        M.PrintHeap();
        System.out.println();
        System.out.println("------------------------------------------------------");
        //The Same Array but with Resize Possibility.
        M = new MinHeap(A,true);

        //Adding Value to the The Heap
        M.AddValue(100);
        System.out.println("Printing A Min Heap After the Resize.");
        System.out.println("------------------------------------------------------");
        M.PrintHeap();
        System.out.println();
        System.out.println("------------------------------------------------------");
        //Removing Values From Array.
        M.RemoveValue(100);
        M.RemoveValue(4);
        System.out.println("Printing The Same Min Heap Removing 2 Elements.");
        System.out.println("------------------------------------------------------");
        M.PrintHeap();
        System.out.println();
        System.out.println("------------------------------------------------------");

        //Creating a Heap introducing each single value of it
        M = new MinHeap(true);
        M.AddValue(16);
        M.AddValue(4);
        M.AddValue(10);
        M.AddValue(14);
        M.AddValue(7);
        M.AddValue(9);
        M.AddValue(3);
        M.AddValue(2);
        M.AddValue(8);
        M.AddValue(1);
        System.out.println("Printing Min Heap with single insertions...");
        System.out.println("------------------------------------------------------");
        M.PrintHeap();
        System.out.println();
        System.out.println("------------------------------------------------------");


        //MaxHeap Test
        MaxHeap mh;
        //Create A Max Heap from an Array Without Possibility of Increasing its Size...
        mh = new MaxHeap(A);

        System.out.println("Printing A Max Heap");
        System.out.println("------------------------------------------------------");
        mh.PrintHeap();
        System.out.println();
        System.out.println("------------------------------------------------------");
        //The Same Array but with Resize Possibility.
        mh = new MaxHeap(A,true);

        //Adding Value to the The Heap
        mh.AddValue(100);
        System.out.println("Printing A Max Heap After the Resize.");
        System.out.println("------------------------------------------------------");
        mh.PrintHeap();
        System.out.println();
        System.out.println("------------------------------------------------------");
        //Removing Values From Array.
        mh.RemoveValue(100);
        mh.RemoveValue(4);
        System.out.println("Printing The Same Max Heap Removing 2 Elements.");
        System.out.println("------------------------------------------------------");
        mh.PrintHeap();
        System.out.println();
        System.out.println("------------------------------------------------------");

        //Creating a Heap introducing each single value of it
        mh = new MaxHeap(true);
        mh.AddValue(16);
        mh.AddValue(4);
        mh.AddValue(10);
        mh.AddValue(14);
        mh.AddValue(7);
        mh.AddValue(9);
        mh.AddValue(3);
        mh.AddValue(2);
        mh.AddValue(8);
        mh.AddValue(1);
        System.out.println("Printing The Same Max Heap Removing 2 Elements.");
        System.out.println("------------------------------------------------------");
        mh.PrintHeap();
        System.out.println();
        System.out.println("------------------------------------------------------");


    }

}

