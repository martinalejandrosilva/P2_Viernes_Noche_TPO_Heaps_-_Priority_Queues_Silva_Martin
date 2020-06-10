package Main.PriorityQueues;

public interface PriorityQueue {

    public void Insert(int Value, int Priority);
    public int Peek();
    public int Extract(int Value);
    public void IncreaseKey(int Value, int NewPriority);

}
