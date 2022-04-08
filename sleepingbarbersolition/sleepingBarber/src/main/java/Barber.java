/**
 * This class represents the barber that cuts hair in the barbershop
 */
public class Barber implements Runnable{
    BarberShop shop;
    public Barber(BarberShop shop){
        this.shop = shop;
    }

    /**
     * runs the barber thread
     */
    public void run(){
        try{
            Thread.sleep(10000);
        } catch (Exception e){
            System.out.println("Error while running barber thread: "+ e.getMessage());
        }
        while(true){
            shop.cutHair();
        }
    }



}
