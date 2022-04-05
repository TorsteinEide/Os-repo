import java.awt.*;
import java.util.LinkedList;

/**
 * This class represents the barbershop in which the barber works, the chairs are and the costumers cut their hair
 */
public class BarberShop
{
    //fields
    private int LIMIT = 5;
    private Costumer[] costumers = new Costumer[10]; // 10 costumers who will leave and enter shop
    private Chair[] queueChairs = new Chair[5]; //five queue chairs
    private Chair barberChair = new Chair(); //chair where costumers get haircuts
    private Barber barber = new Barber(); //barber who gives haircuts

    /**
     * Constructor initializes an object of class BarberShop
     */
    public BarberShop() {}

    public void run()
    {

    }

    public Chair getBarberChair()
    {
        return this.barberChair;
    }

    public Chair[] getQueueChairs(){
        return this.queueChairs;
    }

    public int getLIMIT()
    {
        return this.LIMIT;
    }

    public void main()
    {
        for(int i=0; i<10; i++){
            Costumer[] costumers = new Costumer[i];
            costumers[i].start();
        }
    }

    public void initializeCostumers()
    {
        for(int i=0; i<10; i++){
            Costumer[] costumers = new Costumer[i];
            System.out.println("Thread: "+i+" started");
            costumers[i].start();
        }
    }

    public static void main(String[] args) {

        Costumer costumer1 = new Costumer();
        Costumer costumer2 = new Costumer();
        Costumer costumer3 = new Costumer();
        Costumer costumer4 = new Costumer();
        Costumer costumer5 = new Costumer();
        Costumer costumer6 = new Costumer();

        costumer1.start();
        costumer2.start();
        costumer3.start();
        costumer4.start();
        costumer5.start();
        costumer6.start();
    }


}
