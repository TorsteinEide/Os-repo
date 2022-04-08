import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * This class represents the barbershop where the barber cuts hair and customers join the queue
 */
public class BarberShop {
    private final int BARBER_CHAIRS=5;
    private LinkedList<Customer> customerQueue;
    private Customer customer;

    /**
     * Constructor initializes an object of class BarberShop
     */
    public BarberShop(){
        customerQueue = new LinkedList<>();
    }

    /**
     * Checks the queue if there are any seats available, if so cuts the hair of the customer next in line
     */
    public void cutHair(){
        checkQueue();
        try{
            System.out.println("Cutting costumer: " + customer.getName() + "s hair");
            TimeUnit.SECONDS.sleep(getRandomTime());
        } catch (Exception e ){
            System.out.println("Error while cutting hair: " + e.getMessage());
        }
        System.out.println("completed cutting costumer: " + customer.getName() + "s hair");
    }

    /**
     * Checks the current queue
     */
    public void checkQueue(){
        synchronized (customerQueue){
            while(customerQueue.size()==0){
                try{
                    System.out.println("barber is waiting for customer.");
                    customerQueue.wait();
                } catch (Exception e){
                    System.out.println("error while barber waiting " + e.getMessage());
                }
            }
            System.out.println("barber found a customer in the queue and starts working");
            customer = customerQueue.poll();
        }
    }

    /**
     * Adds a customer to the customerQueue
     * @param customer customer to be added to the queue
     */
    public void add(Customer customer){
        System.out.println("customer: " + customer.getName() + " entered the barbershop");
        synchronized (customerQueue){
            if (customerQueue.size()==BARBER_CHAIRS){
                System.out.println("there are no available chairs for customer: " + customer.getName());
                return ;
            }
            customerQueue.offer(customer);
            System.out.println("customer: " + customer.getName() + " got the chair");
            System.out.println("queue size: " + customerQueue.size());

            if(!customerQueue.isEmpty()){
                customerQueue.notify();
            }
        }
    }

    /**
     * returns a random number between 0-10
     * @return a random number between 0-10
     */
    public int getRandomTime(){
        Random random = new Random();
        int randomTime = random.nextInt(10);
        return randomTime;
    }
}
