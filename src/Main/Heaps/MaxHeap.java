package Main.Heaps;

public class MaxHeap {

    private int [] Heap;
    private int Pointer;
    private int HeapSize;

    private boolean Dynamic;


    public MaxHeap(int Size, boolean Dynamic){
        Heap = new int[Size];
        Pointer = 0;
        HeapSize = Size;
        this.Dynamic = Dynamic;
    }

    public MaxHeap (int Size){
        Heap = new int[Size];
        Pointer = 0;
        HeapSize = Size;
        Dynamic = false;
    }

    public MaxHeap (boolean Dynamic){
        Heap = new int[1];
        Pointer = 0;
        HeapSize = 1;
        this.Dynamic = Dynamic;
    }
    public MaxHeap (int [] Array,boolean Dynamic ){
        HeapSize = Array.length;
        Pointer = Array.length ;
        this.Dynamic = Dynamic;
        Heap = this.BuildMaxHeap(Array);
    }

    public MaxHeap (int [] Array){
        HeapSize = Array.length;
        Pointer = Array.length;
        Dynamic = false;
        Heap = this.BuildMaxHeap(Array);
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
            Pointer++;
            Heap = this.BuildMaxHeap(Heap);
            //Pointer++;
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
            //HeapSize--;
            Heap = this.BuildMaxHeap(Heap);
        }
    }

    public int Peek(){
        return Heap[0];
    }

    public void PrintHeap(){
        if (Pointer == 0){
            System.out.println("The Array is Empty...");
        }else {
            for (int i = 0; i < Pointer; i++) {
                System.out.print(Heap[i] + ", ");
            }
        }
    }

    public int Exist(int x){
        int ArrayPosition = -1;
        for(byte i = 0; i<Pointer; i++){
            if(Heap[i] == x){
                ArrayPosition = i;
                break;
            }
        }
        return ArrayPosition;
    }

    public boolean isEmpty(){
        return (Pointer == 0);
    }

    private int [] ResizeArray(){
        int [] A = new int[HeapSize +1];
        for(int i = 0; i<HeapSize; i++){
            A[i] = Heap[i];
        }
        HeapSize++;
        return A;
    }

    //For The Max/Min Heap i don't want to expose the methods.
    private int [] MaxHeapify(int[] A, int i){
        int l = (2*i)+1;
        int r = (2*i)+2;
        int largest;

        if(l <= Pointer-1 && A[l] > A[i]){
            largest = l;
        }else{
            largest = i;
        }
        if (r <= Pointer-1 && A[r] > A[largest]){
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

        //int x = ((HeapSize/2))-1;
        int x = ((Pointer/2));
        for(int i = x; i>=0; i--){
            MaxHeapify(A,i);
        }
        return A;
    }
}
