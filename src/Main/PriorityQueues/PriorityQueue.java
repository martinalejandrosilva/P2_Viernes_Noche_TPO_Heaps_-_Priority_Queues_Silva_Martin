package Main.PriorityQueues;

public interface PriorityQueue {

    public void Initialize(int Size);
    public void Insert(int Value, int Priority);
    public int Peek();
    public int Extract(int Value);
    public void IncreaseKey(int Value, int NewPriority);
    public boolean isEmpty();
    public int Priority();
}


