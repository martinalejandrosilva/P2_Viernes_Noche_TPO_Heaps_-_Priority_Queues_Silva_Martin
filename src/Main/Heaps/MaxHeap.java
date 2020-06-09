package Main.Heaps;

public class MaxHeap {

    private int [] Heap;
    private int Pointer;
    private int HeapSize;
    private boolean Dynamic;

    public MaxHeap (int Size, boolean Dynamic){
        Heap = new int[Size + 1];
        Pointer = 1;
        HeapSize = Size +1 ;
        this.Dynamic = Dynamic;
    }

    public MaxHeap (){
        Heap = new int[100];
        Pointer = 1;
        HeapSize = 101;
        Dynamic = false;
    }

    public MaxHeap (int Size){
        Heap = new int[Size + 1];
        Pointer = 1;
        HeapSize = Size +1;
        Dynamic = false;
    }

    public MaxHeap (boolean Dynamic){
        Heap = new int[101];
        Pointer = 1;
        HeapSize = 101;
        this.Dynamic = Dynamic;
    }
    public MaxHeap (int [] Array,boolean Dynamic ){
        HeapSize = Array.length +1;
        Pointer = Array.length +1;
        this.Dynamic = Dynamic;
        Heap = SlideArray(Array);
        Heap = this.BuildMaxHeap(Heap);
    }

    public MaxHeap (int [] Array){
        HeapSize = Array.length +1;
        Pointer = Array.length+1;
        Dynamic = false;
        Heap = SlideArray(Array);
        Heap = this.BuildMaxHeap(Heap);
    }

    private int [] SlideArray(int [] Array){
        int a [] = new int[Array.length + 1];

        for (int i = 0; i < Array.length; i++){
            a[i+1] = Array[i];
        }
        return a;
    }

    public void AddValue(int x){
        //Check if Heap is full.
        try {
            if (Pointer == HeapSize) {
                if (Dynamic) {
                    if(Heap.length > HeapSize){
                        HeapSize++;
                    }else{
                        Heap = ResizeArray();
                    }
                } else {
                    throw new Exception();
                }
            }
            Heap[Pointer] = x;
            Heap = this.BuildMaxHeap(Heap);
            Pointer++;
        }catch (Exception ex){
            System.out.println("The Array is Full...");
        }
    }

    public void RemoveValue(int x){
        //Check If Value is in the Array, if dont we don't have nothing to delete...
        //if this is != 0 the element Exist in the array.
        int ElementIdx = Exist(x);
        if(ElementIdx != 0){
            int Aux = Heap[Pointer-1];
            Heap[ElementIdx] = Aux;
            Heap = this.BuildMaxHeap(Heap);
            Pointer--;
            HeapSize--;
        }
    }

    public int Peek(){
        return Heap[1];
    }

    public void PrintHeap(){
        for(int i = 1; i<HeapSize; i++){
            System.out.print(Heap[i] + ", ");
        }
    }

    public int Exist(int x){
        int ArrayPosition = 0;
        for(byte i = 1; i<HeapSize; i++){
            if(Heap[i] == x){
                ArrayPosition = i;
                break;
            }
        }
        return ArrayPosition;
    }

    public boolean isEmpty(){
        return (Pointer == 1);
    }

    private int [] ResizeArray(){
        int [] A = new int[HeapSize +1];
        for(int i = 1; i<HeapSize; i++){
            A[i] = Heap[i];
        }
        HeapSize = HeapSize +1;
        return A;
    }

    //For The Max/Min Heap i don't want to expose the methods.
    private int [] MaxHeapify(int[] A, int i){
        int l = (2*i);
        int r = (2*i)+1;
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

        int x = (HeapSize/2);
        for(int i = x; i>0; i--){
            MaxHeapify(A,i);
        }
        return A;
    }
}
