package Main.Heaps;

public class MinHeap {

    private int [] Heap;
    private int Pointer;
    private int HeapSize;
    private boolean Dynamic;

    public MinHeap (){
        Heap = new int[1];
        Pointer = 0;
        HeapSize = 1;
        Dynamic = false;
    }

    public MinHeap (int Size){
        Heap = new int[Size];
        Pointer = 0;
        HeapSize = Size;
        Dynamic = false;
    }

    public MinHeap (boolean Dynamic){
        Heap = new int[1];
        Pointer = 0;
        HeapSize = 1;
        this.Dynamic = Dynamic;
    }
    public MinHeap (int [] Array,boolean Dynamic ){
        HeapSize = Array.length;
        Pointer = Array.length;
        this.Dynamic = Dynamic;
        Heap = this.BuildMinHeap(Array);
    }

    public MinHeap (int [] Array){
        HeapSize = Array.length;
        Pointer = Array.length;
        Dynamic = false;
        Heap = this.BuildMinHeap(Array);
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
        if(ElementIdx != -1){
            int Aux = Heap[Pointer-1];
            Heap[ElementIdx] = Aux;
            Pointer--;
            HeapSize--;
            Heap = this.BuildMinHeap(Heap);
        }
    }

    public int Peek(){
        return Heap[0];
    }

    public void PrintHeap(){
        for(int i = 0; i<HeapSize; i++){
            System.out.print(Heap[i] + ", ");
        }
    }

    public int Exist(int x){
        int ArrayPosition = -1;
        for(byte i = 0; i < HeapSize; i++){
            if(Heap[i] == x){
                ArrayPosition = i;
                break;
            }
        }
        return ArrayPosition;
    }

    public boolean isEmpty(){
        return Pointer == 0;
    }

    private int [] ResizeArray(){
        int [] A = new int[HeapSize+1];
        for(int i = 0; i<HeapSize; i++){
            A[i] = Heap[i];
        }
        HeapSize++;
        return A;
    }

    //For The Max/Min Heap i don't want to expose the methods.
    private int [] MinHeapify(int[] A, int i){

        int l = (2*i)+1;
        int r = (2*i)+2;
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

        //int x = (HeapSize/2)-1;
        int x = (HeapSize/2);
        for(int i = x; i>=0; i--){
            MinHeapify(A,i);
        }
        return A;
    }




}
