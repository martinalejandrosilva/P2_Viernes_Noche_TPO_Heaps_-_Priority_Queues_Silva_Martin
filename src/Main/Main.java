package Main;

import Main.Heaps.MaxHeap;

public class Main {

    public static void main(String[] args) {
        int a [] = new int [10];
        a[0] = 16;
        a[1] = 17;
        a[2] = 18;
        a[3] = 19;
/*
        int b [] = new int []{16,14,10,9,8,7,4,3,2,1};
        MinHeap mh = new MinHeap(b);
        mh.PrintHeap();
*/
        int c [] = new int []{14,9,10,16,2,3,4,1,7,8};
        MaxHeap m = new MaxHeap(c,true);
        // m.RemoveValue(9);
        // m.RemoveValue(10);
        // m.RemoveValue(16);
        // m.RemoveValue(3);
        m.AddValue(98);
        m.PrintHeap();

        //MaxHeap h = new MaxHeap(b);
        //h.PrintHeap();

        /*
        MinHeap h = new MinHeap(10,true);
        h.AddValue(16);
        h.AddValue(4);
        h.AddValue(10);
        h.AddValue(14);
        h.AddValue(7);
        h.AddValue(9);
        h.AddValue(3);
        h.AddValue(2);
        h.AddValue(8);
        h.AddValue(1);
        h.PrintHeap();

         */
        /*
        //h.AddValue(27);
        h.PrintHeap();
        System.out.println("");
        System.out.println("----------------------------------");
        //h.RemoveValue(27);
        h.PrintHeap();
        System.out.println("");
        System.out.println("----------------------------------");
     //   h.AddValue(40);
        h.PrintHeap();
*/
    }
    }

