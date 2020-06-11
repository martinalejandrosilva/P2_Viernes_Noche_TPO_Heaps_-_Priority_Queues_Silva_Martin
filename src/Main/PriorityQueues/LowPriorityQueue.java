package Main.PriorityQueues;

public class LowPriorityQueue implements PriorityQueue {
    
    private class Node {
        public int value;
        public int Priority;

        public Node(int Value, int Priority){
            this.value = Value;
            this.Priority = Priority;
        }
    }

    private Node[] Heap;
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
                Heap = this.BuildMixHeap(Heap);
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
            Heap = BuildMixHeap(Heap);
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

    private Node[] MinHeapify(Node[] A, int i){
        int l = (2*i)+1;
        int r = (2*i)+2;
        int lowerest;

        if(l <= Pointer && A[i].Priority > A[l].Priority){
            lowerest = l;
        }else{
            lowerest = i;
        }
        if (r <= Pointer && A[lowerest].Priority > A[r].Priority){
            lowerest = r;
        }
        if(lowerest != i) {
            Node aux = A[i];
            A[i] = A[lowerest];
            A[lowerest] = aux;
            MinHeapify(A,lowerest);
        }
        return A;
    }

    private Node[] BuildMixHeap(Node[] A){
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
            MinHeapify(A,i);
        }
        return A;
    }
}
