package Main.PriorityQueues;

import com.sun.jdi.Value;

public class HighPriorityQueue implements PriorityQueue{


    private class Node {
        public int value;
        public int Priority;

        public Node(int Value, int Priority){
            this.value = Value;
            this.Priority = Priority;
        }
    }

    private Node [] Heap;
    private int HeapSize;
    private int Pointer;

    public void Initialize(int Size){
        HeapSize = Size;
        Pointer = 0;
        Heap = new Node[Size];
    }

    @Override
    public void Insert(int Value, int Priority) {
        try{
        if( !(Pointer == HeapSize)){
            Heap[Pointer] = new Node(Value,Priority);
            Heap = this.BuildMaxHeap(Heap);
            Pointer++;
        }
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("The Queue Is Full..");
        }
    }

    @Override
    public int Peek() {
        return Heap[0].value;
    }

    public int Extract(){
        Node Element = null;
        if(!(Pointer == 0)) {
            Element = Heap[0];
            Heap[0] = Heap[Pointer - 1];
            Pointer--;
            Heap = BuildMaxHeap(Heap);
        }
        return Element.value;
    }

    public int Remove(int Value){
        return 0 ;
    }

    @Override
    public boolean isEmpty() {
        //Review
        return (Pointer == 0) ;
    }

    @Override
    public int Priority() {
        return Heap[0].Priority;
    }



    private Node [] MaxHeapify(Node[] A, int i){
        int l = (2*i)+1;
        int r = (2*i)+2;
        int largest;

        if(l <= Pointer && A[l].Priority > A[i].Priority){
            largest = l;
        }else{
            largest = i;
        }
        if (r <= Pointer && A[r].Priority > A[largest].Priority){
            largest = r;
        }
        if(largest != i) {
            Node aux = A[i];
            A[i] = A[largest];
            A[largest] = aux;
            MaxHeapify(A,largest);
        }
        return A;
    }

    private Node [] BuildMaxHeap(Node [] A){
        int x = 0;
        /*
        if(Pointer <=2 ){
            x = ((Pointer/2));
        }else{
            x = ((Pointer/2))-1;
        }
        */

        x = ((Pointer/2));
        for(int i = x; i>=0; i--){
            MaxHeapify(A,i);
        }
        return A;
    }


}
