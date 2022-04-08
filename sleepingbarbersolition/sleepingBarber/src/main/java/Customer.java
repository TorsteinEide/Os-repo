/**
 * This class represents a costumer that wants a haircut in the barbershop
 */
public class Customer implements Runnable{
    BarberShop shop;
    String name;

    /**
     * Constructor initializes an object of class Costumer
     * @param shop
     */
    public Customer(BarberShop shop)
    {
        this.shop=shop;
    }

    /**
     * returns the name of a costumer
     * @return the name of a costumer
     */
    public String getName(){
        return this.name;
    }

    /**
     * sets the name of a customer
     * @param newName the new name that a customer is to be given
     */
    public void setName(String newName){
        this.name=newName;
    }

    /**
     * runs a customer thread
     */
    public void run(){
        goForHairCut();
    }

    /**
     * Synchronized method that adds a customer to the barbershop queue
     */
    public synchronized void goForHairCut(){
        shop.add(this);
    }
}
