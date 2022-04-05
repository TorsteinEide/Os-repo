import java.util.LinkedList;

public class CostumerQueue
{
    private final Object lock = new Object();
    private LinkedList<Costumer> costumerQueue = new LinkedList<>();

    public CostumerQueue(){

    }

    public synchronized void joinQueue(Costumer costumer){
        synchronized (lock){this.costumerQueue.add(costumer);}
    }

    public synchronized void leaveQueue(){
        synchronized (lock){this.costumerQueue.pop();}
    }

    public Costumer getLastCostumer()
    {
        return this.costumerQueue.getLast();
    }

    public LinkedList getCostumerQueue(){
        return this.costumerQueue;
    }
}
