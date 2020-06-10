package Main.PriorityQueues;

public class HighPriorityQueue implements PriorityQueue{


    private class Node {
        public int value;
        public int Priority;
    }

    private Node [] Heap;
    private int HeapSize;
    private int Pointer;
    private int BackPointer;


    public void Initialize(int Size){
        HeapSize = Size;
        Pointer = 0;
        Heap = new Node[Size];

    }

    @Override
    public void Insert(int Value, int Priority) {


    }

    @Override
    public int Peek() {
        return Heap[0].value;
    }

    @Override
    public int Extract(int Value) {
        return 0;
    }

    @Override
    public void IncreaseKey(int Value, int NewPriority) {

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

        int x = ((HeapSize/2))-1;
        for(int i = x; i>=0; i--){
            MaxHeapify(A,i);
        }
        return A;
    }













}
