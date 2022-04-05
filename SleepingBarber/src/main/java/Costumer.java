import java.util.LinkedList;
import java.util.Random;

/**
 * This class represents a costumer who is waiting for a haircut
 */
public class Costumer extends Thread implements Runnable
{
    //fields
    BarberShop b = new BarberShop();
    CostumerQueue cq = new CostumerQueue();
    Barber barber = new Barber();

    public Costumer()
    {

    }

    @Override
    public void run() {
        try{
            synchronized (cq) {
                while (true) {
                    int waittime = getRandomTime();
                    System.out.println("Costumer wandering around outside for " + waittime / 1000 + " seconds");
                    sleep(waittime);
                    if (checkBarberQueue(cq.getCostumerQueue(), b.getLIMIT())) {
                        // check if the barber is not working, if not check if this costumer is the next in line
                        System.out.println("Queue was not full, costumer sat down");
                        if (!cq.getCostumerQueue().contains(this)) {
                            cq.joinQueue(this);
                        }
                        System.out.println("Queue now has " + cq.getCostumerQueue().size() + " of 5 costumers");
                        System.out.println("barberstatus: " + barber.isBarberAvailable());
                        if (barber.isBarberAvailable() && cq.getLastCostumer() == this) {
                            barber.toggleWorking();
                            // leave queue and sit in barber chair
                            cq.leaveQueue();
                            System.out.println("Costumer leaves queue to get haircut");
                            System.out.println("Barber is cutting hair");
                            sleep(20000);
                            // make barber available again
                            barber.toggleWorking();
                            System.out.println("barber is now available");
                        }
                    }
                    System.out.println("Queue was full, costumer left shop");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught while running Costumer: " + e.getMessage());
        }
    }

    public int getRandomTime()
    {
        Random random = new Random();
        int randomtime = random.nextInt(20);
        return randomtime * 1000;
    }

    public synchronized void notifyBarber()
    {
        //TODO: This should notify an object or something
        notifyAll();
    }

    public synchronized void waitForBarber()
    {
        //TODO: This method should make an object wait or something
        try {
            wait();
        } catch(Exception e){
            System.out.println("Exception caught in waitForBarber: " + e.getMessage());
        }
    }

    /**
     * Checks if the barber queue is full
     * @param queue the costumer queue
     * @param limit the maximum number of costumers that can sit in the queue
     * @throws Exception
     */
    public synchronized boolean checkBarberQueue(LinkedList queue, int limit) throws Exception
    {
        boolean seatAvailable=true;
        if(queue.size() == limit)
        {
            seatAvailable=false;
        }
        return seatAvailable;
    }
}
