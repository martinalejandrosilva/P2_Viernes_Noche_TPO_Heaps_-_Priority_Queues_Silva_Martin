package Main.Heaps;

public class MinHeap {

    private int [] Heap;
    private int Pointer;
    private int HeapSize;
    private boolean Dynamic;

    public MinHeap (int Size, boolean Dynamic){
        Heap = new int[Size + 1];
        Pointer = 1;
        HeapSize = Size +1 ;
        this.Dynamic = Dynamic;
    }

    public MinHeap (){
        Heap = new int[100];
        Pointer = 1;
        HeapSize = 101;
        Dynamic = false;
    }

    public MinHeap (int Size){
        Heap = new int[Size + 1];
        Pointer = 1;
        HeapSize = Size +1;
        Dynamic = false;
    }

    public MinHeap (boolean Dynamic){
        Heap = new int[101];
        Pointer = 1;
        HeapSize = 101;
        this.Dynamic = Dynamic;
    }
    public MinHeap (int [] Array,boolean Dynamic ){
        HeapSize = Array.length +1;
        Pointer = Array.length +1;
        this.Dynamic = Dynamic;
        Heap = SlideArray(Array);
        Heap = this.BuildMinHeap(Heap);
    }

    public MinHeap (int [] Array){
        HeapSize = Array.length +1;
        Pointer = Array.length+1;
        Dynamic = false;
        Heap = SlideArray(Array);
        Heap = this.BuildMinHeap(Heap);
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
            Heap = this.BuildMinHeap(Heap);
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
            Heap = this.BuildMinHeap(Heap);
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
        return Pointer == 1;
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
    private int [] MinHeapify(int[] A, int i){

        int l = (2*i);
        int r = (2*i)+1;
        int lowerest;

        if(l <= HeapSize-1 && A[i] > A[l]){
            lowerest = l;
        }else{
            lowerest = i;
        }
        if (r <= HeapSize-1 && A[lowerest] > A[r]){
            lowerest = r;
        }
        if(lowerest != i) {
            int aux = A[i];
            A[i] = A[lowerest];
            A[lowerest] = aux;
            MinHeapify(A,lowerest);
        }
        return A;
    }

    private int [] BuildMinHeap(int [] A){

        int x = (HeapSize/2);
        for(int i = x; i>0; i--){
            MinHeapify(A,i);
        }
        return A;
    }




}
