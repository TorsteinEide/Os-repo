import java.util.concurrent.TimeUnit;

/**
 * This class is responsible for creating costumers at random times
 */
public class CustomerGenerator implements Runnable{
    BarberShop shop;

    /**
     * Constructor initializes an object of class CustomerGenerator
     * @param shop shop in which the customers are going
     */
    public CustomerGenerator(BarberShop shop){
        this.shop=shop;
    }

    /**
     * runs in a continuous loop and creates customers
     */
    @Override
    public void run() {
        while(true){
            try{
                TimeUnit.SECONDS.sleep(shop.getRandomTime());
                Customer customer = new Customer(shop);
                Thread customerThread= new Thread(customer);
                customer.setName("Customer: "+customerThread.getId());
                customerThread.start();
            } catch (Exception e){
                System.out.println("error running customer thread: " + e.getMessage());
            }
        }
    }
}
